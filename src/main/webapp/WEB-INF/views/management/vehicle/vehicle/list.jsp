<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<script type="text/javascript">
<!--
	function close2upload() {
		navTab.reload('${contextPath }/management/vehicle/vehicle/list', {});
		return true;
	}
//-->
</script>
<keta:paginationForm action="${contextPath }/management/vehicle/vehicle/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_license" value="${LIKE_license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/vehicle/list" onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>车牌号：</label>
					<input type="text" name="search_LIKE_license" value="${LIKE_license}"/>
				</li>
			</ul>
			<div class="subBar">
				<ul>						
					<li><div class="button"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li><a iconClass="page_white_add" target="dialog" mask="true" rel="vehicle_save" width="500" height="400" href="${contextPath }/management/vehicle/vehicle/create"><span>录入车辆信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:edit"> --%>
				<li><a iconClass="page_white_edit" target="dialog" mask="true" rel="vehicle_update" width="500" height="400" href="${contextPath }/management/vehicle/vehicle/update/{slt_uid}"><span>编辑车辆信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:delete"> --%>
				<li><a iconClass="page_white_delete" target="selectedTodo" rel="ids" href="${contextPath }/management/vehicle/vehicle/delete" title="确认要删除选定的车辆信息?"><span>删除车辆信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:import">
				<li><a iconClass="page_white_get" target="dialog" mask="true" width="430" height="300" close="close2upload" href="${contextPath }/management/vehicle/vehicle/import"><span>导入</span></a></li>
			</shiro:hasPermission>	 --%>
			<%-- <shiro:hasPermission name="Vehicle:export">
				<li><a iconClass="page_white_put" target="dialog" mask="true" width="430" height="300" close="close2upload" href="${contextPath }/management/vehicle/vehicle/export"><span>导出</span></a></li>
			</shiro:hasPermission>	 --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>车牌号</th>
				<th>车辆型号</th>
				<th>所属单位</th>
				<th>车型</th>
				<th>排量</th>
				<th>车架号</th>
				<th>发动机号</th>
				<th>价格（万元）</th>
				<th>行驶公里数</th>
				<th>购买时间</th>
				<th>用途</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${vehicles}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.license}</td>
				<td>${item.type}</td>
				<td>${item.organization.name}</td>
				<td>
				<c:if test="${item.vehicleType==1}">小型汽车</c:if>
				<c:if test="${item.vehicleType==2}">中型客车</c:if></td>
				<td>${item.displacement}</td>
				<td>${item.vehicleNumber}</td>
				<td>${item.engineNumber}</td>
				<td>${item.price}</td>
				<td>${item.mileage}</td>
				<td><fmt:formatDate value="${item.buyingTime}" pattern="yyyy-MM"/></td>
				<td>
				<c:if test="${item.utility==1}">特种专业技术用车</c:if>
				<c:if test="${item.utility==2}">执法执勤用车</c:if></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>