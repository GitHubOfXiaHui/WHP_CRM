<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/insurance/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_license" value="${LIKE_license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/insurance/list" onsubmit="return navTabSearch(this);">
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
				<li id='insuranceAdd'><a iconClass="page_white_add" target="dialog" max="true" mask="true" width="530" height="250" href="${contextPath }/management/vehicle/insurance/create/{slt_uid}"><span>录入保险信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:edit"> --%>
				<li id='insuranceEdit'><a iconClass="page_white_edit" target="dialog" max="true" mask="true" width="530" height="250" href="${contextPath }/management/vehicle/insurance/update/{slt_uid}"><span>编辑保险信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:delete"> --%>
				<li><a iconClass="magnifier" target="dialog" max=true mask="true" href="${contextPath}/management/vehicle/insurance/view/{slt_uid}"><span>查看保险信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th>车牌号</th>
				<th>车辆型号</th>
				<th>车辆配置</th>
				<th>排量</th>
				<th>购买时间</th>
				<th>保险信息状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${vehicles}">
			<tr target="slt_uid" rel="${item.id}" onclick="displayButton('${item.insuranceStatus}')">
				<td>${item.license}</td>
				<td>${item.type}</td>
				<td>${item.configuration}</td>
				<td>${item.displacement}</td>
				<td><fmt:formatDate value="${item.buyingTime}" pattern="yyyy-MM-dd"/></td>
				<td>
				<c:if test="${item.insuranceStatus==1}">已录入</c:if>
				<c:if test="${item.insuranceStatus==0}">未录入</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
	
</div>

<script type="text/javascript">
function displayButton(status) {
	if(status=='1') {
		$("#insuranceAdd").hide();
		$("#insuranceEdit").show();
	} else if(status=='0') {
		$("#insuranceAdd").show();
		$("#insuranceEdit").hide();
	}
}
</script>