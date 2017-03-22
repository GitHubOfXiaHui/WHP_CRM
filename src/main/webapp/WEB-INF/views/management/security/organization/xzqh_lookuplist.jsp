<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
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
<form id="pagerForm" action="${contextPath }/management/security/organization/lookup/list" onsubmit="return dwzSearch(this,'dialog');">
	<input type="hidden" name="pageNum" value="${page.pageNum}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="totalPage" value="${page.totalPage}" />
	<input type="hidden" name="orderField" value="${page.orderField}" />
	<input type="hidden" name="orderDirection" value="${page.orderDirection}" />
	<input type="hidden" name="search_LIKE_name" value="${LIKE_name}" />
	<input type="hidden" name="search_LIKE_code" value="${LIKE_code}" />
</form>
<form method="post" id="myform" action="${contextPath }/management/security/organization/lookup/list" onsubmit="return dwzSearch(this,'dialog');">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li><label style="width: 100px">行政区划代码：</label> 
				<input	type="text" name="search_LIKE_code" value="${LIKE_code}" /></li>
				<li><label style="width: 100px">行政区划名称：</label> 
				<input	type="text" name="search_LIKE_name" value="${LIKE_name}" /></li>
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
	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr align="center">
				<th orderfield="code">行政区划代码</th>
				<th orderfield="name">行政区划名称</th>
				<th width="80">选择</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="item" items="${xzqhList}">
			<tr target="slt_uid" rel="${item.id}" align="center">
				<td>${item.code}</td>
				<td>${item.name}</td>
			   <td>
					<a class="btnSelect"  href="javascript:$.bringBack({areaCode:'${item.code}', areaName:'${item.name }'})" title="行政区划信息">选择</a>
				</td>
			</tr>
			</c:forEach>
			
		</tbody>
				
	

	</table>

		<!-- 分页  -->
	<div class="panelBar">
		<div class="pages">
			<span>每页显示</span>
			<select name="numPerPage" onchange="dialogPageBreak({numPerPage:this.value})">
				<c:forEach begin="15" end="50" step="10" varStatus="s">
					<option value="${s.index}" ${page.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
				</c:forEach>
			</select>
			<span>总条数: ${page.totalCount}</span>
		</div>
	
		<div class="pagination" targetType="dialog" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="10" currentPage="${page.pageNum}"></div>
	</div>
</div>