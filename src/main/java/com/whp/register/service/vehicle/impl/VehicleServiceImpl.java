package com.whp.register.service.vehicle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.exception.ExistedException;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.repository.jpa.vehicle.VehicleDao;
import com.whp.register.service.vehicle.VehicleService;

@Service
@Transactional(readOnly = true)
public class VehicleServiceImpl extends BaseServiceImpl<Vehicle, Long> implements VehicleService {

	private VehicleDao vehicleDao;
	
	@Autowired
	public VehicleServiceImpl(VehicleDao vehicleDao) {
		super(vehicleDao);
		this.vehicleDao = vehicleDao;
	}
	
	@Override
	@Transactional
	public void save(Vehicle vehicle) throws ExistedException {
		if (hasLicense(vehicle.getLicense())) {
			throw new ExistedException("车辆信息添加失败，车牌号："+vehicle.getLicense()+"已存在");
		}
		vehicleDao.save(vehicle);
	}
	
	// 判断车牌号是否已经存在
	private boolean hasLicense(String license) {
		return vehicleDao.findByLicense(license) != null;
	}

}
