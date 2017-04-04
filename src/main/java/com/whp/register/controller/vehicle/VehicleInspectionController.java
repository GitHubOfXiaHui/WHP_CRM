package com.whp.register.controller.vehicle;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Validator;

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
import com.whp.register.entity.vehicle.VehicleInspection;
import com.whp.register.service.vehicle.VehicleInspectionService;
import com.whp.register.service.vehicle.VehicleService;

/**
 * 车辆年审信息控制器
 * @author xiahui
 *
 */
@Controller
@RequestMapping("/management/vehicle/inspection")
public class VehicleInspectionController extends BaseController {
	
	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleInspectionService vehicleInspectionService;
	
	private static final String LIST = "management/vehicle/inspection/list";
	private static final String CREATE = "management/vehicle/inspection/create";
	private static final String VIEW = "management/vehicle/inspection/view";
	
	//@RequiresPermissions("VehicleInspection:view")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);

		model.put("page", page);
		model.put("vehicles", vehicles);
		model.putAll(searchParams);

		return LIST;
	}
	
	//@RequiresPermissions("VehicleInspection:save")
	@RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
	public String preCreate(@PathVariable Long id, Map<String, Object> model) {
		Vehicle vehicle = vehicleService.get(id);
		if ("1".equals(vehicle.getInspectionStatus())) {
			return null;
		}
		model.put("vehicle", vehicle);
		return CREATE;
	}
	
	@Log(message = "添加了车牌号为{0}的车辆年审信息。")
	//@RequiresPermissions("VehicleInspection:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(Vehicle vehicle) {
		BeanValidators.validateWithException(validator, vehicle);
		Vehicle entity = vehicleService.get(vehicle.getId());
		if (vehicle.getInspectionList().isEmpty()) {
			return AjaxObject.newError("未添加年审信息").toString();
		} else {
			entity.setInspectionList(vehicleInspectionService.setInspection(vehicle, getShiroUser()));
			entity.setInspectionStatus("1");
			vehicleService.update(entity);
		}
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { vehicle.getLicense() }));
		return AjaxObject.newOk("录入车辆年审信息成功。").toString();
	}
	
	//@RequiresPermissions("VehicleInspection:view")
	@RequestMapping(value = "/view/{id}", method = { RequestMethod.GET })
	public String view(@PathVariable Long id, Map<String, Object> model) {
		Vehicle entity = vehicleService.get(id);
		model.put("entity", entity);
		return VIEW;
	}

}
