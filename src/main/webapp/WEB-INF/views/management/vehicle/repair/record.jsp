<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/repair/affirm/record" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/repair/affirm/record" onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>车牌号：</label>
					<input type="text" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
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
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th>车牌号</th>
				<th>车辆型号</th>
				<th>排量</th>
				<th>检修地点</th>
				<th>检修原因</th>
				<th>送检时间</th>
				<th>接车时间</th>
				<th>检修费用</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${repairs}">
			<tr target="slt_uid" rel="${item.id}">
				<td>${item.parent.license}</td>
				<td>${item.parent.type}</td>
				<td>${item.parent.displacement}</td>
				<td>${item.repairSite}</td>
				<td>${item.repairDescript}</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.actualEndTime}" pattern="yyyy-MM-dd"/></td>
				<td>${item.actualPrice}</td>
				<td>${item.affirmRemark}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>
