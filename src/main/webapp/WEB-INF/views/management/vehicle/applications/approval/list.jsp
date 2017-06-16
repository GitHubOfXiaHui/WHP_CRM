<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/applications/approval/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/applications/approval/list" onsubmit="return navTabSearch(this);">
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

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li class="approval1"><a iconClass="page_white_add" rel="pass" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/approval1/pass/{slt_uid}" title="确定要通过申请吗？"><span>通过申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li class="approval1"><a iconClass="page_white_add" rel="reject" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/approval1/reject/{slt_uid}" title="确定要驳回申请吗？"><span>驳回申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th>申请状态</th>
				<th>申请人姓名</th>
				<th>目的地</th>
				<th>驾驶员</th>
				<th>乘车人数（人）</th>
				<th>车辆用途</th>
				<th>起始时间</th>
				<th>截止时间</th>
				<th>申请人</th>
				<th>申请人所在派出所</th>
				<th>车牌号</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${applications}">
			<tr target="slt_uid" rel="${item.id}" onclick="displayButton('${item.approvalStatus }')">
				<td>
				<c:choose>
					<c:when test="${item.approvalStatus == '11'}">等待所领导审批</c:when>
					<c:when test="${item.approvalStatus == '12'}">等待警务保障室审批</c:when>
					<c:when test="${item.approvalStatus == '13'}">等待局领导审批</c:when>
					<c:when test="${item.approvalStatus == '00'}">通过</c:when>
					<c:when test="${item.approvalStatus == '99'}">驳回</c:when>
					<c:when test="${item.approvalStatus == '88'}">还车确认</c:when>
				</c:choose>
				</td>
				<td>${item.departure}</td>
				<td>${item.destination}</td>
				<td>${item.driver}</td>
				<td>${item.passengerNum}</td>
				<td>${item.applicationIntent}</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd"/></td>
				<td>${item.applicationUser.realname}</td>
				<td>${item.applicationUser.organization.name}</td>
				<td>${item.parent.license}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>
<script type="text/javascript">
function displayButton(status) {
	if (status == "00") {
		$("li.approval1").hide();
	}else if(status != "00") {
		$("li.approval1").show();
	}
}
</script>