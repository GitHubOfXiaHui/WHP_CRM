<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/applications/approval/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/applications/return/list" onsubmit="return navTabSearch(this);">
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
				<th>出发地</th>
				<th>目的地</th>
				<th>实际驾驶人</th>
				<th>乘车人数（人）</th>
				<th>车辆用途</th>
				<th>起始时间</th>
				<th>还车时间</th>
				<th>还车地点</th>
				<th>车行驶数始码</th>
				<th>车行驶数止码</th>
				<th>是否事故</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${applications}">
			<tr target="slt_uid" rel="${item.id}">
				<td>${item.parent.license}</td>
				<td>${item.parent.type}</td>
				<td>${item.parent.displacement}</td>
				<td>${item.departure}</td>
				<td>${item.destination}</td>
				<td>${item.actualDriver}</td>
				<td>${item.passengerNum}</td>
				<td>${item.applicationIntent}</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.returnDate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.returnSite}</td>
				<td>${item.startFGReading}</td>
				<td>${item.endFGReading}</td>
				<c:if test="${item.accident}"><td>是</td></c:if>
				<c:if test="${!item.accident}"><td>否</td></c:if>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>
