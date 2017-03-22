<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"	trimDirectiveWhitespaces="true"%>
<%@ page import="com.wondersgroup.framework.service.StatusDefinition.RegStatus"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<script type="text/javascript">
	function formReset() {
		$(':input','#myform')
		 .not(':button, :submit, :reset, :hidden')
		 .val('')
		 .removeAttr('checked')
		 .removeAttr('selected');
	}
</script>
<keta:paginationForm
	action="${contextPath }/management/security/op_log/list" page="${page }">
	<input type="hidden" name="search_LIKE_ksdm" value="${LIKE_ksmc}" />
	<input type="hidden" name="search_LIKE_orgcode" value="${LIKE_orgcode}" />
	<input type="hidden" name="search_startDate" value="${startDate}" />
	<input type="hidden" name="search_endDate" value="${endDate}" />
</keta:paginationForm>

<form method="post" id="myform"	action="${contextPath }/management/security/op_log/list" onsubmit="return navTabSearch(this);">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label style="">科室名称：</label> 
					<input	type="text" name="search_LIKE_ksmc" value="${LIKE_ksmc}" />
				</li>
				<li>
					<label style="width: 85px">机构代码：</label> 
					<input	type="text" name="search_LIKE_orgcode" value="${LIKE_orgcode}" />
				</li>
				<li>
					<label style="width: 85px">刷卡机构名称：</label> 
					<input	type="text" name="search_LIKE_useOrgName" value="${LIKE_useOrgName}" />
				</li>
				
			</ul>
			<ul class="searchContent">		
				<li>
					<label style="">操作类型：</label> 
					<select name="search_EQ_operCode"> 
						<option value="" 
						<c:if test="${LIKE_operCode =='' }">
							 selected="selected"
						</c:if>>请选择</option>
						
						<option value="0" 
						<c:if test="${LIKE_operCode =='0'}">
							 selected="selected"
						</c:if>>读操作 </option>
						<option value="1" 
						<c:if test="${LIKE_operCode =='1'}">
							 selected="selected"
						</c:if>>写操作</option>
						 
						 
					</select> 
					 
				</li>	
				<li>
					<label style="width: 80px">时间（始）：</label> 
					<input id="startTime"  name="search_GTE_operTime" type="text" value="${startDate }"  readonly="readonly" class="Wdate" onclick="WdatePicker({el:'startTime',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}'})"/>
				</li>
				<li>
					<label style="width: 85px">时间（末）：</label> 
					<input id="endTime" name="search_LTE_operTime" type="text" value="${endDate }" class="Wdate" readonly="readonly" onclick="WdatePicker({el:'endTime',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:'%y-%M-%d'})"/>
			    </li>      
			</ul>
			<div class="subBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">搜索</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button onclick="formReset()">清空</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<table class="table" layoutH="161" width="100%">
		<thead>
			<tr align="center">
			<!-- 	<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>    -->
				<th>科室名称</th>
				<th>机具号</th>
				<th>操作类型</th>
				<th>发卡机构代码</th>
				<th>SAM卡号</th>
				<th>芯片序列号</th>
				<th>刷卡机构名称</th>
				<th>操作时间</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${cardOperatorLogList}">
				<tr target="slt_uid" rel="${item.id}" align="center" >
					<!-- 	<td><input name="ids" value="${item.id}" type="checkbox"></td> -->
					<td>${item.ksmc}</td>
					<td>${item.machineCode}</td>
					<td><c:if test="${item.operCode == 0}" >读操作 </c:if> <c:if test="${item.operCode ==1 }" >写操作 </c:if></td>
					<td>${item.orgcode}</td>
					<td>${item.samCode}</td>
					<td>${item.xpxlh}</td>
					<td>${item.useOrgName}</td>
					<td> ${fn:substring(item.operTime,0,19)}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 分页 -->
	<keta:pagination page="${page }" />

</div>

