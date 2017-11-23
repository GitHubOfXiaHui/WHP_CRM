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
		    style+='<style type="text/css">div {overflow: hidden!important;}table {width:100%;border-collapse:collapse;border: 1px solid #A1D4FF;white-space: nowrap;}th {border-right: 1px solid #A1D4FF;text-align: center;white-space: nowrap;border-bottom: 1px solid #A1D4FF;}td {border-right: 1px solid #A1D4FF;border-bottom: 1px solid #A1D4FF;text-align: center;white-space: nowrap;}</style></head>';
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
				<h1>派 车 单</h1>
				<p><fmt:formatDate value="${application.createDate }" pattern="yyyy年M月d日"/></p>
			</caption>
			<tr>
				<th>用车单位</th>
				<td>${application.applicationUser.organization.name }</td>
				<th>车牌号</th>
				<td>${application.parent.license }</td>
			</tr>
			<tr>
				<th>事由</th>
				<td colspan="3">${application.applicationIntent }</td>
			</tr>
			<tr>
				<th>出车时间</th>
				<td><fmt:formatDate value="${application.startTime }" pattern="yyyy-MM-dd HH:mm"/></td>
				<th>返回时间</th>
				<td><fmt:formatDate value="${application.returnDate }" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
			<tr>
				<th>车行驶数始码</th>
				<td>${application.startFGReading }</td>
				<th>车行驶数止码</th>
				<td>${application.endFGReading }</td>
			</tr>
			<tr>
				<th>经办人</th>
				<td>${application.departure }</td>
				<th>领导签字</th>
				<td>
				<c:if test="${application.requireApproval}">${application.audit1Username };${application.audit3Username }</c:if>
				<c:if test="${!application.requireApproval}">${application.audit1Username }</c:if>
				</td>
			</tr>
			<tr style="height: 100px;">
				<th>备注</th>
				<td colspan="3" valign="top">${application.returnRemark }</td>
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