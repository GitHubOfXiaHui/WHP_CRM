<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="${contextPath }/management/vehicle/vehicle/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>车牌号：</label>
			<input type="text" class="validate[required] required" name="license" value="${vehicle.license }" size="20" readonly="readonly"/>
			<input type="hidden" name="id" value="${vehicle.id}"/>
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" name="type" value="${vehicle.type }" size="30"/>
		</p>
		<p>
			<label>车辆颜色：</label>
			<input type="text" name="color" value="${vehicle.color }" size="20"/>
		</p>
		<p>
			<label>车辆配置：</label>
			<input type="text" name="configuration" value="${vehicle.configuration }" size="20"/>
		</p>
		<p>
			<label>排量：</label>
			<input type="text" name="displacement" value="${vehicle.displacement }" size="20"/>
		</p>
		<p>
			<label>车型：</label>
			<select	name="vehicleType" class="validate[required,maxSize[11]] required">
				<option value="1" <c:if test="${vehicle.vehicleType==1 }">selected="selected"</c:if>>小型汽车</option>
				<option value="2" <c:if test="${vehicle.vehicleType==2 }">selected="selected"</c:if>>中型客车</option>
		</select>
		</p>
		<p>
			<label>车架号：</label>
			<input type="text" name="vehicleNumber" size="30" value="${vehicle.vehicleNumber }"/>
		</p>
		<p>
			<label>发动机号：</label>
			<input type="text" name="engineNumber" size="20" value="${vehicle.engineNumber }"/>
		</p>
		<p>
			<label>用途：</label>
			<select	name="utility" class="validate[required,maxSize[11]] required">
				<option value="1" <c:if test="${vehicle.utility==1 }">selected="selected"</c:if>>特种专业技术用车</option>
				<option value="2" <c:if test="${vehicle.utility==1 }">selected="selected"</c:if>>执法执勤用车</option>
		</select>
		</p>
		<p>
			<label>乘员数（人）：</label>
			<input type="text" class="validate[required,custom[number]] required" name="crew" value="${vehicle.crew }" size="20"/>
		</p>
		<p>
			<label>行驶公里数：</label>
			<input type="text" class="validate[required,custom[integer]] required" name="mileage" value="${vehicle.mileage }" size="20"/>
		</p>
		<p>
			<label>价格（万元）：</label>
			<input type="text" class="validate[required,custom[number]] required" name="price" value="${vehicle.price }" size="20"/>
		</p>
		<p>
			<label>购置税（元）：</label>
			<input type="text" class="validate[required,custom[number]] required" name="purchaseTax" value="${vehicle.purchaseTax }" size="20"/>
		</p>
		<p>
			<label>购买时间：</label>
			<input type="date" class="date" name="buyingTime" value="<fmt:formatDate value='${vehicle.buyingTime}' pattern='yyyy-MM-dd'/>" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>所属单位：</label>	
			<input name="organization.id" val="organization.id" value="${vehicle.organization.id}" type="hidden"/>
			<input name="organization.parent.name" val="organization.parentName" value="${vehicle.organization.parent.name}" type="hidden"/>
			<input name="organization.parent.code" val="organization.parentCode" value="${vehicle.organization.parent.code}" type="hidden"/>
			<input class="validate[required] required" name="organization.name" val="organization.name" value="${vehicle.organization.name}" type="text" readonly="readonly"/>
			<a class="btnLook" href="${contextPath }/management/security/user/lookup2org" lookupGroup="organization" title="关联组织" width="400">查找带回</a>	
		</p>
		<p>
			<label>备注：</label>
			<textarea rows="3" cols="30" name="remark">${vehicle.remark }</textarea>
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