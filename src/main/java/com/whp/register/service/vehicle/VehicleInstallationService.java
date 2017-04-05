package com.whp.register.service.vehicle;

import java.util.List;

import com.whp.framework.service.BaseService;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInstallation;

public interface VehicleInstallationService extends BaseService<VehicleInstallation, Long> {

	List<VehicleInstallation> setInstallation(Vehicle vehicle, ShiroUser shiroUser);
	
}
