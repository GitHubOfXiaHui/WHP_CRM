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
import com.whp.register.entity.vehicle.VehicleInsurance;
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
	
	private static final String UPDATE = "management/vehicle/insurance/update";

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleInsuranceService insuranceService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("vehicles", vehicles);
		map.putAll(searchParams);

		return LIST;
	}

	@RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
	public String preCreate(@PathVariable Long id, Map<String, Object> map) {
		Vehicle vehicle = vehicleService.get(id);
		if (vehicle.isRecordedInsurance()) {
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
			entity.setRecordedInsurance(true);
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
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Vehicle vehicle = vehicleService.get(id);
		if (!vehicle.isRecordedInsurance()) {
			return null;
		}
		map.put("vehicle", vehicle);
		return UPDATE;
	}

	@Log(message = "修改了车牌号为{0}的车辆的保险信息。")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String update(Vehicle vehicle) {
		BeanValidators.validateWithException(validator, vehicle);
		Vehicle persitentObj = vehicleService.get(vehicle.getId());
        List<VehicleInsurance> insurances = persitentObj.getInsuranceList();
        for (VehicleInsurance insurance : insurances)
        {
        	insurance.setParent(null);
        }
        persitentObj.setInsuranceList(null);
        vehicleService.update(persitentObj);
        
        if (!vehicle.getInsuranceList().isEmpty())
        {
            insuranceService.setInsurance(vehicle, getShiroUser());
        }
        persitentObj.setInsuranceList(vehicle.getInsuranceList());
        vehicleService.update(persitentObj);
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {vehicle.getLicense()}));
        return AjaxObject.newOk("保险信息修改成功！").toString();
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
