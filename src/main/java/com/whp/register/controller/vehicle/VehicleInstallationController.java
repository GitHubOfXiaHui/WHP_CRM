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
import com.whp.framework.log.Log;
import com.whp.framework.log.LogMessageObject;
import com.whp.framework.log.impl.LogUitl;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicle.VehicleInstallation;
import com.whp.register.service.vehicle.VehicleInstallationService;

@Controller
@RequestMapping("/management/vehicle/installation")
public class VehicleInstallationController {
	
	@Autowired
	private VehicleInstallationService vehicleInstallationService;
	
	@Autowired
    private Validator validator;
	
	private static final String LIST = "management/vehicle/installation/list";
	private static final String CREATE = "management/vehicle/installation/create";
	private static final String UPDATE = "management/vehicle/installation/update";

	//@RequiresPermissions("VehicleInstallation:view")
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, Map<String, Object> model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<VehicleInstallation> installations = vehicleInstallationService.findByFilterJpa(page, searchParams);
		
		model.put("page", page);
		model.put("installations", installations);
		model.putAll(searchParams);
		
		return LIST;
	}

	//@RequiresPermissions("VehicleInstallation:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String preCreate() {
		return CREATE;
	}
	
	@Log(message = "添加了ID为{0}的车辆加装信息。")
	//@RequiresPermissions("VehicleInstallation:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(VehicleInstallation installation) {
		BeanValidators.validateWithException(validator, installation);
		
		vehicleInstallationService.save(installation);
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {installation.getId()}));
        return AjaxObject.newOk("车辆加装信息添加成功。").toString();
	}

	//@RequiresPermissions("VehicleInstallation:edit")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String preUpdate(@PathVariable Long id, Map<String, Object> model) {
    	VehicleInstallation installation = vehicleInstallationService.get(id);
        
        model.put("installation", installation);
        
        return UPDATE;
    }
    
    @Log(message = "修改了ID为{0}的车辆加装信息。")
    //@RequiresPermissions("VehicleInstallation:edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@ModelAttribute("preloadInstallation") VehicleInstallation installation) {
    	BeanValidators.validateWithException(validator, installation);

    	vehicleInstallationService.update(installation);
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {installation.getId()}));
        return AjaxObject.newOk("车辆加装信息修改成功。").toString();
    }
    
    @ModelAttribute("preloadInstallation")
    public VehicleInstallation getOne(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            return vehicleInstallationService.get(id);
        }
        return null;
    }
    
    @Log(message = "删除了ID为{0}的车辆加装信息。")
    //@RequiresPermissions("VehicleInstallation:delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMany(Long[] ids) {
    	List<Long> deleteIds = Lists.newArrayList();
    	for (Long id : ids) {
    		VehicleInstallation installation = vehicleInstallationService.get(id);
    		if (installation != null) {
    			vehicleInstallationService.delete(installation);
    			deleteIds.add(id);
    		}
    	}
    	
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {deleteIds.toString()}));
        
        return AjaxObject.newOk("删除车辆加装信息成功。").setCallbackType("").toString();
    }

}
