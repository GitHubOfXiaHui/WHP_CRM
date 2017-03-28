<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="tabs">
	<div class="tabsHeader">
		<div class="tabsHeaderContent">
			<ul>
				<li class="selected"><a href="#"><span>车辆基本信息</span></a></li>
				<li><a href="#"><span>车辆保险信息</span></a></li>
				<li><a href="#"><span>车辆年审信息</span></a></li>
				<li><a href="#"><span>车辆加装信息</span></a></li>
			</ul>
		</div>
	</div>
	<div class="tabsContent"><!--  style="height: 150px;" -->
		<div>
			<p>
				<label>车牌号：</label>
				<input type="text" name="license" value="${vehicle.license }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>车辆型号：</label>
				<input type="text" name="type" value="${vehicle.type }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>车辆颜色：</label>
				<input type="text" name="color" value="${vehicle.color }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>车辆配置：</label>
				<input type="text" name="configuration" value="${vehicle.configuration }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>排量：</label>
				<input type="text" name="displacement" value="${vehicle.displacement }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>乘员数：</label>
				<input type="text" name="crew" value="${vehicle.crew }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>价格：</label>
				<input type="text" name="price" value="${vehicle.price }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>购置税：</label>
				<input type="text" name="purchaseTax" value="${vehicle.purchaseTax }" size="20" readonly="readonly"/>
			</p>
			<p>
				<label>购买时间：</label>
				<input type="text" name="buyingTime" value="${vehicle.buyingTime }" size="20" readonly="readonly"/>
			</p>
		</div>
		<div>车辆保险信息</div>
		<div>车辆年审信息</div>
		<div>车辆加装信息</div>
	</div>
	<div class="tabsFooter">
		<div class="tabsFooterContent"></div>
	</div>
</div>