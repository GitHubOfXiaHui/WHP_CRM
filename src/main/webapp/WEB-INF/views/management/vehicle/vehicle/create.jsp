<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<div class="pageContent">
	<form method="post" action="${contextPath }/management/vehicle/vehicle/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>车牌号：</label>
			<input type="text" class="validate[required] required" name="license" size="20"/>
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" name="type" size="20"/>
		</p>
		<p>
			<label>车辆颜色：</label>
			<input type="text" name="color" size="20"/>
		</p>
		<p>
			<label>车辆配置：</label>
			<input type="text" name="configuration" size="20"/>
		</p>
		<p>
			<label>排量：</label>
			<input type="text" name="displacement" size="20"/>
		</p>
		<p>
			<label>乘员数（人）：</label>
			<input type="text" class="validate[required,custom[integer]] required" name="crew" value="0" size="20"/>
		</p>
		<p>
			<label>价格（万元）：</label>
			<input type="text" class="validate[required,custom[number]] required" name="price" value="0.0" size="20"/>
		</p>
		<p>
			<label>购置税（元）：</label>
			<input type="text" class="validate[required,custom[number]] required" name="purchaseTax" value="0.0" size="20"/>
		</p>
		<p>
			<label>购买时间：</label>
			<input type="date" class="date" name="buyingTime" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" size="20" readonly="readonly"/>
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