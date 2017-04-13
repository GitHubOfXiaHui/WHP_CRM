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
import com.whp.register.entity.vehicle.VehicleInspection;
import com.whp.register.repository.jpa.vehicle.VehicleInspectionDao;
import com.whp.register.service.vehicle.VehicleInspectionService;

@Service
@Transactional(readOnly = true)
public class VehicleInspectionServiceImpl extends BaseServiceImpl<VehicleInspection, Long> implements VehicleInspectionService {
	
	@Autowired
	public VehicleInspectionServiceImpl(VehicleInspectionDao vehicleInspectionDao) {
		super(vehicleInspectionDao);
	}

	@Override
	public void modifyInspections(Vehicle entity, Vehicle vehicle, ShiroUser shiroUser) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<VehicleInspection> oldInspections = entity.getInspectionList();
		List<VehicleInspection> newInspections = vehicle.getInspectionList();
		
		ListIterator<VehicleInspection> oldit = oldInspections.listIterator();
		while (oldit.hasNext()) {
			VehicleInspection inspection = oldit.next();
			if (!newInspections.contains(inspection)) {
				// 删除
				inspection.setStatus(RecordObject.OBSOLETE);
				inspection.setObsoleteUser(shiroUser.getUser().getUsername());
				inspection.setObsoleteDate(new Date());
				inspection.setParent(null);
				oldit.remove();
			}
		}
		
		for (VehicleInspection newInspection : newInspections) {
			if (oldInspections.contains(newInspection)) {
				// 更新
				update(oldInspections, newInspection);
			} else {
				// 增加
				newInspection.setStatus(RecordObject.CREATE);
				newInspection.setCreateUser(shiroUser.getUser().getUsername());
				newInspection.setCreateDate(new Date());
				newInspection.setParent(entity);
				oldInspections.add(newInspection);
			}
		}
		
		// 年审信息状态
		entity.setRecordedInspection(!entity.getInspectionList().isEmpty());
	}
	
	/**
	 * 更新业务逻辑字段，保留记录字段
	 * @param oldInspections
	 * @param newInspection
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private void update(List<VehicleInspection> oldInspections, VehicleInspection newInspection) throws IllegalArgumentException, IllegalAccessException {
		VehicleInspection oldInspection = oldInspections.get(oldInspections.indexOf(newInspection));
		Field[] fields = oldInspection.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isFinal(field.getModifiers())) {
				continue;
			}
			field.setAccessible(true);
			field.set(oldInspection, field.get(newInspection));
		}
	}

}
