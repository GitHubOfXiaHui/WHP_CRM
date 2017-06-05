<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageFormContent" layoutH="97">
	<div>
		<p>
			<label>车牌号：</label>
			<input type="text" value="${vehicle.license }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" value="${vehicle.type }" size="30" readonly="readonly"/>
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
			<label>车型：</label>
		<c:if test="${vehicle.vehicleType==1 }"><input type="text" value="小型汽车" size="20" readonly="readonly"/></c:if>
		<c:if test="${vehicle.vehicleType==2 }"><input type="text" value="中型客车" size="20" readonly="readonly"/></c:if>
		</p>
		<p>
			<label>车架号：</label>
			<input type="text" name="vehicleNumber" size="30" value="${vehicle.vehicleNumber }" readonly="readonly"/>
		</p>
		<p>
			<label>发动机号：</label>
			<input type="text" name="engineNumber" size="20" value="${vehicle.engineNumber }" readonly="readonly"/>
		</p>
		<p>
			<label>用途：</label>
			<c:if test="${vehicle.utility==1 }"><input type="text" value="特种专业技术用车" size="20" readonly="readonly"/></c:if>
			<c:if test="${vehicle.utility==2 }"><input type="text" value="执法执勤用车" size="20" readonly="readonly"/></c:if>
		</p>
		<p>
			<label>乘员数（人）：</label>
			<input type="text" value="${vehicle.crew }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>行驶公里数：</label>
			<input type="text" readonly="readonly" class="validate[required,custom[integer]] required" name="mileage" value="${vehicle.mileage }" size="20"/>
		</p>
		<p>
			<label>价格（万元）：</label>
			<input type="text" value="${vehicle.price }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>购置税（元）：</label>
			<input type="text" value="${vehicle.purchaseTax }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>购买时间：</label>
			<input type="text" value="<fmt:formatDate value="${vehicle.buyingTime }" pattern="yyyy-MM"/>" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>所属单位：</label>
			<input type="text" value="${vehicle.organization.name }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>备注：</label>
			<textarea rows="2" cols="30" name="remark" readonly="readonly">${vehicle.remark }</textarea>
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
		<div class="tabsContent" style="height: 200px;">
			<div>
				<table class="list nowrap" width="100%">
					<thead align="center">
						<tr>
							<th>保险类型</th>
							<th>承保公司</th>
							<th>保险价格（元）</th>
							<th>保险额度（万元）</th>
							<th>投保时间</th>
							<th>过保时间</th>
							<th>保险状态</th>
						    <th>备注</th>
						</tr>
					</thead>
					<tbody align="center" style="color:maroon">
						<c:forEach var="child" items="${vehicle.insuranceList}">
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
							<th>年审结果</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody align="center" style="color:maroon">
						<c:forEach var="child" items="${vehicle.inspectionList}">
						<tr class="unitBox">
							<td>
							<c:choose>
								<c:when test="${child.annualCycle == '12'}">两年一审</c:when>
								<c:when test="${child.annualCycle == '11'}">一年一审</c:when>
								<c:when test="${child.annualCycle == '21'}">一年两审</c:when>
							</c:choose>
							</td>
							<td><fmt:formatDate value="${child.lastTime}" pattern="yyyy-MM-dd"/></td>
							<td><fmt:formatDate value="${child.nextTime}" pattern="yyyy-MM-dd"/></td>
							<td>${child.inspectionResult }</td>
							<td>${child.inspectionRemark }</td>
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
							<th>价格明细（元）</th>
							<th>加载说明</th>
						</tr>
					</thead>
					<tbody align="center" style="color:maroon">
						<c:forEach var="child" items="${vehicle.installationList}">
						<tr class="unitBox">
							<td>${child.addItem}</td>
							<td><fmt:formatDate value="${child.installationTime}" pattern="yyyy-MM-dd"/></td>
							<td>${child.price}</td>
							<td>${child.installationDescription}</td>
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
