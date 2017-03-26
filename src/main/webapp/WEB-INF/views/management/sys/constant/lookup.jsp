<%@ page import="com.whp.framework.entity.sys.Constant"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<%! public String tree(Constant parent) {
		if (parent.getChildren().isEmpty()) {
			return "";   
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("<ul>" + "\n");
		for (Constant o : parent.getChildren()) {
		    buffer.append("<li>");
		    if(o.getCode().length() == 4){
		        buffer.append("<a href=\"javascript:\" onClick=\"$.bringBack({code:\'"+o.getCode()+"\',name:\'"+o.getName()+"\'})\" title=\"查找带回\">"+o.getName()+"</a>" + "\n");
		    }else{
		        buffer.append("<a href=\"javascript:\">"+o.getName()+"</a>" + "\n");
		    }
			buffer.append(tree(o));
			buffer.append("</li>" + "\n");
		}
		buffer.append("</ul>" + "\n");

		return buffer.toString();
	}%>
<%
	Constant parent = (Constant) request.getAttribute("root");
%>
<div class="pageContent" layoutH="30" style="overflow:auto;width:100%;height:100%;">
	<ul class="tree collapse">
		<li><a href="javascript:">${root.name }</a> 
			<%=tree(parent)%>
		</li>
	</ul>
</div>