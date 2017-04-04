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
								<th type="text" name="inspectionList[#index#].annualCycle" size="20" fieldClass="validate[required,maxSize[64]] required">年审周期</th>
								<th type="date" format="yyyy-MM-dd"
									name="inspectionList[#index#].lastTime" size="12"
									fieldClass="validate[required,maxSize[10]] required">上次年审时间</th>
								<th type="date" format="yyyy-MM-dd"
									name="inspectionList[#index#].nextTime" size="12"
									fieldClass="validate[required,maxSize[10]] required">下次年审时间</th>
							</tr>
						</thead>
						<tbody align="center" style="color:maroon">
							<c:forEach var="child" items="${entity.inspectionList}" varStatus="status">
								<tr class="unitBox">
									<td>${child.annualCycle}</td>
									<td><fmt:formatDate value="${child.lastTime}" pattern="yyyy-MM-dd"/></td>
									<td><fmt:formatDate value="${child.nextTime}" pattern="yyyy-MM-dd"/></td>
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
