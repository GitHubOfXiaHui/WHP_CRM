package com.whp.register.service.vehicleApplications.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.RecordObject;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.repository.jpa.vehicle.VehicleDao;
import com.whp.register.repository.jpa.vehicleApplications.VehicleApplicationsDao;
import com.whp.register.service.vehicleApplications.VehicleApplicationsService;

@Service
@Transactional(readOnly = true)
public class VehicleApplicationsServiceImpl extends BaseServiceImpl<VehicleApplications, Long> implements VehicleApplicationsService {

	@Autowired
	private VehicleDao vehilceDao;
	
	private VehicleApplicationsDao vehicleApplicationsDao;
	
	@Autowired
	public VehicleApplicationsServiceImpl(VehicleApplicationsDao vehicleApplicationsDao) {
		super(vehicleApplicationsDao);
		this.vehicleApplicationsDao = vehicleApplicationsDao;
	}

	@Override
	@Transactional
	public Vehicle applicate(Long vehicleId, VehicleApplications application, ShiroUser shiroUser) throws ServiceException {
		// TODO Auto-generated method stub
		Vehicle vehicle = vehilceDao.findOne(vehicleId);
//		if (!vehicle.getVehicleStatus().equals(Vehicle.IDLE)) {
//			throw new ServiceException("该车辆(" + vehicle.getLicense() + ")无法使用。");
//		}
//		vehicle.setVehicleStatus(Vehicle.USING);
		vehicle.getApplicationList().add(application);
		
		application.setStatus(RecordObject.CREATE);
		application.setCreateUser(shiroUser.getUser().getUsername());
		application.setCreateDate(new Date());
		
		application.setApplicationUser(shiroUser.getUser());
		application.setParent(vehicle);
		
		application.setOrgAuth(shiroUser.getUser().getOrganization().getCode());
		application.setUserAuth(shiroUser.getUser().getUsername());
		
		return vehicle;
	}

	@Override
	@Transactional
	public void approval1Pass(Long id) {
		
		VehicleApplications application = vehicleApplicationsDao.findOne(id);
		if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL1)) {
			application.setApprovalStatus(VehicleApplications.APPROVAL2);
			vehicleApplicationsDao.save(application);
		}
		
	}

	@Override
	@Transactional
	public void approval2Pass(Long id) {
		
		VehicleApplications application = vehicleApplicationsDao.findOne(id);
		if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL2)) {
			// 需要局领导审批
			if (application.isRequireApproval()) {
				application.setApprovalStatus(VehicleApplications.APPROVAL3);
			} else {
				application.setApprovalStatus(VehicleApplications.PASS);
			}
			vehicleApplicationsDao.save(application);
		}
		
	}

	@Override
	@Transactional
	public void approval3Pass(Long id) {
		
		VehicleApplications application = vehicleApplicationsDao.findOne(id);
		if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL3)) {
			application.setApprovalStatus(VehicleApplications.PASS);
			vehicleApplicationsDao.save(application);
		}
		
	}

	@Override
	@Transactional
	public void approval1Reject(Long id) {
		// TODO Auto-generated method stub
		VehicleApplications application = vehicleApplicationsDao.findOne(id);
		if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL1)) {
			reject(application);
			vehicleApplicationsDao.save(application);
		}
	}
	
	@Override
	@Transactional
	public void approval2Reject(Long id) {
		// TODO Auto-generated method stub
		VehicleApplications application = vehicleApplicationsDao.findOne(id);
		if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL2)) {
			reject(application);
			vehicleApplicationsDao.save(application);
		}
	}
	
	@Override
	@Transactional
	public void approval3Reject(Long id) {
		// TODO Auto-generated method stub
		VehicleApplications application = vehicleApplicationsDao.findOne(id);
		if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL3)) {
			reject(application);
			vehicleApplicationsDao.save(application);
		}
	}
	
	private void reject(VehicleApplications application) {
		application.setApprovalStatus(VehicleApplications.REJECT);
	}

}
