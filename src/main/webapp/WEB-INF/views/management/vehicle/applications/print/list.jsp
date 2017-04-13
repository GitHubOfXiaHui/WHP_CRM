<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/applications/print/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="allApplications" value="${allApplications }"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/applications/print/list" onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<input type="checkbox" name="allApplications" value="true"  <c:if test="${allApplications }">checked</c:if>/>全部申请单
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
				<li id="print"><a iconClass="page_white_add" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/print/{slt_uid}"><span>打印申请单</span></a></li>
			<%-- </shiro:hasPermission> --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th>审批状态</th>
				<th>出发地</th>
				<th>目的地</th>
				<th>驾驶员</th>
				<th>乘车人数</th>
				<th>车辆用途</th>
				<th>是否需要局领导审批</th>
				<th>起始时间</th>
				<th>截止时间</th>
				<th>申请人</th>
				<th>车牌号</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${applications}">
			<tr target="slt_uid" rel="${item.id}" onclick="canPrint('${item.approvalStatus }');">
				<td>
				<c:choose>
					<c:when test="${item.approvalStatus == '11'}">等待所领导审批</c:when>
					<c:when test="${item.approvalStatus == '12'}">等待吴主任审批</c:when>
					<c:when test="${item.approvalStatus == '13'}">等待局领导审批</c:when>
					<c:when test="${item.approvalStatus == '00'}">通过</c:when>
					<c:when test="${item.approvalStatus == '99'}">驳回</c:when>
				</c:choose>
				</td>
				<td>${item.departure}</td>
				<td>${item.destination}</td>
				<td>${item.driver}</td>
				<td>${item.passengerNum}</td>
				<td>${item.applicationIntent}</td>
				<td>
				<c:choose>
					<c:when test="${item.requireApproval}">是</c:when>
					<c:otherwise>否</c:otherwise>
				</c:choose>
				</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd"/></td>
				<td>${item.applicationUser.realname}</td>
				<td>${item.parent.license}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>

<script type="text/javascript">
function canPrint(approvalStatus) {
	if (approvalStatus == '00') {
		$('#print').show();
	} else {
		$('#print').hide();
	}
}
</script>
