package com.whp.register.controller.vehicle;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springside.modules.web.Servlets;

import com.whp.framework.controller.BaseController;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.service.vehicle.VehicleService;

@Controller
@RequestMapping("/management/vehicle/query")
public class VehicleQueryController extends BaseController {
	
	@Autowired
	private VehicleService vehicleService;
	
	private static final String LIST = "management/vehicle/query/list";
	private static final String DETAILS = "management/vehicle/query/details";
	private static final String VEHICLE = "management/vehicle/query/vehicle";
	
	//@RequiresPermissions("VehicleQuery:view")
	@RequestMapping(value = "/list")
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);
		
		model.put("page", page);
		model.put("vehicles", vehicles);
		model.putAll(searchParams);
		
		return LIST;
	}
	
	//@RequiresPermissions("VehicleQuery:view")
	@RequestMapping(value = "/details/{id}")
	public String details(@PathVariable Long id, Map<String, Object> model) {
		Vehicle vehicle = vehicleService.get(id);
		
		model.put("vehicle", vehicle);
		
		return DETAILS;
	}
	
	//@RequiresPermissions("VehicleQuery:view")
	@RequestMapping(value = "/vehicle/{id}")
	public String vehicle(@PathVariable Long id, Map<String, Object> model) {
		Vehicle vehicle = vehicleService.get(id);
		
		model.put("vehicle", vehicle);
		
		return VEHICLE;
	}

}
