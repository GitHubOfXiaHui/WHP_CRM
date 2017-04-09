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
	 * 所领导审批通过
	 * @param id
	 * @return
	 */
	void approval1Pass(Long id);

	/**
	 * 吴主任审批通过
	 * @param id
	 * @return
	 */
	void approval2Pass(Long id);

	/**
	 * 局领导审批通过
	 * @param id
	 * @return
	 */
	void approval3Pass(Long id);

	/**
	 * 所领导驳回申请
	 * @param id
	 */
	void approval1Reject(Long id);

	/**
	 * 吴主任驳回申请
	 * @param id
	 */
	void approval2Reject(Long id);

	/**
	 * 局领导驳回申请
	 * @param id
	 */
	void approval3Reject(Long id);

}
