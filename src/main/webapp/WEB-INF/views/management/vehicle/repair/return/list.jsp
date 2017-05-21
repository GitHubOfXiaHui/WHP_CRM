<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/repair/affirm/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/repair/affirm/list" onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>车牌号：</label>
					<input type="text" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
				</li>
				<li>
					<label>申请状态：</label>
					<select name="search_EQ_approvalStatus">
						<option value="00" 
						<c:if test="${EQ_approvalStatus =='00'}">
							 selected="selected"
						</c:if>>通过</option>
						<option value="88" 
						<c:if test="${EQ_approvalStatus =='88'}">
							 selected="selected"
						</c:if>>检修确认</option>
						</select>
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
				<th width="5%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${repairs}">
			<tr target="slt_uid" rel="${item.id}" onclick="displayButton('${item.approvalStatus }')">
				<td>${item.parent.license}</td>
				<td>
				<c:choose>
					<c:when test="${item.approvalStatus == '11'}">等待所领导审批</c:when>
					<c:when test="${item.approvalStatus == '12'}">等待后勤管理处审批</c:when>
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
				<c:if test="${item.requireApproval}"><td>是</td></c:if>
				<c:if test="${!item.requireApproval}"><td>否</td></c:if>
				<td>${item.applicationUser.realname}</td>
				<td>${item.applicationUser.organization.name}</td>
				<td>
				<c:if test="${item.approvalStatus == '00'}">
				<a target="dialog"  max="true"  mask="true"	href="${contextPath }/management/vehicle/repair/affirm/manageOper/${item.id}"  rel="requestNoteManageOper"  title="还车"><img src='${contextPath }/styles/dwz/themes/css/images/toolbar_icons16/cog.png'></a>
				</c:if>
				<c:if test="${item.approvalStatus == '88'}">
				<a iconClass="magnifier" target="dialog" max="true" mask="true" href="${contextPath }/management/vehicle/repair/affirm/view/${item.id}" rel="requestNoteManageView"  title="查看"></a>
				</c:if>
				</td> 
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>
