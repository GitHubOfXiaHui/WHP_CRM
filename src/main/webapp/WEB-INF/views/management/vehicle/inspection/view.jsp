<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageFormContent" layoutH="97">
	<div>
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
			<input type="text" name="legal" value='<fmt:formatDate value="${entity.buyingTime}" pattern="yyyy-MM-dd"/>' readonly="readonly" />
		</p>
	</div>
	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsContent" style="height: 220px;">
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
						<c:forEach var="child" items="${entity.inspectionList}">
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
