package com.whp.register.controller.vehicleApplications;

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
import com.whp.framework.exception.ServiceException;
import com.whp.framework.log.Log;
import com.whp.framework.log.LogMessageObject;
import com.whp.framework.log.impl.LogUitl;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.service.vehicle.VehicleService;
import com.whp.register.service.vehicleApplications.VehicleApplicationsService;

/**
 * 车辆使用申请控制器
 * 
 * @author xiahui
 *
 */
@Controller
@RequestMapping("/management/vehicle/applications")
public class VehicleApplicationsController extends BaseController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleApplicationsService applicationsService;

	private static final String LIST = "management/vehicle/applications/list";
	private static final String CREATE = "management/vehicle/applications/create";
	
	private static final String PRINT = "management/vehicle/applications/print/list";

	// @RequiresPermissions("Vehicle:view")
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
		map.put("vehicle", vehicle);
		return CREATE;
	}

	@Log(message = "申请使用车牌号为{0}的车辆。")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(Long vehicleId, VehicleApplications application) {
		BeanValidators.validateWithException(validator, application);
		
		try {
			Vehicle vehicle = applicationsService.applicate(vehicleId, application, getShiroUser());
			
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { vehicle.getLicense() }));
			return AjaxObject.newOk("申请成功，等待审批。").toString();
		} catch (ServiceException e) {
			return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
		}
		
	}
	
	@RequestMapping(value = "/print/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(boolean allApplications, Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		if (!allApplications) {
			searchParams.put("EQ_applicationUser.id", getShiroUser().getUser().getId());
		}
		List<VehicleApplications> applications = applicationsService.findByFilterJpa(page, searchParams);
		
		map.put("page", page);
		map.put("applications", applications);
		map.put("allApplications", allApplications);
		map.putAll(searchParams);

		return PRINT;
	}
	
}
