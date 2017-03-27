package com.whp.register.repository.jpa.vehicle;

import com.whp.framework.repository.jpa.BaseJpaDao;
import com.whp.register.entity.vehicle.Vehicle;

public interface VehicleDao extends BaseJpaDao<Vehicle, Long> {

	Vehicle findByLicense(String license);
}
