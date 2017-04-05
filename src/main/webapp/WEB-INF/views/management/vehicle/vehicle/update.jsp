<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="${contextPath }/management/vehicle/vehicle/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${vehicle.id}"/>
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>车牌号：</label>
			<input type="text" name="license" value="${vehicle.license }" class="validate[required] required" size="20" readonly="readonly"/>
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
			<label>乘员数：</label>
			<input type="text" name="crew" value="${vehicle.crew }" size="20"/>
		</p>
		<p>
			<label>价格：</label>
			<input type="text" name="price" value="${vehicle.price }" size="20"/>
		</p>
		<p>
			<label>购置税：</label>
			<input type="text" name="purchaseTax" value="${vehicle.purchaseTax }" size="20"/>
		</p>
		<p>
			<label>购买时间：</label>
			<input type="text" name="buyingTime" value="<fmt:formatDate value='${vehicle.buyingTime}' pattern='yyyy-MM-dd'/>" size="20"/>
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