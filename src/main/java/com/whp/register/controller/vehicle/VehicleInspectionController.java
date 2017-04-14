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
	private VehicleInspectionService inspectionService;
	
	private static final String LIST = "management/vehicle/inspection/list";
	private static final String RECORD = "management/vehicle/inspection/record";
	private static final String VIEW = "management/vehicle/inspection/view";
	/** 年审周期. */
	private static final String SELECT = "management/vehicle/inspection/select";
	
	//@RequiresPermissions("VehicleInspection:view")
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
	
	@Log(message = "修改了车牌号为{0}的车辆年审信息。")
	//@RequiresPermissions("VehicleInspection:save")
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	@ResponseBody
	public String record(Vehicle vehicle) {
		BeanValidators.validateWithException(validator, vehicle);
		
		Vehicle entity = vehicleService.get(vehicle.getId());
		try {
			inspectionService.modifyInspections(entity, vehicle, getShiroUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return AjaxObject.newError("系统忙，请稍候再试。").setCallbackType("").toString();
		}
		vehicleService.update(entity);
		
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { entity.getLicense() }));
		return AjaxObject.newOk("修改车辆年审信息成功。").toString();
	}
	
	//@RequiresPermissions("VehicleInspection:view")
	@RequestMapping(value = "/view/{id}", method = { RequestMethod.GET })
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Vehicle entity = vehicleService.get(id);
		map.put("entity", entity);
		return VIEW;
	}

	/**
	 * 行编辑器(年审周期下拉框)
	 */
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public String select(String inputName, Page page, Map<String, Object> map) {
		map.put("inputName", inputName);
		return SELECT;
	}
	
}
