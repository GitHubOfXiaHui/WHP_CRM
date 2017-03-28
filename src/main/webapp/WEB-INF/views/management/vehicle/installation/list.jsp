<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<script type="text/javascript">
<!--
	function close2upload() {
		navTab.reload('${contextPath }/management/vehicle/installation/list', {});
		return true;
	}
//-->
</script>
<keta:paginationForm action="${contextPath }/management/vehicle/installation/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_addItem" value="${LIKE_addItem}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/installation/list" onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>车牌号：</label>
					<input type="text" name="search_LIKE_addItem" value="${LIKE_addItem}"/>
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
				<li><a iconClass="page_white_add" target="dialog" mask="true" width="530" height="250" href="${contextPath }/management/vehicle/installation/create"><span>添加</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:edit"> --%>
				<li><a iconClass="page_white_edit" target="dialog" mask="true" width="530" height="250" href="${contextPath }/management/vehicle/installation/update/{slt_uid}"><span>编辑</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:delete"> --%>
				<li><a iconClass="page_white_delete" target="selectedTodo" rel="ids" href="${contextPath }/management/vehicle/installation/delete" title="确认要删除选定的车辆加装信息?"><span>删除</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:import">
				<li><a iconClass="page_white_get" target="dialog" mask="true" width="430" height="300" close="close2upload" href="${contextPath }/management/vehicle/vehicle/import"><span>导入</span></a></li>
			</shiro:hasPermission>	 --%>
			<%-- <shiro:hasPermission name="Vehicle:export">
				<li><a iconClass="page_white_put" target="dialog" mask="true" width="430" height="300" close="close2upload" href="${contextPath }/management/vehicle/vehicle/export"><span>导出</span></a></li>
			</shiro:hasPermission>	 --%>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>加装项</th>
				<th>加装时间</th>
				<th>价格明细</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${installations}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.addItem}</td>
				<td>${item.installationTime}</td>
				<td>${item.price}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>