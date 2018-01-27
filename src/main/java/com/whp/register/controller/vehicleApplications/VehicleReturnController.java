package com.whp.register.controller.vehicleApplications;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.whp.framework.utils.excel.ExcelTool;
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
		/*if(StringUtils.isNotBlank((String)searchParams.get("GTE_startTime")))
		searchParams.put("GTE_startTime", DateUtil.string2Date((String)searchParams.get("GTE_startTime"),"yyyyMMdd"));
		if(StringUtils.isNotBlank((String)searchParams.get("LTE_startTime")))
		searchParams.put("LTE_startTime", DateUtil.string2Date((String)searchParams.get("LTE_startTime"),"yyyyMMdd"));*/
		
		searchParams.put("EQ_approvalStatus", VehicleApplications.RETURN);
		
		dataAuth(searchParams);
		
		List<VehicleApplications> applications = applicationsService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("applications", applications);
		map.putAll(searchParams);
		map.put("organization", searchParams.get("LIKE_parent.organization.name"));

		return RECORD;
	}
	
    /**
     * 导出供应商信息.
     * 
     * @param map
     *            the map
     * @return the string
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse response,
        HttpServletRequest request)
    {   
    	Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        List<VehicleApplications> entityList = null;
//        dataPermission(params);
        entityList = applicationsService.findByFilterJpa(searchParams);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("list", entityList);
        
        ExcelTool.export(request, response, map2, "VehicleApplicationsExport", "VehicleApplicationsExport");
        
    }
}
