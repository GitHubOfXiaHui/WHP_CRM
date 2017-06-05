<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/repair/print/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="allApplications" value="${allApplications }"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/repair/print/list" onsubmit="return navTabSearch(this);">
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
				<li id="print1"><a iconClass="page_white_add" target="dialog" mask="true" width="800" height="450" href="${contextPath }/management/vehicle/repair/print/{slt_uid}"><span>打印申请单</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
			<%-- 	<li><a iconClass="page_white_add" target="ajaxTodo" href="${contextPath }/management/vehicle/repair/cancel/{slt_uid}"><span>取消申请单</span></a></li>
			</shiro:hasPermission> --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
				<th>车牌号</th>
				<th>申请状态</th>
				<th>检修地点</th>
				<th>预计检修费用</th>
				<th>检修原因</th>
				<th>送检时间</th>
				<th>接车时间</th>
				<th>申请人</th>
				<th>申请人所在派出所</th>
		</thead>
		<tbody>
			<c:forEach var="item" items="${repairs}">
			<tr target="slt_uid" rel="${item.id}" onclick="canPrint('${item.approvalStatus }')">
				<td>${item.parent.license}</td>
				<td>
				<c:choose>
					<c:when test="${item.approvalStatus == '11'}">等待所领导审批</c:when>
					<c:when test="${item.approvalStatus == '12'}">等待警务保障室审批</c:when>
					<c:when test="${item.approvalStatus == '13'}">等待局领导审批</c:when>
					<c:when test="${item.approvalStatus == '00'}">通过</c:when>
					<c:when test="${item.approvalStatus == '99'}">驳回</c:when>
					<c:when test="${item.approvalStatus == '88'}">检修确认</c:when>
				</c:choose>
				</td>
				<td>${item.repairSite}</td>
				<td>${item.price}</td>
				<td>${item.repairDescript}</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd"/></td>
				<td>${item.applicationUser.realname}</td>
				<td>${item.applicationUser.organization.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>

<script type="text/javascript">
function canPrint(approvalStatus) {
	if (approvalStatus == '00'||approvalStatus == '88') {
		$('#print1').show();
	} else {
		$('#print1').hide();
	}
}
</script>
