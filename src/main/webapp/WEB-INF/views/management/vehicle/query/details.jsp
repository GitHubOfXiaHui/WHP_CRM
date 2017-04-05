<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageFormContent">
	<div>
		<p>
			<label>车牌号：</label>
			<input type="text" value="${vehicle.license }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" value="${vehicle.type }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>车辆颜色：</label>
			<input type="text" value="${vehicle.color }" size="20" readonly="readonly"/>
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
			<label>乘员数：</label>
			<input type="text" value="${vehicle.crew }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>价格：</label>
			<input type="text" value="${vehicle.price }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>购置税：</label>
			<input type="text" value="${vehicle.purchaseTax }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>购买时间：</label>
			<input type="text" value="<fmt:formatDate value="${vehicle.buyingTime }" pattern="yyyy-MM-dd"/>" size="20" readonly="readonly"/>
		</p>
	</div>
	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li class="selected"><a href="#"><span>车辆保险信息</span></a></li>
					<li><a href="#"><span>车辆年审信息</span></a></li>
					<li><a href="#"><span>车辆加装信息</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
				<table class="list nowrap" width="100%">
					<thead align="center">
						<tr>
							<th>保险类型</th>
							<th>承保公司</th>
							<th>保险价格（元）</th>
							<th>保险额度（万元） </th>
							<th>投保时间</th>
							<th>过保时间</th>
							<th>保险状态</th>
						    <th>备注</th>
						</tr>
					</thead>
					<tbody align="center" style="color:maroon">
						<c:forEach var="child" items="${vehicle.insuranceList}" varStatus="status">
						<tr class="unitBox">
							<td>
								<c:if test = "${child.insuranceType == '1' }">交强险</c:if>
				    			<c:if test = "${child.insuranceType == '2' }">车辆损失险</c:if>
				    			<c:if test = "${child.insuranceType == '3' }">第三者责任险</c:if>
				    			<c:if test = "${child.insuranceType == '4' }">盗抢险</c:if>
				    			<c:if test = "${child.insuranceType == '5' }">车上座位责任险</c:if>
				    			<c:if test = "${child.insuranceType == '6' }">玻璃单独破碎险</c:if>
				    			<c:if test = "${child.insuranceType == '7' }">自燃险</c:if>
				    			<c:if test = "${child.insuranceType == '8' }">划痕险</c:if>
				    			<c:if test = "${child.insuranceType == '9' }">不计免赔特约险</c:if>
							</td>
							<td>${child.insuranceCarriers}</td>
							<td>${child.insuranceCost}</td>
							<td>${child.insuranceAmount}</td>
							<td><fmt:formatDate value="${child.insuredTime}" pattern="yyyy-MM-dd"/></td>
							<td><fmt:formatDate value="${child.expireTime}" pattern="yyyy-MM-dd"/></td>
							<td>
								<c:if test = "${child.insuranceValidity == '1' }">在保</c:if>
				    			<c:if test = "${child.insuranceValidity == '0' }">过保</c:if>
							</td>
							<td>${child.insuranceRemark}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div>
				<table class="list nowrap" width="100%">
					<thead align="center">
						<tr>
							<th>年审周期</th>
							<th>上次年审时间</th>
							<th>下次年审时间</th>
						</tr>
					</thead>
					<tbody align="center" style="color:maroon">
						<c:forEach var="child" items="${vehicle.inspectionList}" varStatus="status">
						<tr class="unitBox">
							<td>${child.annualCycle}</td>
							<td><fmt:formatDate value="${child.lastTime}" pattern="yyyy-MM-dd"/></td>
							<td><fmt:formatDate value="${child.nextTime}" pattern="yyyy-MM-dd"/></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div>
				<table class="list nowrap" width="100%">
					<thead align="center">
						<tr>
							<th>加装项</th>
							<th>加装时间</th>
							<th>价格明细 </th>
						</tr>
					</thead>
					<tbody align="center" style="color:maroon">
						<c:forEach var="child" items="${vehicle.installationList}" varStatus="status">
						<tr class="unitBox">
							<td>${child.addItem}</td>
							<td><fmt:formatDate value="${child.installationTime}" pattern="yyyy-MM-dd"/></td>
							<td>${child.price}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
</div>
<div class="formBar">
	<ul>
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
	</ul>
</div>
