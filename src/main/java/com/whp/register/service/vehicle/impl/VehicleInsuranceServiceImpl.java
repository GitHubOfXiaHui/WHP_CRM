package com.whp.register.service.vehicle.impl;

import com.whp.framework.service.BaseServiceImpl;
import com.whp.register.entity.vehicle.VehicleInsurance;
import com.whp.register.repository.jpa.vehicle.VehicleInsuranceDao;
import com.whp.register.service.vehicle.VehicleInsuranceService;

public class VehicleInsuranceServiceImpl extends BaseServiceImpl<VehicleInsurance, Long> implements VehicleInsuranceService{

	private VehicleInsuranceDao dao;
	
	public VehicleInsuranceServiceImpl(VehicleInsuranceDao dao) {
		super(dao);
		this.dao=dao;
		// TODO Auto-generated constructor stub
	}


}
