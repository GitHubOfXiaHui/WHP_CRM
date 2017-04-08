package com.whp.register.service.vehicleApplications.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.service.BaseServiceImpl;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.repository.jpa.vehicleApplications.VehicleApplicationsDao;
import com.whp.register.service.vehicleApplications.VehicleApplicationsService;

@Service
@Transactional(readOnly = true)
public class VehicleApplicationsServiceImpl extends BaseServiceImpl<VehicleApplications, Long> implements VehicleApplicationsService {

	private VehicleApplicationsDao vehicleApplicationsDao;
	
	@Autowired
	public VehicleApplicationsServiceImpl(VehicleApplicationsDao vehicleApplicationsDao) {
		super(vehicleApplicationsDao);
		this.vehicleApplicationsDao = vehicleApplicationsDao;
	}

}
