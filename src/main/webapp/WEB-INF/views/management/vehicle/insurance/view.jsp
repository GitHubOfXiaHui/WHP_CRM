<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

	<div class="pageFormContent" layoutH="97">
	<p>
			<label>车牌号：</label>
			<input type="text" name="license" value='${entity.license }' readonly="readonly" /> 
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" name="type" value='${entity.type }' readonly="readonly" /> 
		</p>
		<p>
			<label>车辆配置：</label>
			<input type="text" name="ename" value='${entity.configuration }' readonly="readonly" /> 
		</p>
		<p >
			<label>排量：</label>
			<input type="text" name="spell" value='${entity.displacement }' readonly="readonly" />
		</p>
		<p>
			<label>购买时间：</label>
			<input type="text" name="legal" value='${entity.buyingTime }' readonly="readonly" />
		</p>
	
	<div class="divider"></div>
		<div class="tabs">
			<div class="tabsContent" style="height: 220px;">
				<div>
					<table class="list nowrap" width="100%">
						<thead align="center">
							<tr>
								<th type="text" name="insuranceList[#index#].insuranceType"
									size="16" postField="">保险类型</th>
								<th type="text" name="insuranceList[#index#].insuranceCarriers" size="20" fieldClass="validate[required,maxSize[64]] required">承保公司</th>
								<th type="text" name="insuranceList[#index#].insuranceCost" fieldClass="validate[required,maxSize[10]] required" size="20">保险价格（元）</th>
								<th type="text" name="insuranceList[#index#].insuranceAmount" fieldClass="validate[maxSize[10]]" size="20">保险额度（万元） </th>
								<th type="date" format="yyyy-MM-dd"
									name="insuranceList[#index#].insuredTime" size="12"
									fieldClass="validate[required,maxSize[10]] required">投保时间</th>
								<th type="date" format="yyyy-MM-dd"
									name="insuranceList[#index#].expireTime" size="12"
									fieldClass="validate[required,maxSize[10]] required">过保时间</th>
									<th type="text" name="insuranceList[#index#].insuranceRemark" size="30">保险状态</th>
							    <th type="text" name="insuranceList[#index#].insuranceRemark" size="30">备注</th>
							</tr>
						</thead>
						<tbody align="center" style="color:maroon">
							<c:forEach var="child" items="${entity.insuranceList}" varStatus="status">
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
