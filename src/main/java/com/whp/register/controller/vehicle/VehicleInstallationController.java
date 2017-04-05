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
	private static final String CREATE = "management/vehicle/installation/create";
	private static final String VIEW = "management/vehicle/installation/view";

	//@RequiresPermissions("VehicleInstallation:view")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);

		model.put("page", page);
		model.put("vehicles", vehicles);
		model.putAll(searchParams);

		return LIST;
	}

	//@RequiresPermissions("VehicleInstallation:save")
	@RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
	public String preCreate(@PathVariable Long id, Map<String, Object> model) {
		Vehicle vehicle = vehicleService.get(id);
		if (Vehicle.RECORDED.equals(vehicle.getInstallationStatus())) {
			return null;
		}
		model.put("vehicle", vehicle);
		return CREATE;
	}
	
	@Log(message = "添加了车牌号为{0}的车辆加装信息。")
	//@RequiresPermissions("VehicleInstallation:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(Vehicle vehicle) {
		BeanValidators.validateWithException(validator, vehicle);
		Vehicle entity = vehicleService.get(vehicle.getId());
		if (vehicle.getInsuranceList().isEmpty()) {
			return AjaxObject.newError("未添加加装信息").toString();
		} else {
			entity.setInstallationList(installationService.setInstallation(vehicle, getShiroUser()));
			entity.setInstallationStatus(Vehicle.RECORDED);
			vehicleService.update(entity);
		}
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { vehicle.getLicense() }));
		return AjaxObject.newOk("录入车辆加装信息成功。").toString();
	}

	//@RequiresPermissions("VehicleInstallation:view")
	@RequestMapping(value = "/view/{id}", method = { RequestMethod.GET })
	public String view(@PathVariable Long id, Map<String, Object> model) {
		Vehicle entity = vehicleService.get(id);
		model.put("entity", entity);
		return VIEW;
	}

}
