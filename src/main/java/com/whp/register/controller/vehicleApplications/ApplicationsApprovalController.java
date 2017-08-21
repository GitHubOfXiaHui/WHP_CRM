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

	private static final String PASS = "management/vehicle/applications/approval/pass";
	
	private static final String REJECT = "management/vehicle/applications/approval/reject";
	
	// @RequiresPermissions("Vehicle:view")
	@RequestMapping(value = "/approval/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		//dataAuth(searchParams);
		User user=getShiroUser().getUser();
		searchParams.put("EQ_auditUser", user.getRealname());
		//过滤已通过和还车确认的申请
		searchParams.put("LT_approvalStatus", "50");
		List<VehicleApplications> applications = applicationsService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("applications", applications);
		map.putAll(searchParams);

		return LIST;
	}
	
	@RequestMapping(value = "/approval1/pass/{id}", method = RequestMethod.GET)
	public String approvalPass(@PathVariable Long id, Map<String, Object> map) {
		VehicleApplications application = applicationsService.get(id);
		
		map.put("application", application);

		return PASS;
	}
	
	@RequestMapping(value = "/approval1/pass", method = RequestMethod.POST)
	@ResponseBody
	public String approval1Pass(VehicleApplications applications) {
		applicationsService.approvalPass(applications);
		return AjaxObject.newOk("审批通过。").toString();
	}
	
	@RequestMapping(value = "/approval1/reject/{id}", method = RequestMethod.GET)
	public String approvalReject(@PathVariable Long id, Map<String, Object> map) {
		VehicleApplications application = applicationsService.get(id);
		
		map.put("application", application);

		return REJECT;
	}
	@RequestMapping(value = "/approval1/reject", method = RequestMethod.POST)
	@ResponseBody
	public String approval1Reject(VehicleApplications applications) {
		applicationsService.approvalReject(applications);
		return AjaxObject.newOk("驳回申请。").toString();
	}

}
