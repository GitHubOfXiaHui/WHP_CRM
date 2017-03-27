package com.whp.register.controller.vehicle;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Lists;
import com.whp.framework.exception.ExistedException;
import com.whp.framework.log.Log;
import com.whp.framework.log.LogMessageObject;
import com.whp.framework.log.impl.LogUitl;
import com.whp.framework.utils.dwz.AjaxObject;
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
	
	@Autowired
    private Validator validator;
	
	private static final String LIST = "management/vehicle/vehicle/list";
	private static final String CREATE = "management/vehicle/vehicle/create";
	private static final String UPDATE = "management/vehicle/vehicle/update";

	//@RequiresPermissions("Vehicle:view")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<Vehicle> vehicles = vehicleService.findByFilterJpa(page, searchParams);
		
		model.put("page", page);
		model.put("vehicles", vehicles);
		model.putAll(searchParams);
		
		return LIST;
	}
	
	//@RequiresPermissions("Vehicle:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String preCreate() {
		return CREATE;
	}
	
	@Log(message = "添加了车牌号为{0}的车辆的基本信息。")
	//@RequiresPermissions("Vehicle:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(Vehicle vehicle) {
		BeanValidators.validateWithException(validator, vehicle);
        try
        {
        	vehicle.setLicense(vehicle.getLicense().trim());
        	vehicleService.save(vehicle);
        }
        catch (ExistedException e)
        {
            return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
        }
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {vehicle.getLicense()}));
        return AjaxObject.newOk("车辆基本信息添加成功。").toString();
	}
	
	//@RequiresPermissions("Vehicle:edit")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
        Vehicle vehicle = vehicleService.get(id);
        
        map.put("vehicle", vehicle);
        
        return UPDATE;
    }
    
    @Log(message = "修改了车牌号为{0}的车辆的基本信息。")
    //@RequiresPermissions("Vehicle:edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@ModelAttribute("preloadVehicle") Vehicle vehicle) {
    	BeanValidators.validateWithException(validator, vehicle);

    	vehicleService.update(vehicle);
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {vehicle.getLicense()}));
        return AjaxObject.newOk("修改车辆基本信息成功。").toString();
    }
    
    @ModelAttribute("preloadVehicle")
    public Vehicle getOne(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            return vehicleService.get(id);
        }
        return null;
    }
    
    @Log(message = "删除了车牌号为{0}的车辆的基本信息。")
    //@RequiresPermissions("Vehicle:delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable Long id) {
    	Vehicle vehicle = vehicleService.get(id);
    	if (vehicle != null) {
    		vehicleService.delete(vehicle);
    		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {vehicle.getLicense()}));
    	}
    	
        return AjaxObject.newOk("删除车辆基本信息成功。").setCallbackType("").toString();
    }
    
    @Log(message = "删除了车牌号为{0}的车辆的基本信息。")
    //@RequiresPermissions("Vehicle:delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMany(Long[] ids) {
    	List<String> licenses = Lists.newArrayList();
    	for (Long id : ids) {
    		Vehicle vehicle = vehicleService.get(id);
    		if (vehicle != null) {
    			vehicleService.delete(vehicle);
    			licenses.add(vehicle.getLicense());
    		}
    	}
    	
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {licenses.toString()}));
        
        return AjaxObject.newOk("删除车辆基本信息成功。").setCallbackType("").toString();
    }
    
}
