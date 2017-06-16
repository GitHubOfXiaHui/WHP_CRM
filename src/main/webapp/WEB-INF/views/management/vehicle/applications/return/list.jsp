<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<keta:paginationForm action="${contextPath }/management/vehicle/applications/approval/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_parent.license" value="${LIKE_parent.license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/applications/return/list" onsubmit="return navTabSearch(this);">
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
						</c:if>>还车确认</option>
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
				<th>申请人姓名</th>
				<th>目的地</th>
				<th>驾驶员</th>
				<th>乘车人数（人）</th>
				<th>车辆用途</th>
				<th>起始时间</th>
				<th>截止时间</th>
				<th>申请人</th>
				<th>申请人所在派出所</th>
				<th>车牌号</th>
				<th width="5%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${applications}">
			<tr target="slt_uid" rel="${item.id}">
				<td>
				<c:choose>
					<c:when test="${item.approvalStatus == '11'}">等待所领导审批</c:when>
					<c:when test="${item.approvalStatus == '12'}">等待警务保障室审批</c:when>
					<c:when test="${item.approvalStatus == '13'}">等待局领导审批</c:when>
					<c:when test="${item.approvalStatus == '00'}">通过</c:when>
					<c:when test="${item.approvalStatus == '99'}">驳回</c:when>
					<c:when test="${item.approvalStatus == '88'}">还车确认</c:when>
				</c:choose>
				</td>
				<td>${item.departure}</td>
				<td>${item.destination}</td>
				<td>${item.driver}</td>
				<td>${item.passengerNum}</td>
				<td>${item.applicationIntent}</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd"/></td>
				<td>${item.applicationUser.realname}</td>
				<td>${item.applicationUser.organization.name}</td>
				<td>${item.parent.license}</td>
				
				<td>
				<c:if test="${item.approvalStatus == '00'}">
							<!-- rel="requestNoteManageOper"定义弹出框id为“requestNoteManageOper” 						// -->
							<a target="dialog"  max="true"  mask="true"	href="${contextPath }/management/vehicle/applications/return/manageOper/${item.id}"  rel="requestNoteManageOper"  title="还车"><img src='${contextPath }/styles/dwz/themes/css/images/toolbar_icons16/cog.png'></a>
							
						</c:if>
						<c:if test="${item.approvalStatus == '88'}">
						<a iconClass="magnifier" target="dialog" max="true" mask="true" href="${contextPath }/management/vehicle/applications/return/view/${item.id}" rel="requestNoteManageView"  title="查看"></a>
						</c:if>
						</td> 
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
</div>
