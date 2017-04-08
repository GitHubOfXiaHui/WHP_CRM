package com.whp.register.controller.vehicleApplications;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springside.modules.web.Servlets;

import com.whp.framework.controller.BaseController;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.service.vehicle.VehicleService;

/**
 * 车辆使用申请控制器
 * @author xiahui
 *
 */
@Controller
@RequestMapping("/management/vehicle/applications")
public class VehicleApplicationsController extends BaseController {

	@Autowired
	private VehicleService vehicleService;
	
	private static final String LIST = "management/vehicle/applications/list";
	
	//@RequiresPermissions("Vehicle:view")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		// 默认筛选出空闲的车辆
		searchParams.put("EQ_vehicleStatus", Vehicle.IDLE);
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);
		
		model.put("page", page);
		model.put("vehicles", vehicles);
		model.putAll(searchParams);
		
		return LIST;
	}
	
}
