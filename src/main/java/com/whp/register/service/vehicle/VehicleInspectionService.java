package com.whp.register.service.vehicle;

import java.util.List;

import com.whp.framework.service.BaseService;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInspection;

public interface VehicleInspectionService extends BaseService<VehicleInspection, Long> {

	List<VehicleInspection> setInspection(Vehicle vehicle, ShiroUser shiroUser);
	
}
