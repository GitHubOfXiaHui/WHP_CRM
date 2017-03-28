<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<script type="text/javascript">
<!--
	function close2upload() {
		navTab.reload('${contextPath }/management/vehicle/query/list', {});
		return true;
	}
//-->
</script>
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

	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>车牌号</th>
				<th>车辆型号</th>
				<th>车辆颜色</th>
				<th>车辆配置</th>
				<th>排量</th>
				<th>乘员数</th>
				<th>价格</th>
				<th>购置税</th>
				<th>购买时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${vehicles}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.license}</td>
				<td>${item.type}</td>
				<td>${item.color}</td>
				<td>${item.configuration}</td>
				<td>${item.displacement}</td>
				<td>${item.crew}</td>
				<td>${item.price}</td>
				<td>${item.purchaseTax}</td>
				<td>${item.buyingTime}</td>
				<td><a target="navTab" rel="query_details" href="${contextPath }/management/vehicle/query/details/${item.id}" title="车辆详细信息">详情</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>