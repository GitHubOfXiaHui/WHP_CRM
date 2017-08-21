package com.whp.register.service.vehicleRepair.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.RecordObject;
import com.whp.framework.entity.main.Config;
import com.whp.framework.repository.jpa.main.ConfigDAO;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.entity.vehicleRepair.VehicleRepair;
import com.whp.register.repository.jpa.vehicle.VehicleDao;
import com.whp.register.repository.jpa.vehicleRepair.VehicleRepairDao;
import com.whp.register.service.vehicleRepair.VehicleRepairService;

@Service
@Transactional(readOnly = true)
public class VehicleRepairServiceImpl extends BaseServiceImpl<VehicleRepair, Long>
implements VehicleRepairService{
	
	@Autowired
	private VehicleDao vehilceDao;
	
	@Autowired
	private ConfigDAO configDAO;
	
	private VehicleRepairDao dao;
	
	@Autowired
	public VehicleRepairServiceImpl(VehicleRepairDao vehicleRepairDao) {
		super(vehicleRepairDao);
		this.dao = vehicleRepairDao;
	}

	@Override
	@Transactional
	public Vehicle applicate(Long vehicleId, VehicleRepair repair, ShiroUser shiroUser) {
		// TODO Auto-generated method stub
		
		
		repair.setStatus(RecordObject.CREATE);
		repair.setCreateUser(shiroUser.getUser().getUsername());
		repair.setCreateDate(new Date());
		
		repair.setApplicationUser(shiroUser.getUser());
		
		if(repair.getPrice()<2000&&repair.getPrice()>=1000)
			repair.setRequireApproval1(true);
		if(repair.getPrice()>=2000){
			repair.setRequireApproval1(true);
			repair.setRequireApproval(true);
		}
			
		
		repair.setAudit2User(getAuditUser(2));
		if(repair.isRequireApproval())
			repair.setAudit3User(getAuditUser(3));
		
		repair.setOrgAuth(shiroUser.getUser().getOrganization().getId().toString());
		repair.setUserAuth(shiroUser.getUser().getUsername());
		
		Vehicle vehicle = vehilceDao.findOne(vehicleId);
		vehicle.setVehicleStatus(Vehicle.USING);
		repair.setParent(vehicle);
		vehicle.getRepairs().add(repair);
		
		
		return vehicle;
	}

	private String getAuditUser(int i) {
		if (i == 2) {
			Config config=configDAO.findByKey("repairCarAudit2User").get(0);
			if(null!=config)
			return config.getValue();
		}else if(i == 3){
			Config config=configDAO.findByKey("repairCarAudit3User").get(0);
			if(null!=config)
			return config.getValue();
		}
		return null;
	}

	@Override
	@Transactional
	public void approvalPass(VehicleRepair repairs) {
		// TODO Auto-generated method stub
		VehicleRepair repair = dao.findOne(repairs.getId());
		if (repair.getApprovalStatus().equals(VehicleRepair.APPROVAL1)) {
			if (repair.isRequireApproval1()) {
				repair.setApprovalStatus(VehicleApplications.APPROVAL2);
				repair.setAuditUser(repair.getAudit2User());
				repair.setAudit1Date(new Date());
			} else {
				repair.setAudit1Date(new Date());
				repair.setApprovalStatus(VehicleRepair.PASS);
			}
			repair.setAudit1Username(repairs.getAudit1Username());
			update(repair);
		} else if (repair.getApprovalStatus().equals(VehicleRepair.APPROVAL2)) {
			// 需要局领导审批
			if (repair.isRequireApproval()) {
				repair.setApprovalStatus(VehicleRepair.APPROVAL3);
				repair.setAuditUser(repair.getAudit3User());
				repair.setAudit2Date(new Date());
			} else {
				repair.setAudit2Date(new Date());
				repair.setApprovalStatus(VehicleRepair.PASS);
			}
			repair.setAudit2Username(repairs.getAudit1Username());
			update(repair);
		} else if (repair.getApprovalStatus().equals(VehicleRepair.APPROVAL3)) {
			repair.setApprovalStatus(VehicleRepair.PASS);
			repair.setAudit3Username(repairs.getAudit1Username());
			update(repair);
		}
	}

	@Override
	@Transactional
	public void approvalReject(VehicleRepair repairs) {
		// TODO Auto-generated method stub
		VehicleRepair repair = dao.findOne(repairs.getId());
		if (repair.getApprovalStatus().equals(VehicleRepair.APPROVAL1)) {
			reject(repair);
			repair.setRejectUser(repair.getAudit1User());
			repair.setAudit1Username(repairs.getAudit1Username());
			dao.save(repair);
		}else if (repair.getApprovalStatus().equals(VehicleRepair.APPROVAL2)) {
			reject(repair);
			repair.setRejectUser(repair.getAudit2User());
			repair.setAudit2Username(repairs.getAudit1Username());
			dao.save(repair);
		}else if (repair.getApprovalStatus().equals(VehicleRepair.APPROVAL3)) {
			reject(repair);
			repair.setRejectUser(repair.getAudit3User());
			repair.setAudit3Username(repairs.getAudit1Username());
			dao.save(repair);
		}
	}
	
	private void reject(VehicleRepair repair) {
		repair.setApprovalStatus(VehicleRepair.REJECT);
		repair.setRejectDate(new Date());
	}

	@Override
	public VehicleRepair vehicleReturn(VehicleRepair repairNew, VehicleRepair repair) {
		// TODO Auto-generated method stub
		repairNew.setActualEndTime(repair.getActualEndTime());
		repairNew.setActualPrice(repair.getActualPrice());
		repairNew.setAffirmDate(new Date());
		repairNew.setAffirmRemark(repair.getAffirmRemark());
		repairNew.setApprovalStatus(VehicleRepair.RETURN);
		repairNew.getParent().setVehicleStatus(Vehicle.IDLE);
		return repairNew;
	}
}
