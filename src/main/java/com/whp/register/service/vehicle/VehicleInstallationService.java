package com.whp.register.service.vehicle;

import com.whp.framework.service.BaseService;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInstallation;

public interface VehicleInstallationService extends BaseService<VehicleInstallation, Long> {

	void modifyInstallations(Vehicle entity, Vehicle vehicle, ShiroUser shiroUser) throws IllegalArgumentException, IllegalAccessException;
	
}
