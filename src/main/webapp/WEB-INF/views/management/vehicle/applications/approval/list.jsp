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
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li class="approval2" style="display: none"><a iconClass="page_white_add" rel="pass" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/approval2/pass/{slt_uid}" title="确定要通过申请吗？"><span>通过申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li class="approval2" style="display: none"><a iconClass="page_white_add" rel="reject" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/approval2/reject/{slt_uid}" title="确定要驳回申请吗？"><span>驳回申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li class="approval3" style="display: none"><a iconClass="page_white_add" rel="pass" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/approval3/pass/{slt_uid}" title="确定要通过申请吗？"><span>通过申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li class="approval3" style="display: none"><a iconClass="page_white_add" rel="reject" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/approval3/reject/{slt_uid}" title="确定要驳回申请吗？"><span>驳回申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:save"> --%>
				<li><a iconClass="page_white_add" rel="cancel" target="ajaxTodo" href="${contextPath }/management/vehicle/applications/cancel/{slt_uid}" title="确定要取消申请吗？"><span>取消申请</span></a></li>
			<%-- </shiro:hasPermission> --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th>申请状态</th>
				<th>目的地</th>
				<th>车牌号</th>
				<th>车辆型号</th>
				<th>车辆颜色</th>
				<th>车辆配置</th>
				<th>排量</th>
				<th>乘员数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${applications}">
			<tr target="slt_uid" rel="${item.id}" onclick="displayButton('${item.approvalStatus }')">
				<td>
				<c:choose>
					<c:when test="${item.approvalStatus == '11'}">等待所领导审批</c:when>
					<c:when test="${item.approvalStatus == '12'}">等待吴主任审批</c:when>
					<c:when test="${item.approvalStatus == '13'}">等待局领导审批</c:when>
					<c:when test="${item.approvalStatus == '00'}">申请通过</c:when>
					<c:when test="${item.approvalStatus == '99'}">申请驳回</c:when>
				</c:choose>
				</td>
				<td>${item.destination}</td>
				<td>${item.parent.license}</td>
				<td>${item.parent.type}</td>
				<td>${item.parent.color}</td>
				<td>${item.parent.configuration}</td>
				<td>${item.parent.displacement}</td>
				<td>${item.parent.crew}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>

<script type="text/javascript">
function displayButton(status) {
	if (status == "11") {
		$("li.approval1").show();
		$("li[class^=approval]:not(.approval1)").hide();
	} else if (status == "12") {
		$("li.approval2").show();
		$("li[class^=approval]:not(.approval2)").hide();
	} else if (status == "13") {
		$("li.approval3").show();
		$("li[class^=approval]:not(.approval3)").hide();
	} else {
		$("li[class^=approval]").hide();
	}
}
</script>
