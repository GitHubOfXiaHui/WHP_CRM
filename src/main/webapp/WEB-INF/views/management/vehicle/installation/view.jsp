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
								<th type="text" name="installationList[#index#].addItem" size="20" fieldClass="validate[required,maxSize[64]] required">加装项</th>
								<th type="date" format="yyyy-MM-dd"
									name="installationList[#index#].installationTime" size="12"
									fieldClass="validate[required,maxSize[10]] required">加装时间</th>
								<th type="text" name="insuranceList[#index#].price" fieldClass="validate[maxSize[10]]" size="20">价格明细 </th>
							</tr>
						</thead>
						<tbody align="center" style="color:maroon">
							<c:forEach var="child" items="${entity.installationList}" varStatus="status">
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
