<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/security/orgCode/list" page="${page }">
	<input type="hidden" name="keywords" value="${keywords}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/security/orgCode/list" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>机构代码：</label>
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
			<shiro:hasPermission name="OrgCode:view">
				<li><a iconClass="magnifier" target="dialog" mask="true" width="530" height="300" href="${contextPath }/management/security/orgCode/view/{slt_uid}"><span>查看机构</span></a></li>
			</shiro:hasPermission>		
			<shiro:hasPermission name="OrgCode:save">
				<li><a iconClass="shield_add" target="dialog" mask="true" width="530" height="300" href="${contextPath }/management/security/orgCode/create"><span>添加机构</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="OrgCode:edit">
				<li><a iconClass="shield_go" target="dialog" mask="true" width="530" height="300" href="${contextPath }/management/security/orgCode/edit/{slt_uid}"><span>编辑机构</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="OrgCode:delete">
				<li><a iconClass="shield_delete" target="selectedTodo" rel="ids" href="${contextPath }/management/security/orgCode/delete" title="确认要删除机构?"><span>删除机构</span></a></li>
			</shiro:hasPermission>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
			    <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="100">机构代码</th>
				<th width="200">机构名称</th>
				<th width="200">行政区划代码</th>
				<th width="200">汉口银行业务编号</th>
				<th width="200">通联商户代码</th>
				<th width="200">TPDU</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${orgCodes}">
			<tr target="slt_uid" rel="${item.id}">
			    <td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.origorgcode}</td>
			    <td>${item.orgname}</td>		
			    <td>${item.yycsdm}</td>	
			    <td>${item.bankYwbh}</td>
			    <td>${item.tlsfdm}</td>
			    <td>${item.tlTpdu}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>