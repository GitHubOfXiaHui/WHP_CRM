package com.whp.register.service.vehicleApplications.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.RecordObject;
import com.whp.framework.entity.main.Config;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.repository.jpa.main.ConfigDAO;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.repository.jpa.vehicle.VehicleDao;
import com.whp.register.repository.jpa.vehicleApplications.VehicleApplicationsDao;
import com.whp.register.service.vehicleApplications.VehicleApplicationsService;

@Service
@Transactional(readOnly = true)
public class VehicleApplicationsServiceImpl extends BaseServiceImpl<VehicleApplications, Long>
		implements VehicleApplicationsService {

	@Autowired
	private VehicleDao vehilceDao;

	@Autowired
	private ConfigDAO configDAO;

	private VehicleApplicationsDao vehicleApplicationsDao;

	@Autowired
	public VehicleApplicationsServiceImpl(VehicleApplicationsDao vehicleApplicationsDao) {
		super(vehicleApplicationsDao);
		this.vehicleApplicationsDao = vehicleApplicationsDao;
	}

	@Override
	@Transactional
	public Vehicle applicate(Long vehicleId, VehicleApplications application, ShiroUser shiroUser)
			throws ServiceException {
		// TODO Auto-generated method stub
		Vehicle vehicle = vehilceDao.findOne(vehicleId);
		// if (!vehicle.getVehicleStatus().equals(Vehicle.IDLE)) {
		// throw new ServiceException("该车辆(" + vehicle.getLicense() + ")无法使用。");
		// }
		vehicle.setVehicleStatus(Vehicle.USING);
		vehicle.getApplicationList().add(application);

		application.setStatus(RecordObject.CREATE);
		application.setCreateUser(shiroUser.getUser().getUsername());
		application.setCreateDate(new Date());

		application.setApplicationUser(shiroUser.getUser());
		application.setParent(vehicle);

		application.setAudit2User(getAuditUser(2));
		if(application.isRequireApproval())
		application.setAudit3User(getAuditUser(3));

		application.setOrgAuth(shiroUser.getUser().getOrganization().getId().toString());
		application.setUserAuth(shiroUser.getUser().getUsername());

		return vehicle;
	}

	private String getAuditUser(int i) {
		if (i == 2) {
			Config config=configDAO.findByKey("useCarAudit2User").get(0);
			if(null!=config)
			return config.getValue();
		}else if(i == 3){
			Config config=configDAO.findByKey("useCarAudit3User").get(0);
			if(null!=config)
			return config.getValue();
		}
		return null;
	}

	@Override
	@Transactional
	public void approvalPass(VehicleApplications applications) {

		VehicleApplications application = vehicleApplicationsDao.findOne(applications.getId());
		/*if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL1)) {
			application.setApprovalStatus(VehicleApplications.APPROVAL2);
			application.setAuditUser(application.getAudit2User());
			application.setAudit1Date(new Date());
			vehicleApplicationsDao.save(application);
		} else */if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL1)) {
			// 需要局领导审批
			if (application.isRequireApproval()) {
				application.setApprovalStatus(VehicleApplications.APPROVAL3);
				application.setAuditUser(application.getAudit3User());
				application.setAudit1Date(new Date());
			} else {
				application.setAudit1Date(new Date());
				application.setApprovalStatus(VehicleApplications.PASS);
			}
			application.setAudit1Username(applications.getAudit1Username());
			vehicleApplicationsDao.save(application);
		} else if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL3)) {
			application.setApprovalStatus(VehicleApplications.PASS);
			application.setAudit3Username(applications.getAudit1Username());
			vehicleApplicationsDao.save(application);
		}
	}

	@Override
	@Transactional
	public void approvalReject(VehicleApplications applications) {
		// TODO Auto-generated method stub
		VehicleApplications application = vehicleApplicationsDao.findOne(applications.getId());
		if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL1)) {
			reject(application);
			application.setRejectUser(application.getAudit1User());
			application.setAudit1Username(applications.getAudit1Username());
			vehicleApplicationsDao.save(application);
		}else if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL2)) {
			reject(application);
			application.setRejectUser(application.getAudit2User());
			application.setAudit2Username(applications.getAudit1Username());
			vehicleApplicationsDao.save(application);
		}else if (application.getApprovalStatus().equals(VehicleApplications.APPROVAL3)) {
			reject(application);
			application.setRejectUser(application.getAudit3User());
			application.setAudit3Username(applications.getAudit1Username());
			vehicleApplicationsDao.save(application);
		}
	}

	private void reject(VehicleApplications application) {
		application.setApprovalStatus(VehicleApplications.REJECT);
		application.setRejectDate(new Date());
	}

	public VehicleApplications vehicleReturn(VehicleApplications applicationNew,VehicleApplications application) {
		// TODO Auto-generated method stub
		applicationNew.setAccident(application.isAccident());
		applicationNew.setActualDriver(application.getActualDriver());
		applicationNew.setEndFGReading(application.getEndFGReading());
		applicationNew.setReturnDate(new Date());
		applicationNew.setReturnRemark(application.getReturnRemark());
		applicationNew.setReturnSite(application.getReturnSite());
		applicationNew.setStartFGReading(application.getStartFGReading());
		applicationNew.setAccidentRemark(application.getAccidentRemark());
		applicationNew.setApprovalStatus(VehicleApplications.RETURN);
		applicationNew.getParent().setVehicleStatus(Vehicle.IDLE);
		return applicationNew;
	}

}
