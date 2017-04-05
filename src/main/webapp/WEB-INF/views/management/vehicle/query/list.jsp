<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/query/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_license" value="${LIKE_license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/query/list" onsubmit="return navTabSearch(this);">
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
			<%-- <shiro:hasPermission name="Vehicle:view"> --%>
				<li><a iconClass="magnifier" target="dialog" max="true" mask="true" width="530" height="250" href="${contextPath }/management/vehicle/query/details/{slt_uid}"  title="车辆详细信息"><span>查看车辆详细信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
		</ul>
	</div>
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th>车牌号</th>
				<th>车辆型号</th>
				<th>车辆颜色</th>
				<th>车辆配置</th>
				<th>排量</th>
				<th>乘员数</th>
				<th>价格</th>
				<th>购置税</th>
				<th>购买时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${vehicles}">
			<tr target="slt_uid" rel="${item.id}">
				<td>${item.license}</td>
				<td>${item.type}</td>
				<td>${item.color}</td>
				<td>${item.configuration}</td>
				<td>${item.displacement}</td>
				<td>${item.crew}</td>
				<td>${item.price}</td>
				<td>${item.purchaseTax}</td>
				<td><fmt:formatDate value="${item.buyingTime}" pattern="yyyy-MM-dd"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>