package com.whp.register.service.vehicleApplications;

import com.whp.framework.exception.ServiceException;
import com.whp.framework.service.BaseService;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicleApplications.VehicleApplications;

public interface VehicleApplicationsService extends BaseService<VehicleApplications, Long> {

	/**
	 * 申请使用车辆
	 * @param vehicleId
	 * @param application
	 * @param shiroUser
	 * @return
	 * @throws ServiceException
	 */
	Vehicle applicate(Long vehicleId, VehicleApplications application, ShiroUser shiroUser) throws ServiceException;

	/**
	 * 审批通过
	 * @param applications
	 * @return
	 */
	void approvalPass(VehicleApplications applications);

	/**
	 * 驳回申请
	 * @param applications
	 */
	void approvalReject(VehicleApplications applications);
	
	/**
	 * 还车
	 * @param id
	 */
	VehicleApplications vehicleReturn(VehicleApplications applicationNew,VehicleApplications application);

}
