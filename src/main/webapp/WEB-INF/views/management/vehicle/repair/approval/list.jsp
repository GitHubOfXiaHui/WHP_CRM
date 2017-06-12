<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/repair/approval/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/repair/approval/list" onsubmit="return navTabSearch(this);">
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
				<li class="approval1"><a iconClass="page_white_add" rel="pass" target="ajaxTodo" href="${contextPath }/management/vehicle/repair/approval1/pass/{slt_uid}" title="确定要通过申请吗？"><span>通过申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li class="approval1"><a iconClass="page_white_add" rel="reject" target="ajaxTodo" href="${contextPath }/management/vehicle/repair/approval1/reject/{slt_uid}" title="确定要驳回申请吗？"><span>驳回申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th>申请状态</th>
				<th>车牌号</th>
				<th>检修地点</th>
				<th>预计检修费用</th>
				<th>检修原因</th>
				<th>送检时间</th>
				<th>接车时间</th>
				<th>是否需要局领导审批</th>
				<th>申请人</th>
				<th>申请人所在派出所</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${repairs}">
			<tr target="slt_uid" rel="${item.id}" onclick="displayButton('${item.approvalStatus }')">
				
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
				<td>${item.parent.license}</td>
				<td>${item.repairSite}</td>
				<td>${item.price}</td>
				<td>${item.repairDescript}</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd"/></td>
				<c:if test="${item.requireApproval}"><td>是</td></c:if>
				<c:if test="${!item.requireApproval}"><td>否</td></c:if>
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
function displayButton(status) {
	if (status == "00") {
		$("li.approval1").hide();
	}else if(status != "00") {
		$("li.approval1").show();
	}
}
</script>