package com.whp.register.service.vehicleRepair;

import com.whp.framework.service.BaseService;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicleRepair.VehicleRepair;

public interface VehicleRepairService  extends BaseService<VehicleRepair, Long>{

	Vehicle applicate(Long vehicleId, VehicleRepair repair, ShiroUser shiroUser);

	void approvalPass(Long id);

	void approvalReject(Long id);

	VehicleRepair vehicleReturn(VehicleRepair repairNew, VehicleRepair repair);

}
