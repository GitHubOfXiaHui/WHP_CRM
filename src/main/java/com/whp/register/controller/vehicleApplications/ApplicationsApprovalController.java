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
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicleApplications.VehicleApplications;
import com.whp.register.service.vehicleApplications.VehicleApplicationsService;

/**
 * 车辆使用申请审批控制器
 * 
 * @author xiahui
 *
 */
@Controller
@RequestMapping("/management/vehicle/applications")
public class ApplicationsApprovalController extends BaseController {

	@Autowired
	private VehicleApplicationsService applicationsService;
	
	private static final String LIST = "management/vehicle/applications/approval/list";
	
	// @RequiresPermissions("Vehicle:view")
	@RequestMapping(value = "/approval/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		List<VehicleApplications> applications = applicationsService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("applications", applications);
		map.putAll(searchParams);

		return LIST;
	}
	
	@RequestMapping(value = "/approval1/pass/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval1Pass(@PathVariable Long id) {
		applicationsService.approval1Pass(id);
		return AjaxObject.newOk("审批通过。").setCallbackType("").toString();
	}
	
	@RequestMapping(value = "/approval1/reject/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval1Reject(@PathVariable Long id) {
		applicationsService.approval1Reject(id);
		return AjaxObject.newOk("驳回申请。").setCallbackType("").toString();
	}

	@RequestMapping(value = "/approval2/pass/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval2Pass(@PathVariable Long id) {
		applicationsService.approval2Pass(id);
		return AjaxObject.newOk("审批通过。").setCallbackType("").toString();
	}
	
	@RequestMapping(value = "/approval2/reject/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval2Reject(@PathVariable Long id) {
		applicationsService.approval2Reject(id);
		return AjaxObject.newOk("驳回申请。").setCallbackType("").toString();
	}

	@RequestMapping(value = "/approval3/pass/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval3Pass(@PathVariable Long id) {
		applicationsService.approval3Pass(id);
		return AjaxObject.newOk("审批通过。").setCallbackType("").toString();
	}
	
	@RequestMapping(value = "/approval3/reject/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval3Reject(@PathVariable Long id) {
		applicationsService.approval3Reject(id);
		return AjaxObject.newOk("驳回申请。").setCallbackType("").toString();
	}

}
