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
			<input type="text" name="type" value="${vehicle.type }" size="20"/>
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
			<label>乘员数（人）：</label>
			<input type="text" class="validate[required,custom[number]] required" name="crew" value="${vehicle.crew }" size="20"/>
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
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
	</form>
</div>