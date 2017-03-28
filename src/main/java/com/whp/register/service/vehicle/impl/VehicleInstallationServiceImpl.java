package com.whp.register.service.vehicle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.service.BaseServiceImpl;
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

}
