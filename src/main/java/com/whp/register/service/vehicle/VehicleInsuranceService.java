package com.whp.register.service.vehicle;

import java.util.List;

import com.whp.framework.service.BaseService;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInsurance;

public interface VehicleInsuranceService extends BaseService<VehicleInsurance, Long> {

	List<VehicleInsurance> setInsurance(Vehicle vehicle, ShiroUser shiroUser);

}
