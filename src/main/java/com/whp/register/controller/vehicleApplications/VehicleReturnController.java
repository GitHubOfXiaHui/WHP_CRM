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
import org.springside.modules.web.Servlets;

import com.whp.framework.controller.BaseController;
import com.whp.framework.entity.main.User;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.Vehicle;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.service.vehicle.VehicleService;
import com.whp.register.service.vehicleApplications.VehicleApplicationsService;

@Controller
@RequestMapping("/management/vehicle/applications/return")
public class VehicleReturnController extends BaseController{

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleApplicationsService applicationsService;
	
	private static final String LIST = "management/vehicle/applications/return/list";

	private static final String MANAGEOPER = "management/vehicle/applications/return/manageOper";

	private static final String VIEW = "management/vehicle/applications/return/view";

	private static final String RECORD = "management/vehicle/applications/record";
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		//dataAuth(searchParams);
		searchParams.put("EQ_applicationUser.id", getShiroUser().getId());
		if(null==searchParams.get("EQ_approvalStatus"))
		searchParams.put("EQ_approvalStatus", VehicleApplications.PASS);
		List<VehicleApplications> applications = applicationsService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("applications", applications);
		map.putAll(searchParams);

		return LIST;
	}
	
	@RequestMapping(value = "/manageOper/{id}", method = RequestMethod.GET)
	public String vehicleReturn(@PathVariable Long id, Map<String, Object> map) {
		VehicleApplications application = applicationsService.get(id);
		
		map.put("application", application);

		return MANAGEOPER;
	}
	
	@RequestMapping(value = "/manageOper", method = RequestMethod.POST)
	public @ResponseBody String vehicleReturn(VehicleApplications application, Map<String, Object> map) {
		VehicleApplications applicationNew = applicationsService.get(application.getId());
		applicationNew=applicationsService.vehicleReturn(applicationNew,application);
		applicationNew.setReturnUser(getShiroUser().getUser().getRealname());
		applicationsService.update(applicationNew);
		return AjaxObject.newOk("还车成功。").toString();
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String vehicleReturnView(@PathVariable Long id, Map<String, Object> map) {
		VehicleApplications application = applicationsService.get(id);
		
		map.put("application", application);

		return VIEW;
	}
	
	@RequestMapping(value = "/record", method = { RequestMethod.GET, RequestMethod.POST })
	public String record(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		searchParams.put("EQ_approvalStatus", VehicleApplications.RETURN);
		
		dataAuth(searchParams);
		
		List<VehicleApplications> applications = applicationsService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("applications", applications);
		map.putAll(searchParams);

		return RECORD;
	}
}
