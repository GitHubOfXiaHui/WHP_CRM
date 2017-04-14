<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<div class="pageContent">
	<form method="post" action="${contextPath }/management/vehicle/applications/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>车牌号：</label>
			<input type="text" value="${vehicle.license }" size="20" readonly="readonly"/>
			<input type="hidden" name="vehicleId" value="${vehicle.id }"/>
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" value="${vehicle.type }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>车辆配置：</label>
			<input type="text" value="${vehicle.configuration }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>排量：</label>
			<input type="text" value="${vehicle.displacement }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>乘员数（人）：</label>
			<input type="text" value="${vehicle.crew }" size="20" readonly="readonly"/>
		</p>
		<div class="divider"></div>
		<p>
			<label>出发地：</label>
			<input type="text" class="validate[required,maxSize[64]] required" name="departure" size="20"/>
		</p>
		<p>
			<label>目的地：</label>
			<input type="text" class="validate[required,maxSize[64]] required" name="destination" size="20"/>
			<input type="checkbox" name="requireApproval" value="true" checked>目的地超出武汉
		</p>
		<p>
			<label>驾驶员：</label>
			<input type="text" name="driver" size="20"/>
		</p>
		<p>
			<label>乘车人数：</label>
			<input type="text" class="validate[custom[integer]]" name="passengerNum" size="20"/>
		</p>
		<p>
			<label>车辆用途：</label>
			<input type="text" class="validate[required,maxSize[64]] required" name="applicationIntent" size="20" onchange="setMinDateOfEndTime();"/>
		</p>
		<p>
			<label>起始时间：</label>
			<input id="start" type="date" class="date validate[required] required" minDate="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" 
				name="startTime" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>截止时间：</label>
			<input id="end" type="date" class="date validate[required] required" minDate="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" 
				name="endTime" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" size="20" readonly="readonly"/>
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
