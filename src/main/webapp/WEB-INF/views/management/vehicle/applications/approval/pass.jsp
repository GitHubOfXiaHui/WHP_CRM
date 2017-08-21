<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
<form method="post" 
	action="${contextPath }/management/vehicle/applications/approval1/pass"
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
			<label>审核人姓名：</label>
			<input type="hidden" name="id" value="${application.id}" size="20" />
			<input type="text" name="audit1Username" size="20" class="validate[required, maxSize[25]] required"/>
		</p>
	</div>
	
	
</div>
<div class="formBar">
	<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">通过</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
</div>
</form>
</div>
