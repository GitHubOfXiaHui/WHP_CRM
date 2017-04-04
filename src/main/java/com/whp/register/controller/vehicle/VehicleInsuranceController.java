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
import com.whp.register.service.vehicle.VehicleInsuranceService;
import com.whp.register.service.vehicle.VehicleService;

@Controller
@RequestMapping("/management/vehicle/insurance")
public class VehicleInsuranceController extends BaseController {

	private static final String LIST = "management/vehicle/insurance/list";
	private static final String CREATE = "management/vehicle/insurance/create";
	/** 保险类型. */
	protected static final String SELECT = "management/vehicle/insurance/select";
	/** view页面. */
	protected static final String VIEW = "management/vehicle/insurance/view";

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleInsuranceService insuranceService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);

		model.put("page", page);
		model.put("vehicles", vehicles);
		model.putAll(searchParams);

		return LIST;
	}

	@RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
	public String preCreate(@PathVariable Long id, Map<String, Object> map) {
		Vehicle vehicle = vehicleService.get(id);
		if ("1".equals(vehicle.getInsuranceStatus())) {
			return null;
		}
		map.put("vehicle", vehicle);
		return CREATE;
	}

	@Log(message = "录入了车牌号为{0}的车辆的保险信息。")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody String create(Vehicle vehicle) {
		BeanValidators.validateWithException(validator, vehicle);
		Vehicle entity = vehicleService.get(vehicle.getId());
		if (vehicle.getInsuranceList().isEmpty()) {
			return AjaxObject.newError("未添加保险信息").toString();
		} else {
			entity.setInsuranceList(insuranceService.setInsurance(vehicle, getShiroUser()));
			entity.setInsuranceStatus("1");
			vehicleService.update(entity);
		}
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { vehicle.getLicense() }));
		return AjaxObject.newOk("录入车辆保险信息成功。").toString();
	}

	@RequestMapping(value = "/view/{id}", method = { RequestMethod.GET })
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Vehicle entity = vehicleService.get(id);
		map.put("entity", entity);
		return VIEW;
	}

	/**
	 * 行编辑器(保险类型下拉框)
	 */
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public String select(String inputName, Page page, Map<String, Object> map) {
		map.put("inputName", inputName);
		return SELECT;
	}
}
