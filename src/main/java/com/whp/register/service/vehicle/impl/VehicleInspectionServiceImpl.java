package com.whp.register.service.vehicle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.service.BaseServiceImpl;
import com.whp.register.entity.vehicle.VehicleInspection;
import com.whp.register.repository.jpa.vehicle.VehicleInspectionDao;
import com.whp.register.service.vehicle.VehicleInspectionService;

@Service
@Transactional(readOnly = true)
public class VehicleInspectionServiceImpl extends BaseServiceImpl<VehicleInspection, Long> implements VehicleInspectionService {

	private VehicleInspectionDao vehicleInspectionDao;
	
	@Autowired
	public VehicleInspectionServiceImpl(VehicleInspectionDao vehicleInspectionDao) {
		super(vehicleInspectionDao);
		this.vehicleInspectionDao = vehicleInspectionDao;
	}

}
