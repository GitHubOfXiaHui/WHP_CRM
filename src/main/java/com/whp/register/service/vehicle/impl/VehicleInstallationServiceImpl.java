package com.whp.register.service.vehicle.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.RecordObject;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicle.VehicleInstallation;
import com.whp.register.repository.jpa.vehicle.VehicleInstallationDao;
import com.whp.register.service.vehicle.VehicleInstallationService;

@Service
@Transactional(readOnly = true)
public class VehicleInstallationServiceImpl extends BaseServiceImpl<VehicleInstallation, Long> implements VehicleInstallationService {

	@Autowired
	public VehicleInstallationServiceImpl(VehicleInstallationDao vehicleInstallationDao) {
		super(vehicleInstallationDao);
	}

	@Override
	public void modifyInstallations(Vehicle entity, Vehicle vehicle, ShiroUser shiroUser) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<VehicleInstallation> oldInstallations = entity.getInstallationList();
		List<VehicleInstallation> newInstallations = vehicle.getInstallationList();
		
		ListIterator<VehicleInstallation> oldit = oldInstallations.listIterator();
		while (oldit.hasNext()) {
			VehicleInstallation installation = oldit.next();
			if (!newInstallations.contains(installation)) {
				// 删除
				installation.setStatus(RecordObject.OBSOLETE);
				installation.setObsoleteUser(shiroUser.getUser().getUsername());
				installation.setObsoleteDate(new Date());
				installation.setParent(null);
				oldit.remove();
			}
		}
		
		for (VehicleInstallation newInstallation : newInstallations) {
			if (oldInstallations.contains(newInstallation)) {
				// 更新
				update(oldInstallations, newInstallation);
			} else {
				// 增加
				newInstallation.setStatus(RecordObject.CREATE);
				newInstallation.setCreateUser(shiroUser.getUser().getUsername());
				newInstallation.setCreateDate(new Date());
				newInstallation.setParent(entity);
				oldInstallations.add(newInstallation);
			}
		}

	}
	
	private void update(List<VehicleInstallation> oldInstallations, VehicleInstallation newInstallation) throws IllegalArgumentException, IllegalAccessException {
		VehicleInstallation oldInstallation = oldInstallations.get(oldInstallations.indexOf(newInstallation));
		Field[] fields = oldInstallation.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isFinal(field.getModifiers())) {
				continue;
			}
			field.setAccessible(true);
			field.set(oldInstallation, field.get(newInstallation));
		}
	}

}
