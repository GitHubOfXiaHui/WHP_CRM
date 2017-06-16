<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.lang.reflect.*"%>
<%@ page language="java" import="org.apache.commons.lang3.StringUtils"%>

<script type="text/javascript">
	$(document).ready(function(){
		function openPrintWindow(){
			var printContent = $("#myPrintArea").html();
		    var ow = window.open("", "newwin", "height=1, width=1");
		    var style ='<html><c:set var="contextPath" value="${pageContext.request.contextPath}"/><head><style media=print> .Noprint{display:none;} .PageNext{page-break-after: always;} </style>';
		    style+='<style type="text/css">div {overflow: hidden!important;}table {border-collapse:collapse;border: 1px solid #A1D4FF;white-space: nowrap;}th {border-right: 1px solid #A1D4FF;text-align: center;white-space: nowrap;border-bottom: 1px solid #A1D4FF;}td {border-right: 1px solid #A1D4FF;border-bottom: 1px solid #A1D4FF;text-align: center;white-space: nowrap;}</style></head>';
		    ow.document.open();
		    ow.document.write(style + "<body>");
		    //ow.document.write(style + "</head><body>");
		    ow.document.write('<OBJECT  id=WebBrowser style="display:none"  classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2  height=0  width=0> </OBJECT>');
		    ow.document.write(printContent);
		    ow.document.write('<button class="Noprint" type="button" id="printPreview" onclick=document.all.WebBrowser.ExecWB(7,1)>打印预览</button>');
		    ow.document.write('<button class="Noprint" type="button" id="print" onclick=document.all.WebBrowser.ExecWB(6,1)>打印</button>');
		    return ow;
		}
		
		$("#printPreview").click(function(){			
		    //var js1 ='<script src="${contextPath}/styles/jquery/jquery-1.7.2.min.js" type="text/javascript"></scr';
		    //var js2='ipt><script type="text/javascript">$(document).ready(function(){$("#printPreview").click();});</scr';
		    var js2='<script type="text/javascript">window.onload(document.getElementById("printPreview").click());</scr';
		    var js3='ipt>';
		    //ow.document.write(style + "</head><body>");
		    var ow=openPrintWindow();
		    ow.document.write(js2+js3);
	        ow.document.write("</body></html>");
		});
		
		$("#print").click(function(){			
		    //var js1 ='<script src="${contextPath}/styles/jquery/jquery-1.7.2.min.js" type="text/javascript"></scr';
		    //var js2='ipt><script type="text/javascript">$(document).ready(function(){$("#printPreview").click();});</scr';
		    var js2='<script type="text/javascript">window.onload(document.getElementById("print").click());</scr';
		    var js3='ipt>';
		    //ow.document.write(style + "</head><body>");
		    var ow=openPrintWindow();
		    ow.document.write(js2+js3);
	        ow.document.write("</body></html>");
		}); 
	});
</script>

<style type="text/css">
#myPrintArea {
	margin: 0 auto;
	width: 95%;
	height: 330px;
}

table {
	width: 100%;
	border-collapse:collapse;
	border:1px solid black;
}

caption h1 {
	font-size: 20px;
	margin-top: 10px;
}

p {
	float: right;
	margin-top: 5px;
	margin-bottom: 5px;
	font-size: 12px;
}

tr {
	height: 30px;
}

th {
	font-weight: bold;
	font-size: 15px;
	text-align: center;
	border:1px solid black;
}

td {
	padding: 5px;
	font-size: 14px;
	border:1px solid black;
}
</style>

<div class="pageContent">
	<div id="myPrintArea">
		<table>
			<caption>
				<h1>东新分局车辆检修审批单</h1>
			</caption>
			<tr><th>送检时间</th><td><fmt:formatDate value="${repair.startTime }" pattern="yyyy年M月d日"/></td><th>预计接车时间</th><td><fmt:formatDate value="${repair.endTime }" pattern="yyyy年M月d日"/></td><th>实际接车时间</th><td><fmt:formatDate value="${repair.actualEndTime }" pattern="yyyy年M月d日"/></td></tr>
			<tr>
				<th>车号</th>
				<td>${repair.parent.license }</td>
				<th>单位</th>
				<td>${repair.applicationUser.organization.name }</td>
				<th>经办人</th>
				<td>${repair.applicationUser.realname }</td>
			</tr>
			<tr>
				<th>检修原因</th>
				<td colspan="5">${repair.repairDescript }</td>
			</tr>
			<tr>
				<th>申请检修费用</th>
				<td colspan="2">大写：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;仟&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 佰&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;拾&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>小写：${repair.price }元</td>
				<th>实际检修费用</th>
				<td colspan="2">大写：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;仟&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 佰&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;拾&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>小写：${repair.actualPrice }元</td>
			</tr>
			<tr>
				<th style="height: 40px;">单位领导审批</th>
				<td colspan="5">${repair.audit1User }</td>
			</tr>
			<tr>
				<th style="height: 40px;">主管部门意见</th>
				<td colspan="5">
				<c:if test="${repair.requireApproval1}">${repair.audit2User }</c:if>
				<c:if test="${!repair.requireApproval1}">无需主管部门审批</c:if>
				</td>
			</tr>
			<tr>
				<th style="height: 40px;">分局领导审批</th>
				<td colspan="5">
				<c:if test="${repair.requireApproval}">${repair.audit3User }</c:if>
				<c:if test="${!repair.requireApproval}">无需局领导审批</c:if></td>
			</tr>
			<tr style="height: 60px;">
				<th>备注</th>
				<td colspan="5" valign="top">${repair.affirmRemark }</td>
			</tr>
		</table>
		<p>武汉市公安局东湖新技术开发区分局 制</p>
	</div>
</div>

<div class="formBar Noprint">
	<ul>
		<li><div class="buttonActive"><div class="buttonContent"><button type="button" id="print">打印</button></div></div></li>
		<li><div class="button"><div class="buttonContent"><button type="button" id="printPreview">打印预览</button></div></div></li>
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
	</ul>
</div>