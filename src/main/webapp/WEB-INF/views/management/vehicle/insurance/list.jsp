<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<script type="text/javascript">
<!--
	function close2upload() {
		navTab.reload('${contextPath }/management/vehicle/vehicle/list', {});
		return true;
	}
//-->
</script>
<keta:paginationForm action="${contextPath }/management/vehicle/vehicle/list" page="${page }" onsubmit="return navTabSearch(this);">
	<input type="hidden" name="search_LIKE_license" value="${LIKE_license}"/>
</keta:paginationForm>

<form method="post" action="${contextPath }/management/vehicle/vehicle/list" onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>车牌号：</label>
					<input type="text" name="search_LIKE_license" value="${LIKE_license}"/>
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
				<li id='insuranceAdd'><a iconClass="page_white_add" target="dialog" max="true" mask="true" width="530" height="250" href="${contextPath }/management/vehicle/insurance/create/{slt_uid}"><span>录入保险信息</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:edit"> --%>
				<li id='insuranceEdit'><a iconClass="page_white_edit" target="dialog" mask="true" width="530" height="250" href="${contextPath }/management/vehicle/vehicle/update/{slt_uid}"><span>编辑</span></a></li>
			<%-- </shiro:hasPermission> --%>
			<%-- <shiro:hasPermission name="Vehicle:delete"> --%>
				<li>
					<a iconClass="magnifier" target="dialog" max=true mask="true" href="${contextPath}/management/vehicle/insurance/view/{slt_uid}"><span>查看</span></a>
				</li>
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
				<th>车牌号</th>
				<th>车辆型号</th>
				<th>车辆配置</th>
				<th>排量</th>
				<th>购买时间</th>
				<th>保险信息状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${vehicles}">
			<tr target="slt_uid" rel="${item.id}" onclick="displayButton('${item.insuranceStatus}')">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.license}</td>
				<td>${item.type}</td>
				<td>${item.configuration}</td>
				<td>${item.displacement}</td>
				<td>${item.buyingTime}</td>
				<td>
				<c:if test="${item.insuranceStatus==1}">已录入</c:if>
				<c:if test="${item.insuranceStatus==0}">未录入</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<keta:pagination page="${page }"/>
	
</div>
	<script type="text/javascript">
 function displayButton(status)
 {
	 if(status=='1')
	 {
	 	$("#insuranceAdd").hide();
	 	$("#insuranceEdit").show();
 		}
	 else if(status=='0')
 		{
 		 $("#insuranceAdd").show();
 		 	$("#insuranceEdit").hide();
 	 	}
	}