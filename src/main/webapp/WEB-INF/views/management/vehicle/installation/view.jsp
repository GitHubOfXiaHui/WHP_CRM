<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageFormContent" layoutH="97">
	<div>
		<p>
			<label>车牌号：</label>
			<input type="text" value='${entity.license }' readonly="readonly" /> 
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" value='${entity.type }' readonly="readonly" /> 
		</p>
		<p>
			<label>车辆配置：</label>
			<input type="text" value='${entity.configuration }' readonly="readonly" /> 
		</p>
		<p >
			<label>排量：</label>
			<input type="text" value='${entity.displacement }' readonly="readonly" />
		</p>
		<p>
			<label>购买时间：</label>
			<input type="text" value='<fmt:formatDate value="${entity.buyingTime}" pattern="yyyy-MM-dd"/>' readonly="readonly" />
		</p>
	</div>
	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsContent" style="height: 220px;">
			<div>
				<table class="list nowrap" width="100%">
					<thead align="center">
						<tr>
							<th>加装项</th>
							<th>加装时间</th>
							<th>价格明细 (元)</th>
							<th>加载说明</th>
						</tr>
					</thead>
					<tbody align="center" style="color:maroon">
						<c:forEach var="child" items="${entity.installationList}" varStatus="status">
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
