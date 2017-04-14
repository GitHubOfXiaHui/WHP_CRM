package com.whp.register.controller.vehicle;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.web.Servlets;

import com.whp.framework.controller.BaseController;
import com.whp.framework.log.Log;
import com.whp.framework.log.LogMessageObject;
import com.whp.framework.log.impl.LogUitl;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.service.vehicle.VehicleInstallationService;
import com.whp.register.service.vehicle.VehicleService;

@Controller
@RequestMapping("/management/vehicle/installation")
public class VehicleInstallationController extends BaseController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleInstallationService installationService;
	
	private static final String LIST = "management/vehicle/installation/list";
	private static final String RECORD = "management/vehicle/installation/record";
	private static final String VIEW = "management/vehicle/installation/view";

	//@RequiresPermissions("VehicleInstallation:view")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("vehicles", vehicles);
		map.putAll(searchParams);

		return LIST;
	}
	
	//@RequiresPermissions("VehicleInspection:save")
	@RequestMapping(value = "/record/{id}", method = RequestMethod.GET)
	public String preRecord(@PathVariable Long id, Map<String, Object> map) {
		Vehicle vehicle = vehicleService.get(id);
		map.put("vehicle", vehicle);
		return RECORD;
	}
	
	@Log(message = "修改了车牌号为{0}的车辆加装信息。")
	//@RequiresPermissions("VehicleInspection:save")
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	@ResponseBody
	public String record(Vehicle vehicle) {
		BeanValidators.validateWithException(validator, vehicle);
		
		Vehicle entity = vehicleService.get(vehicle.getId());
		try {
			installationService.modifyInstallations(entity, vehicle, getShiroUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return AjaxObject.newError("系统忙，请稍候再试。").setCallbackType("").toString();
		}
		vehicleService.update(entity);
		
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { entity.getLicense() }));
		return AjaxObject.newOk("修改车辆加装信息成功。").toString();
	}

	//@RequiresPermissions("VehicleInstallation:view")
	@RequestMapping(value = "/view/{id}", method = { RequestMethod.GET })
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Vehicle entity = vehicleService.get(id);
		map.put("entity", entity);
		return VIEW;
	}

}
