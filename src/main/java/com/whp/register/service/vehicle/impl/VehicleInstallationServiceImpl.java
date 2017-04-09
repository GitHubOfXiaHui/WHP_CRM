package com.whp.register.service.vehicle.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.RecordObject;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInstallation;
import com.whp.register.repository.jpa.vehicle.VehicleInstallationDao;
import com.whp.register.service.vehicle.VehicleInstallationService;

@Service
@Transactional(readOnly = true)
public class VehicleInstallationServiceImpl extends BaseServiceImpl<VehicleInstallation, Long> implements VehicleInstallationService {

	private VehicleInstallationDao vehicleInstallationDao;
	
	@Autowired
	public VehicleInstallationServiceImpl(VehicleInstallationDao vehicleInstallationDao) {
		super(vehicleInstallationDao);
		this.vehicleInstallationDao = vehicleInstallationDao;
	}

	@Override
	public List<VehicleInstallation> setInstallation(Vehicle vehicle, ShiroUser shiroUser) {
		// TODO Auto-generated method stub
		for (VehicleInstallation installation : vehicle.getInstallationList()) {
			installation.setStatus(RecordObject.CREATE);
			installation.setCreateUser(shiroUser.getUser().getUsername());
			installation.setCreateDate(new Date());
			installation.setParent(vehicle);
		}
		return vehicle.getInstallationList();
	}

}
