<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<div class="pageContent">
	<form method="post" action="${contextPath }/management/vehicle/applications/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>车牌号：</label>
			<input type="text" value="${vehicle.license }" size="20"/>
			<input type="hidden" name="vehicleId" value="${vehicle.id }"/>
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" value="${vehicle.type }" size="20"/>
		</p>
		<p>
			<label>车辆配置：</label>
			<input type="text" value="${vehicle.configuration }" size="20"/>
		</p>
		<p>
			<label>排量：</label>
			<input type="text" value="${vehicle.displacement }" size="20"/>
		</p>
		<p>
			<label>乘员数：</label>
			<input type="text" value="${vehicle.crew }" size="20"/>
		</p>
		<div class="divider"></div>
		<p>
			<label>目的地：</label>
			<input type="text" name="destination" size="20"/>
		</p>
		<p>
			<label>&nbsp;</label>
			<input type="checkbox" name="requireApproval" value="true" checked>目的地超出武汉
		</p>
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
	</form>
</div>