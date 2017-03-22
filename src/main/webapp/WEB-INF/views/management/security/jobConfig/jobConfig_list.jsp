<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm
	action="${contextPath }/management/job/jobConfig/list"
	page="${page }">
	<input type="hidden" name="search_LIKE_jobName" value="${LIKE_jobName}" />
	<input type="hidden" name="search_EQ_jobStatus" value="${EQ_jobStatus}" />
</keta:paginationForm>


<form method="post"
	action="<%=basePath%>/management/job/jobConfig/list"
	onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li><label style="width: 100px">任务名称：</label> <input
					type="text" name="search_LIKE_jobName" value="${LIKE_jobName}" /></li>
				<li><label style="width: 100px">任务状态：</label> <select
					name="search_EQ_jobStatus">
						<option value=""
							<c:if test="${EQ_jobStatus =='' }">
							 selected="selected"
						</c:if>>请选择</option>
						<option value="0"
							<c:if test="${EQ_jobStatus =='0'}">
							 selected="selected"
						</c:if>>禁用</option>
						<option value="1"
							<c:if test="${EQ_jobStatus =='1'}">
							 selected="selected"
						</c:if>>启用</option>
				</select></li>
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">搜索</button>
							</div>
						</div></li>
					<li><div class="button">
							<div class="buttonContent">
								<button type="reset">清空重输</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="jobConfig:view">
			<li><a class="edit" target="dialog" width="550" height="350" mask="true" href="<%=basePath %>/management/job/jobConfig/update/{slt_uid}" ><span>修改</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="jobConfig:view">
			<li><a class="add" target="ajaxTodo" href="<%=basePath %>/management/job/jobConfig/excute/{slt_uid}" ><span>立即执行</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="jobConfig:view">
			<li><a target="ajaxTodo" iconClass="arrow_refresh" href="<%=basePath %>/management/job/jobConfig/test/{slt_uid}" ><span>测试</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<table class="table" layoutH="138" width="100%" rel="jbsxBox2">
		<thead>
			<tr>
				<th>任务名称</th>
				<th>任务分组</th>
				<th>任务状态</th>
				<th>任务运行时间表达式</th>
				<th>任务描述</th>
				<th>最后运行时间</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${entityList}">
				<tr target="slt_uid" rel="${item.id}">
					<td>${item.jobName}</td>
					<td>${item.jobGroup}</td>
					<td><c:if test="${item.jobStatus==0}">
						禁用
					</c:if> <c:if test="${item.jobStatus==1}">
						启用
					</c:if></td>
					<td>${item.cronExpression}</td>
					<td>${item.description }</td>
					<td><fmt:formatDate type="both" value="${item.endRunTime}" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 分页 -->
	<keta:pagination page="${page}" />

</div>
