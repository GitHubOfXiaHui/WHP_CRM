<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<form method="post" id="inspectionRecordForm" action="${contextPath }/management/vehicle/inspection/record"
	class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="97">
		<p>
			<label>车牌号：</label> 
			<input type="text" value='${vehicle.license }' readonly="readonly" /> 
			<input type="hidden" name="id" value='${vehicle.id }' />
		</p>
		<p>
			<label>车辆型号：</label> 
			<input type="text" value='${vehicle.type }' readonly="readonly" />
		</p>
		<p>
			<label>车辆配置：</label> 
			<input type="text" value='${vehicle.configuration }' readonly="readonly" />
		</p>
		<p>
			<label>排量：</label> 
			<input type="text" value='${vehicle.displacement }' readonly="readonly" />
		</p>
		<p>
			<label>购买时间：</label> 
			<input type="text" value='<fmt:formatDate value="${vehicle.buyingTime}" pattern="yyyy-MM-dd"/>' readonly="readonly" />
		</p>
		<div class="divider"></div>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:;"><span>年审信息</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 220px;">
				<div>
					<table class="list nowrap itemDetail" addButton="添加" width="100%">
						<thead align="center">
							<tr>
								<th type="enum" name="inspectionList[#index#].annualCycle" 
									enumUrl="${contextPath }/management/vehicle/inspection/select">年审周期</th>
								<th type="date" format="yyyy-MM-dd" name="inspectionList[#index#].lastTime"
									fieldClass="validate[required,maxSize[10]] required"  size="12"
									defaultVal="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>">上次年审时间</th>
								<th type="text" name="inspectionList[#index#].inspectionResult" 
									fieldClass="validate[required,maxSize[64]] required" size="20">年审结果</th>
								<th type="text" name="insuranceList[#index#].inspectionRemark" size="30">备注</th>
								<th type="del" width="40">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="child" items="${vehicle.inspectionList}" 
								varStatus="status">
								<tr class="unitBox">
									<input type="hidden" name="inspectionList[${status.index}].id" value="${child.id}" />
									<input type="hidden" name="inspectionList[${status.index}].parent.id" value="${child.parent.id}" />
									<td>
										<select class="combox" name="inspectionList[${status.index}].annualCycle">
											<option value="12" <c:if test="${child.annualCycle == '12'}">selected</c:if>>两年一审</option>
											<option value="11" <c:if test="${child.annualCycle == '11'}">selected</c:if>>一年一审</option>
										    <option value="21" <c:if test="${child.annualCycle == '21'}">selected</c:if>>一年两审</option>
										</select>
									</td>
									<td><input type="date" class="date validate[required,maxSize[10]] required" size="12" 
											name="inspectionList[${status.index}].lastTime" value="<fmt:formatDate value="${child.lastTime}" pattern="yyyy-MM-dd"/>"/></td>
									<td><input type="text" class="validate[required,maxSize[64]] required" 
											name="inspectionList[${status.index}].inspectionResult" value="${child.inspectionResult}"  size="20"/></td>
									<td><input type="text" name="inspectionList[${status.index}].inspectionRemark" value="${child.inspectionRemark}"  size="30"/></td>
									<td><a href="javascript:void(0)" class="btnDel">删除</a></td>
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
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>