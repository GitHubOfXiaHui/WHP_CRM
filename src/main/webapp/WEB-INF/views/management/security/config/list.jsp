<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/security/config/list" page="${page }">
	<input type="hidden" name="keywords" value="${keywords}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/security/config/list" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>配置名称：</label>
					<input type="text" name="keywords" value="${keywords}"/>
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
			<%-- <shiro:hasPermission name="Config:view">
				<li><a iconClass="magnifier" target="dialog" mask="true" width="530" height="350" href="${contextPath }/management/security/config/view/{slt_uid}"><span>查看配置</span></a></li>
			</shiro:hasPermission>		
			<shiro:hasPermission name="Config:save">
				<li><a iconClass="shield_add" target="dialog" mask="true" width="530" height="350" href="${contextPath }/management/security/config/create"><span>添加配置</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Config:edit">
				<li><a iconClass="shield_go" target="dialog" mask="true" width="530" height="350" href="${contextPath }/management/security/config/update/{slt_uid}"><span>编辑配置</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Config:delete">
				<li><a iconClass="shield_delete" target="selectedTodo" rel="ids" href="${contextPath }/management/security/config/delete" title="确认要删除配置?"><span>删除配置</span></a></li>
			</shiro:hasPermission> --%>
			<li><a iconClass="magnifier" target="dialog" mask="true" width="530" height="350" href="${contextPath }/management/security/config/view/{slt_uid}"><span>查看配置</span></a></li>
		<li><a iconClass="shield_add" target="dialog" mask="true" width="530" height="350" href="${contextPath }/management/security/config/create"><span>添加配置</span></a></li>
		<li><a iconClass="shield_go" target="dialog" mask="true" width="530" height="350" href="${contextPath }/management/security/config/update/{slt_uid}"><span>编辑配置</span></a></li>
		<li><a iconClass="shield_delete" target="selectedTodo" rel="ids" href="${contextPath }/management/security/config/delete" title="确认要删除配置?"><span>删除配置</span></a></li>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
			    <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="100">配置名称</th>
				<th width="200">配置值</th>
				<th width="200">任务描述</th>
				<th width="200">最后更新时间</th>
				<th width="200">有效状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${configs}">
			<tr target="slt_uid" rel="${item.id}">
			    <td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.key}</td>
			    <td>${item.value}</td>		
			    <td>${item.description}</td>
			    <td><fmt:formatDate value="${item.updatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${item.status == "1" ? "有效":"无效"}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>