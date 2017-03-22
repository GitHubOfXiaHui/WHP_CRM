<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<a id="refreshJbsxBox2organizationTree" rel="jbsxBox2organizationTree" target="ajax" href="${contextPath}/management/security/organization/tree" style="display:none;"></a>
<keta:paginationForm action="${contextPath}/management/security/organization/list/${parentOrganizationId}" page="${page }" onsubmit="return divSearch(this, 'jbsxBox2organizationList');">
	<input type="hidden" name="search_LIKE_name" value="${LIKE_name}"/>
	<input type="hidden" name="search_LIKE_code" value="${LIKE_code}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/security/organization/list/${parentOrganizationId}" onsubmit="return divSearch(this, 'jbsxBox2organizationList');">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>组织名称：</label>
					<input type="text" name="search_LIKE_name" value="${LIKE_name}"/>
				</li>
				<li>
					<label>机构代码：</label>
					<input type="text" name="search_LIKE_code" value="${LIKE_code}"/>
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
		<shiro:hasPermission name="Organization:view">
				<li id="create"><a class="add" target="dialog"   width="550" height="300" rel="IMPORTINFO" mask="true" href="${contextPath }/management/security/organization/preImportInfo/${parentOrganizationId}"><span>导入</span></a></li>
			</shiro:hasPermission>
		<shiro:hasPermission name="Organization:save">
			<li><a iconClass="group_add" target="dialog" mask="true" width="630" height="350" rel="org_add" href="${contextPath}/management/security/organization/create/${parentOrganizationId}"><span>添加组织</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Organization:edit">
			<li><a iconClass="group_edit" target="dialog" mask="true" rel="lookupParent2org_edit" width="630" height="350" href="${contextPath}/management/security/organization/update/{slt_uid}"><span>编辑组织</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Organization:delete">
			<li><a iconClass="group_delete" target="ajaxTodo" callback="dialogReloadRel2Org" href="${contextPath}/management/security/organization/delete/{slt_uid}" title="确认要删除该组织?"><span>删除组织</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Organization:assign">
			<li class="line">line</li>
			<li><a iconClass="shield_add" target="dialog" mask="true" width="400" height="500" href="${contextPath}/management/security/organization/lookup2create/organizationRole/{slt_uid}"><span>分配角色</span></a></li>
			<li><a iconClass="shield_delete" target="dialog" mask="true" width="400" height="500" href="${contextPath}/management/security/organization/lookup2delete/organizationRole/{slt_uid}"><span>撤销角色</span></a></li>
		</shiro:hasPermission>		
		</ul>
	</div>
	<table class="table" layoutH="142" width="100%" rel="jbsxBox2organizationList" >
		<thead>
			<tr>
				<th width="150">名称</th>
				<th width="100">机构代码</th>
				<th width="65">机构类型</th>
				<th width="90">行政区划名称</th>
				<th width="90">行政区划代码</th>
				<th width="150">父组织</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${organizations}">
			<tr target="slt_uid" rel="${item.id}">
				<td><a href="${contextPath}/management/security/organization/list/${item.id}" target="ajax" rel="jbsxBox2organizationList">${item.name}</a></td>
				<td>${item.code}</td>
				<td> 
					<c:if test="${item.jglx==1 }">医疗机构 </c:if>
					<c:if test="${item.jglx==2 }">供应商</c:if>
					<c:if test="${item.jglx==3 }">银行</c:if>
					<c:if test="${item.jglx==4 }">区级管理机构</c:if>
					<c:if test="${item.jglx==5 }">市级管理机构</c:if>
				</td>
				<td>${item.areaName}</td>
				<td>${item.areaCode}</td>
				 
				<td>${item.parent.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 分页 -->
	<keta:pagination page="${page }" rel="jbsxBox2organizationList" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox2organizationList')"/>
</div>