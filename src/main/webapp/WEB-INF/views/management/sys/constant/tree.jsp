<%@page import="com.whp.framework.entity.sys.Constant"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%!
	public String tree(Constant constant, String basePath) {
		StringBuilder builder = new StringBuilder();
		
		Long pid = constant.getParent() == null ? 0:constant.getParent().getId();
		builder.append("{id:" + constant.getId() +  ", pId:" + pid + 
				", name:\"" + constant.getName() + "\", url:\"" + basePath + "/management/sys/constant/list/" + constant.getId() + "\", target:\"ajax\"},");
		
		for(Constant o : constant.getChildren()) {
			builder.append(tree(o, basePath));				
		}
		return builder.toString();
	}
%>
<%
	Constant constant2 = (Constant)request.getAttribute("constant");
	String constantTree = tree(constant2, request.getContextPath());
	constantTree = constantTree.substring(0, constantTree.length() - 1);
%>   
<script type="text/javascript">
<!--
var setting = {
	view: {
		//showIcon: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		onClick: function(event, treeId, treeNode) {
			var $rel = $("#jbsxBox2constantList");
			$rel.loadUrl(treeNode.url, {}, function(){
				$rel.find("[layoutH]").layoutH();
			});

			event.preventDefault();
		}
	}	
};

var zNodes =[<%=constantTree%>];
     	
$(document).ready(function(){
	var t = $("#constantTree");
	t = $.fn.zTree.init(t, setting, zNodes);
	t.expandAll(true); 
});
//-->
</script>
<style>
<!--
#orgTree li span {
	text-align:left;
	float: left;
	display: inline;
} 
-->
</style>
<ul id="constantTree" class="ztree" style="display: block;"></ul>
