package com.whp.register.controller.vehicleRepair;

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
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.entity.vehicleRepair.VehicleRepair;
import com.whp.register.service.vehicle.VehicleService;
import com.whp.register.service.vehicleApplications.VehicleApplicationsService;
import com.whp.register.service.vehicleRepair.VehicleRepairService;

@Controller
@RequestMapping("/management/vehicle/repair/affirm")
public class RepairAffirmController extends BaseController{

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleRepairService repairService;
	
	private static final String LIST = "management/vehicle/repair/return/list";

	private static final String MANAGEOPER = "management/vehicle/repair/return/manageOper";

	private static final String VIEW = "management/vehicle/repair/return/view";

	private static final String RECORD = "management/vehicle/repair/record";
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		dataAuth(searchParams);
		
		if(null==searchParams.get("EQ_approvalStatus"))
		searchParams.put("EQ_approvalStatus", VehicleApplications.PASS);
		List<VehicleRepair> repairs = repairService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("repairs", repairs);
		map.putAll(searchParams);

		return LIST;
	}
	
	@RequestMapping(value = "/manageOper/{id}", method = RequestMethod.GET)
	public String vehicleReturn(@PathVariable Long id, Map<String, Object> map) {
		VehicleRepair repair = repairService.get(id);
		
		map.put("repair", repair);

		return MANAGEOPER;
	}
	
	@RequestMapping(value = "/manageOper", method = RequestMethod.POST)
	public @ResponseBody String vehicleReturn(VehicleRepair repair, Map<String, Object> map) {
		VehicleRepair repairNew = repairService.get(repair.getId());
		repairNew=repairService.vehicleReturn(repairNew,repair);
		repairNew.setAffirmUser(getShiroUser().getUser().getRealname());
		repairService.update(repairNew);
		return AjaxObject.newOk("还车成功。").toString();
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String vehicleReturnView(@PathVariable Long id, Map<String, Object> map) {
		VehicleRepair repair = repairService.get(id);
		
		map.put("repair", repair);

		return VIEW;
	}
	
	@RequestMapping(value = "/record", method = { RequestMethod.GET, RequestMethod.POST })
	public String record(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		searchParams.put("EQ_approvalStatus", VehicleRepair.RETURN);
		List<VehicleRepair> repairs = repairService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("repairs", repairs);
		map.putAll(searchParams);

		return RECORD;
	}
}
