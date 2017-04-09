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

	@Override
	public List<VehicleInspection> setInspection(Vehicle vehicle, ShiroUser shiroUser) {
		// TODO Auto-generated method stub
		for (VehicleInspection inspection : vehicle.getInspectionList()) {
			inspection.setStatus(RecordObject.CREATE);
			inspection.setCreateUser(shiroUser.getUser().getUsername());
			inspection.setCreateDate(new Date());
			inspection.setParent(vehicle);
		}
		return vehicle.getInspectionList();
	}

}
