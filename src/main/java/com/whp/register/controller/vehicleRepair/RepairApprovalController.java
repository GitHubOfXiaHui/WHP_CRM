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
import com.whp.framework.entity.main.User;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;
import com.whp.register.entity.vehicleRepair.VehicleRepair;
import com.whp.register.service.vehicleRepair.VehicleRepairService;

/**
 * 车辆维修申请审批控制器
 * 
 * @author xiahui
 *
 */
@Controller
@RequestMapping("/management/vehicle/repair")
public class RepairApprovalController extends BaseController {

	@Autowired
	private VehicleRepairService repairService;
	
	private static final String LIST = "management/vehicle/repair/approval/list";
	
	// @RequiresPermissions("Vehicle:view")
	@RequestMapping(value = "/approval/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Page page, Map<String, Object> map, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		//dataAuth(searchParams);
		User user=getShiroUser().getUser();
		searchParams.put("EQ_auditUser", user.getRealname());
		List<VehicleRepair> repairs = repairService.findByFilterJpa(page, searchParams);

		map.put("page", page);
		map.put("repairs", repairs);
		map.putAll(searchParams);

		return LIST;
	}
	
	@RequestMapping(value = "/approval1/pass/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval1Pass(@PathVariable Long id) {
		repairService.approvalPass(id);
		return AjaxObject.newOk("审批通过。").setCallbackType("").toString();
	}
	
	@RequestMapping(value = "/approval1/reject/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String approval1Reject(@PathVariable Long id) {
		repairService.approvalReject(id);
		return AjaxObject.newOk("驳回申请。").setCallbackType("").toString();
	}

}
