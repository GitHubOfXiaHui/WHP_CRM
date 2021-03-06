<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<form method="post" 
	action="${contextPath }/management/vehicle/applications/return/manageOper"
	class="required-validate pageForm"
	onsubmit="return validateCallback(this, dialogReloadNavTab);">
<div class="pageFormContent" layoutH="97">
	<div>
		<p>
			<label>车牌号：</label>
			<input type="text" value="${application.parent.license }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人姓名：</label>
			<input type="text" value="${application.departure }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>目的地：</label>
			<input type="text" value="${application.destination }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>驾驶员：</label>
			<input type="text" value="${application.driver }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>乘车人数（人）：</label>
			<input type="text" value="${application.passengerNum }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>车辆用途：</label>
			<input type="text" value="${application.applicationIntent }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人：</label>
			<input type="text" value="${application.applicationUser.realname }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人所在派出所：</label>
			<input type="text" value="${application.applicationUser.organization.name }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请时间：</label>
			<input type="text" value="<fmt:formatDate value="${application.startTime }" pattern="yyyy-MM-dd"/>" size="20" readonly="readonly"/>
		</p>
	</div>
	<div class="divider"></div>
	
	<div>
		<p>
			<label>车行驶数始码：</label>
			<input type="hidden" name="id" value="${application.id}" size="20" />
			<input type="text" name="startFGReading" size="20" class="validate[required, maxSize[25]] required"/>
		</p>
		<p>
			<label>车行驶数止码：</label>
			<input type="text" name="endFGReading" class="validate[required, maxSize[25]] required" size="20" />
		</p>
		<p>
			<label>实际驾驶人：</label>
			<input type="hidden" name="returnSite" value="${application.parent.organization.name }" />
			<input type="text" name="actualDriver" class="validate[required, maxSize[25]] required" size="20" />
		</p>
		<p>
			<label>还车备注：</label>
			<textarea rows="1" cols="30"  name="returnRemark" size="20" />
		</p>
<%-- 		<p>
			<label>是否违章：</label>
			<input type="text" name="${application.applicationIntent }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>是否加油：</label>
			<input type="text" name="${application.applicationUser.realname }" size="20" readonly="readonly"/>
		</p> --%>
		<p >
		<label><input id="dicBank" type="checkbox" name="accident"
				  value="false" /> 是否事故</label>
		</p>
		<dl style="display: none" id="bankNetName">
			<dt>事故备注：</dt>
			<dd >
			<textarea rows="1" cols="30" class="validate[required, maxSize[255]] required" name="accidentRemark" size="20"></textarea>
		</dd>
		</dl>
	</div>
	
	
</div>
<div class="formBar">
	<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">还车</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
</div>
</form>
<script type="text/javascript">
	$(function() {
		$("#dicBank").click(function(){
			var flag = document.getElementById("dicBank").checked;
			if (flag) {
				$('#dicBank').val("true");
				$("#bankNetName").css('display','block');  

			}else{
				$("#bankNetName").css('display','none'); 
			}
		});
		
});
	
</script>
