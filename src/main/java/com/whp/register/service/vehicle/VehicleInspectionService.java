package com.whp.register.service.vehicle;

import com.whp.framework.service.BaseService;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInspection;

public interface VehicleInspectionService extends BaseService<VehicleInspection, Long> {

	/**
	 * 修改车辆年审信息
	 * @param vehicle
	 */
	void modifyInspections(Vehicle entity, Vehicle vehicle, ShiroUser shiroUser) throws IllegalArgumentException, IllegalAccessException;
	
}
