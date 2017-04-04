package com.whp.register.service.vehicle.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.framework.utils.DateUtil;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInsurance;
import com.whp.register.repository.jpa.vehicle.VehicleInsuranceDao;
import com.whp.register.service.vehicle.VehicleInsuranceService;

/**
 * @author tongjian
 *
 */
@Service
@Transactional(readOnly = true)
public class VehicleInsuranceServiceImpl extends BaseServiceImpl<VehicleInsurance, Long>
		implements VehicleInsuranceService {

	private VehicleInsuranceDao dao;
	
	@Autowired
	public VehicleInsuranceServiceImpl(VehicleInsuranceDao dao) {
		super(dao);
		this.dao = dao;
	}

	
	/* 
	 * @see com.whp.register.service.vehicle.VehicleInsuranceService#setInsurance(java.util.List, com.whp.framework.shiro.ShiroDbRealm.ShiroUser)
	 * 自动补充保险信息字段
	 */
	public List<VehicleInsurance> setInsurance(Vehicle vehicle, ShiroUser shiroUser) {
		// TODO Auto-generated method stub
		for (VehicleInsurance insurance : vehicle.getInsuranceList()) {
			insurance.setStatus("10");
			insurance.setCreateUser(shiroUser.getUser().getUsername());
			insurance.setCreateDate(new Date());
			insurance.setParent(vehicle);
			setValidity(insurance);
		}
		return vehicle.getInsuranceList();
	}

	/**
	 * @param insurance
	 *            根据保险过期时间设置保险有效性 
	 *            过期时间大于当前时间则保险有效
	 */
	private void setValidity(VehicleInsurance insurance) {
		// TODO Auto-generated method stub
		switch (DateUtil.compare(insurance.getExpireTime(), new Date())) {
		case 1:
			insurance.setInsuranceValidity("1");
			break;
		case 0:
			insurance.setInsuranceValidity("1");
			break;
		case -1:
			insurance.setInsuranceValidity("0");
			break;
		default:
			break;
		}
	}

}
