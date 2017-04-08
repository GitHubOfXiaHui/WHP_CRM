<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<form method="post" id="insuranceCreateForm" action="${contextPath }/management/vehicle/insurance/update"
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
						<li class="selected"><a href="javascript:;"><span>保险信息</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 220px;">
				<div>
					<table class="list nowrap itemDetail" addButton="添加" width="100%">
						<thead align="center">
							<tr>
								<th type="enum" name="insuranceList[#index#].insuranceType"
									enumUrl="${contextPath }/management/vehicle/insurance/select"
									size="16" postField="" defaultVal="2">保险类型</th>
								<th type="text" name="insuranceList[#index#].insuranceCarriers"
									fieldClass="validate[required,maxSize[64]] required" size="20">承保公司</th>
								<th type="text" name="insuranceList[#index#].insuranceCost"
									fieldClass="validate[required,custom[number],maxSize[10]] required" size="20" defaultVal="0.0">保险价格（元）</th>
								<th type="text" name="insuranceList[#index#].insuranceAmount"
									fieldClass="validate[required,custom[number],maxSize[10]] required" size="20" defaultVal="0.0">保险额度（万元）</th>
								<th type="date" format="yyyy-MM-dd"
									name="insuranceList[#index#].insuredTime" size="12"
									fieldClass="validate[required,maxSize[10]] required"
									defaultVal="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>">投保时间</th>
								<th type="date" format="yyyy-MM-dd"
									name="insuranceList[#index#].expireTime" size="12"
									fieldClass="validate[required,maxSize[10]] required"
									defaultVal="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>">过保时间</th>
								<th type="text" name="insuranceList[#index#].insuranceRemark" size="30">备注</th>
								<th type="del" width="40">操作</th>
							</tr>
						</thead>
						<tbody align="center">
							<c:forEach var="child" items="${vehicle.insuranceList}"
								varStatus="status">
								<tr class="unitBox">
									<input type="hidden" name="insuranceList[${status.index}].id" value="${child.id}" />
									<input type="hidden" name="insuranceList[${status.index}].parent.id" value="${child.parent.id}" />
									<td>
										<select class="combox" name="insuranceList[${status.index}].insuranceType">
											<option value="9" ${child.insuranceType =='9' ? 'selected':''}>不计免赔特约险</option>
											<option value="8" ${child.insuranceType =='8' ? 'selected':''}>划痕险</option>
	    									<option value="7" ${child.insuranceType =='7' ? 'selected':''}>自燃险</option>
											<option value="6" ${child.insuranceType =='6' ? 'selected':''}>玻璃单独破碎险</option>
	    									<option value="5" ${child.insuranceType =='5' ? 'selected':''}>车上座位责任险</option>
											<option value="4" ${child.insuranceType =='4' ? 'selected':''}>盗抢险</option>
	    									<option value="3" ${child.insuranceType =='3' ? 'selected':''}>第三者责任险</option>
	    									<option value="2" ${child.insuranceType =='2' ? 'selected':''}>车辆损失险</option>
	    									<option value="1" ${child.insuranceType =='1' ? 'selected':''}>交强险</option>
										</select>
									</td>
									<td><input type="text" name="insuranceList[${status.index}].insuranceCarriers" value="${child.insuranceCarriers}" Class="validate[required,maxSize[64]] required"/></td>
									<td><input type="text" name="insuranceList[${status.index}].insuranceCost" value="${child.insuranceCost}"/></td>
									<td><input type="text" name="insuranceList[${status.index}].insuranceAmount" value="${child.insuranceAmount}"/></td>
									<td><input type="date" class="date required" size="10" value="<fmt:formatDate value="${child.insuredTime}" pattern="yyyy-MM-dd"/>"  name="insuranceList[${status.index}].insuredTime"/></td>
									<td><input type="date" class="date required" size="10" value="<fmt:formatDate value="${child.expireTime}" pattern="yyyy-MM-dd"/>"  name="insuranceList[${status.index}].expireTime"/></td>
									<td><input type="text" name="insuranceList[${status.index}].insuranceRemark" value="${child.insuranceRemark}" size="30"/></td>
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