package com.whp.register.controller.vehicle;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.web.Servlets;

import com.whp.framework.log.Log;
import com.whp.framework.log.LogMessageObject;
import com.whp.framework.log.impl.LogUitl;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.VehicleInspection;
import com.whp.register.service.vehicle.VehicleInspectionService;

/**
 * 车辆年审信息控制器
 * @author xiahui
 *
 */
@Controller
@RequestMapping("/management/vehicle/inspection")
public class VehicleInspectionController {

	@Autowired
	private VehicleInspectionService vehicleInspectionService;
	
	@Autowired
    private Validator validator;
	
	private static final String LIST = "management/vehicle/inspection/list";
	private static final String CREATE = "management/vehicle/inspection/create";
	
	//@RequiresPermissions("VehicleInspection:view")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<VehicleInspection> inspections = vehicleInspectionService.findByFilterJpa(page, searchParams);
		
		model.put("page", page);
		model.put("inspections", inspections);
		model.putAll(searchParams);
		
		return LIST;
	}
	
	//@RequiresPermissions("VehicleInspection:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String preCreate() {
		return CREATE;
	}
	
	@Log(message = "添加了ID为{0}的车辆年审信息。")
	//@RequiresPermissions("VehicleInspection:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(VehicleInspection inspection) {
		BeanValidators.validateWithException(validator, inspection);
		
        vehicleInspectionService.save(inspection);
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {inspection.getId()}));
        return AjaxObject.newOk("车辆年审信息添加成功。").toString();
	}

}
