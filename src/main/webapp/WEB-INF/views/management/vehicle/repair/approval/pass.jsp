<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<form method="post" 
	action="${contextPath }/management/vehicle/repair/approval1/pass"
	class="required-validate pageForm"
	onsubmit="return validateCallback(this, dialogReloadNavTab);">
<div class="pageFormContent" layoutH="97">
	<div>
		<p>
			<label>车牌号：</label>
			<input type="text" value="${repair.parent.license }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>检修地点：</label>
			<input type="text" value="${repair.repairSite }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>预计检修费用：</label>
			<input type="text" value="${repair.price }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>检修原因：</label>
			<input type="text" value="${repair.repairDescript }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人：</label>
			<input type="text" value="${repair.applicationUser.realname }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人所在派出所：</label>
			<input type="text" value="${repair.applicationUser.organization.name }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>送检时间：</label>
			<input type="text" value="<fmt:formatDate value="${repair.startTime }" pattern="yyyy-MM-dd"/>" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>预计接车时间：</label>
			<input type="text" value="<fmt:formatDate value="${repair.startTime }" pattern="yyyy-MM-dd"/>" size="20" readonly="readonly"/>
		</p>
	</div>
	<div class="divider"></div>
	
	<div>
		<p>
			<label>审核人姓名：</label>
			<input type="hidden" name="id" value="${repair.id}" size="20" />
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
