<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>


<form method="post" id="insuranceCreateForm" action="${contextPath }/management/vehicle/inspection/create" class="required-validate pageForm"
	onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="97">
		<p>
			<label>车牌号：</label>
			<input type="text" name="license" value='${vehicle.license }' readonly="readonly" /> 
			<input type="hidden" name="id" value='${vehicle.id }' />
		</p>
		<p>
			<label>车辆型号：</label>
			<input type="text" name="type" value='${vehicle.type }' readonly="readonly" /> 
		</p>
		<p>
			<label>车辆配置：</label>
			<input type="text" name="ename" value='${vehicle.configuration }' readonly="readonly" /> 
		</p>
		<p >
			<label>排量：</label>
			<input type="text" name="spell" value='${vehicle.displacement }' readonly="readonly" />
		</p>
		<p>
			<label>购买时间：</label>
			<input type="text" name="legal" value='${vehicle.buyingTime }' readonly="readonly" />
		</p>
		<div class="divider"></div>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:void(0)"><span>年审信息</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 220px;">
				<div>
					<table class="list nowrap itemDetail" addButton="添加" width="100%">
						<thead align="center">
							<tr>
								<th type="text" name="inspectionList[#index#].annualCycle" size="20" fieldClass="validate[required,maxSize[64]] required">年审周期</th>
								<th type="date" format="yyyy-MM-dd"
									name="inspectionList[#index#].lastTime" size="12"
									fieldClass="validate[required,maxSize[10]] required"
									defaultVal="<%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())%>">上次年审时间</th>
								<th type="date" format="yyyy-MM-dd"
									name="inspectionList[#index#].nextTime" size="12"
									fieldClass="validate[required,maxSize[10]] required"
									defaultVal="<%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())%>">下次年审时间</th>
								<th type="del" width="40">操作</th>
							</tr>
						</thead>
						<tbody align="center"></tbody>
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