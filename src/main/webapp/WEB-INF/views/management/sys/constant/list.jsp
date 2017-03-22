<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<a id="refreshJbsxBox2constantTree" rel="jbsxBox2constantTree" target="ajax" href="${contextPath}/management/sys/constant/tree" style="display:none;"></a>
<keta:paginationForm action="${contextPath}/management/sys/constant/list/${parentConstant.id}" page="${page }" onsubmit="return divSearch(this, 'jbsxBox2constantList');">
	<input type="hidden" name="keywords" value="${keywords}"/>
</keta:paginationForm>
<form method="post" action="<%=basePath %>/management/sys/constant/list/${parentConstant.id}" onsubmit="return divSearch(this, 'jbsxBox2constantList');">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>变量名称：</label>
					<input type="text" name="keywords" value="${keywords}"/>
				</li>
			</ul>
			<div class="subBar">
				<ul>						
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="Constant:save">
			<li><a class="add" target="dialog" width="550" height="350" mask="true" href="<%=basePath %>/management/sys/constant/create" ><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Constant:edit">
			<li><a class="edit" target="dialog" width="550" height="350" mask="true" href="<%=basePath %>/management/sys/constant/update/{slt_uid}" ><span>编辑</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="Constant:delete">
			<li><a class="delete" target="ajaxTodo" href="<%=basePath %>/management/sys/constant/delete/{slt_uid}" title="确认要删除该系统变量?"><span>删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<table class="table" layoutH="138" width="100%" rel="jbsxBox2constantList" >
		<thead align="center">
			<tr>
				<th width="20%" >编码</th>
				<th width="15%" >名称</th>
				<th width="20%" >父类</th>
				<th>常量数值</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${constants}">
			<tr target="slt_uid" rel="${item.id}">
				<td>${item.code}</td>
				<td>${item.name}</td>
				<td>${parentConstant.name}</td>
				<td>${item.value}</td>
				<td>${item.remark}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 分页 -->
	<keta:pagination page="${page }" rel="jbsxBox2constantList" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox2constantList')"/>
</div>


