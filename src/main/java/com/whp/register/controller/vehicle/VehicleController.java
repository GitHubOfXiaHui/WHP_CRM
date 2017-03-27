package com.whp.register.controller.vehicle;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springside.modules.web.Servlets;

import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.service.vehicle.VehicleService;

/**
 * 车辆基本信息控制器
 * @author xiahui
 *
 */
@Controller
@RequestMapping("/management/vehicle/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	private static final String LIST = "management/vehicle/vehicle/list";

	//@RequiresPermissions("Vehicle:view")
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.PUT})
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		List<Vehicle> vehicles = null;
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		vehicles = vehicleService.findByFilterJpa(page, searchParams);
		
		model.put("page", page);
		model.put("vehicles", vehicles);
		model.putAll(searchParams);
		
		return LIST;
	}
}
