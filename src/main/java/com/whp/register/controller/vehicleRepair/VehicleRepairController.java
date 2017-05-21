package com.whp.register.controller.vehicleRepair;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Validator;

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
import com.whp.register.entity.vehicleRepair.VehicleRepair;
import com.whp.register.service.vehicle.VehicleService;
import com.whp.register.service.vehicleRepair.VehicleRepairService;

@Controller
@RequestMapping("/management/vehicle/repair")
public class VehicleRepairController extends BaseController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleRepairService vehicleRepairService;
	
	private static final String LIST = "management/vehicle/repair/list";
	
	private static final String CREATE = "management/vehicle/repair/create";

	private static final String PRINT_LIST = "management/vehicle/repair/print/list";

	private static final String PRINT = "management/vehicle/repair/print/print";
	
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
	
	@Log(message = "申请维修车牌号为{0}的车辆。")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(Long vehicleId, VehicleRepair repair) {
		BeanValidators.validateWithException(validator, repair);
		
		try {
			Vehicle vehicle = vehicleRepairService.applicate(vehicleId, repair, getShiroUser());
			//vehicleService.update(vehicle);
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { vehicle.getLicense() }));
			return AjaxObject.newOk("申请维修成功，等待审批。").toString();
		} catch (ServiceException e) {
			return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
		}
		
	}
	
	@RequestMapping(value = "/print/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(boolean allApplications, Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		if (!allApplications) {
			//searchParams.put("EQ_applicationUser.id", getShiroUser().getUser().getId());
			dataAuth(searchParams);
		}
		List<VehicleRepair> repairs = vehicleRepairService.findByFilterJpa(page, searchParams);
		
		map.put("page", page);
		map.put("repairs", repairs);
		map.put("allApplications", allApplications);
		map.putAll(searchParams);

		return PRINT_LIST;
	}
	
	@RequestMapping(value = "/print/{id}", method = RequestMethod.GET)
	public String print(@PathVariable Long id, Map<String, Object> map) {
		VehicleRepair repair = vehicleRepairService.get(id);
		
		map.put("repair", repair);

		return PRINT;
	}
}
