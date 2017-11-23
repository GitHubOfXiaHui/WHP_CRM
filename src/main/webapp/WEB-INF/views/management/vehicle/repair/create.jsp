<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<div class="pageContent">
	<form method="post" action="${contextPath }/management/vehicle/repair/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
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
			<label>车型：</label>
			<c:if test="${vehicle.vehicleType==1 }"><input type="text" value="小型汽车" size="20" readonly="readonly"/></c:if>
			<c:if test="${vehicle.vehicleType==2 }"><input type="text" value="中型客车" size="20" readonly="readonly"/></c:if>
		</p>
		<p>
			<label>用途：</label>
			<c:if test="${vehicle.utility==1 }"><input type="text" value="特种专业技术用车" size="20" readonly="readonly"/></c:if>
			<c:if test="${vehicle.utility==2 }"><input type="text" value="执法执勤用车" size="20" readonly="readonly"/></c:if>
		</p>
		<p>
			<label>排量：</label>
			<input type="text" value="${vehicle.displacement }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>所属单位：</label>
			<input type="text" value="${vehicle.organization.name }" size="20" readonly="readonly"/>
		</p>
		<div class="divider"></div>
		<p>
			<label>申请人姓名：</label>
			<input type="text" class="validate[required,maxSize[64]] required" name="departure" size="20"/>
		</p>
		<p>
			<label>预计维修金额（元）：</label>
			<input type="text" class="validate[required,custom[integer]] required" name="price" size="20"/>
		</p>
		<p>
			<label>维修地点：</label>
			<input type="text" class="validate[required,maxSize[64]]  required" name="repairSite" size="20"/>
		</p>
		<p>
			<label>起始时间：</label>
			<input id="startTime" type="date" class="Wdate" name="startTime" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>', maxDate:'#F{$dp.$D(\'endTime\')}'})" readonly="readonly"/>
		</p>
		<p>
			<label>截止时间：</label>
			<input id="endTime" type="date" class="Wdate" name="endTime" 
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'#F{$dp.$D(\'startTime\')}'})" readonly="readonly"/>
		</p>
				<p>
			<label>第一审批人：</label>
			<input type="hidden" name="auditUser" val="user.mc" />	
			<input class="validate[required] required" name="audit1User" val="user.mc" type="text" readonly="readonly"/>
			<a class="btnLook" href="${contextPath }/management/vehicle/applications/lookup" lookupGroup="user" title="第一审批人" width="400">查找带回</a>	
		</p>
		<p>
			<label>维修描述：</label>
			<textarea rows="3" cols="30" class="validate[required,maxSize[1000]] required" name="repairDescript" size="20" onchange="setMinDateOfEndTime();"></textarea>
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
