<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>    
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>车管平台</title>

<link href="${contextPath}/styles/dwz/themes/newcard/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${contextPath}/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${contextPath}/styles/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${contextPath}/styles/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="${contextPath}/styles/dwz/js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="${contextPath}/styles/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${contextPath}/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${contextPath}/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="${contextPath}/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${contextPath}/styles/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="${contextPath}/styles/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>
<script src="${contextPath}/styles/dwz/js/treeview.js" type="text/javascript"></script>
<script src="${contextPath}/styles/dwz/js/leftMenu.js" type="text/javascript"></script>
<%-- form验证 --%>
<script src="${contextPath}/styles/validationEngine/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${contextPath}/styles/validationEngine/js/jquery.validationEngine-2.6.4.js" type="text/javascript" charset="utf-8"></script>

<script src="${contextPath}/styles/dwz/js/dwz.min.js" type="text/javascript"></script>

<script src="${contextPath}/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<%-- 自定义JS --%>
<script src="${contextPath}/styles/dwz/js/customer.js" type="text/javascript"></script>
<%-- 自定义时间框架 --%>
<script src="${contextPath}/styles/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<!-- 
<script src="${contextPath}/styles/My97DatePicker/config.js" type="text/javascript"></script>
<script src="${contextPath}/styles/My97DatePicker/calendar.js" type="text/javascript"></script>
 -->
<%-- upload --%>
<script src="${contextPath}/styles/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>
<%-- zTree --%>
<script src="${contextPath}/styles/ztree/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("${contextPath}/styles/dwz/dwz.frag.xml", {
		loginUrl:"${contextPath}/management/login/timeout", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"${contextPath}/styles/dwz/themes"});
		}
	});
});

</script>
<script type="text/javascript">
	$(function(){
	  var len=$(window).height();
	  $("#left").css({"height": + len - 0});
	  $(".left_menu ul li ol li a").click(function(){
			$(".left_menu ul li ol li a").removeClass("current");
			$(this).addClass("current");
		});
	});  
</script> 
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav ico">
				<a class="logo" href="${contextPath}/management/index">标志</a>
           <span class="tima">      
		    <div>
		    <span><a href="${contextPath}/management/index/updateBase" target="dialog" mask="true" width="550" height="250" class="topLink01">修改用户信息</a>
               <a href="${contextPath}/management/index/updatePwd" target="dialog" mask="true" width="500" height="200" class="topLink02">修改密码</a>
               <a href="${contextPath}/management/logout" class="topLink04">退出</a></span></div></span>
                <ul class="themeList-1" >  
					<li>admin 您好，欢迎进入！</li>
				</ul>
      </div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
			<div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>
			<div class="accordion" fillSpace="sideBar">
				<div class="accordionHeader">
					<h2><span>Folder</span>车辆信息管理</h2>
				</div>
				<div class="accordionContent">
					<ul class="tree treeFolder">
						<li><a href="${contextPath}/management/vehicle/vehicle/list" target="navTab">车辆基本信息管理</a></li>
						<li><a href="" target="navTab">车辆保险信息管理</a></li>
						<li><a href="${contextPath}/management/vehicle/inspection/list" target="navTab">车辆年审信息管理</a></li>
						<li><a href="${contextPath}/management/vehicle/installation/list" target="navTab">车辆加装信息管理</a></li>
						<li><a href="${contextPath}/management/vehicle/query/list" target="navTab">车辆信息查询</a></li>
					</ul>
				</div>
				<div class="accordionHeader">
					<h2><span>Folder</span>车辆使用管理</h2>
				</div>
				<div class="accordionContent">
					<ul class="tree treeFolder">
						<li><a href="" target="navTab" rel="">车辆使用申请</a></li>
						<li><a href="" target="navTab" rel="">车辆使用审批</a></li>
						<li><a href="" target="navTab" rel="">申请单打印</a></li>
						<li><a href="" target="navTab" rel="">用车审批归档</a></li>
						<li><a href="" target="navTab" rel="">车辆归还</a></li>
						<li><a href="" target="navTab" rel="">违章信息录入</a></li>
						<li><a href="" target="navTab" rel="">加油信息录入</a></li>
						<li><a href="" target="navTab" rel="">事故信息录入</a></li>
						<li><a href="" target="navTab" rel="">油卡信息录入</a></li>
						<li><a href="" target="navTab" rel="">油卡信息查询</a></li>
						<li><a href="" target="navTab" rel="">车辆使用记录查询</a></li>
					</ul>
				</div>
				<div class="accordionHeader">
					<h2><span>Folder</span>车辆维修管理</h2>
				</div>
				<div class="accordionContent">
					<ul class="tree treeFolder">
						<li><a href="" target="navTab" rel="">维修点管理</a></li>
						<li><a href="" target="navTab" rel="">维修项管理</a></li>
						<li><a href="" target="navTab" rel="">车辆维修申请</a></li>
						<li><a href="" target="navTab" rel="">车辆维修审批</a></li>
						<li><a href="" target="navTab" rel="">申请单打印</a></li>
						<li><a href="" target="navTab" rel="">维修审批归档</a></li>
						<li><a href="" target="navTab" rel="">维修确认</a></li>
						<li><a href="" target="navTab" rel="">维修记录查询</a></li>
					</ul>
				</div>
				<div class="accordionHeader">
					<h2><span>Folder</span>统计分析</h2>
				</div>
				<div class="accordionContent">
					<ul class="tree treeFolder">
						<li><a href="" target="navTab" rel="">车辆统计</a></li>
						<li><a href="" target="navTab" rel="">用车统计</a></li>
						<li><a href="" target="navTab" rel="">维修统计</a></li>
						<li><a href="" target="navTab" rel="">报告分析</a></li>
					</ul>
				</div>
				<div class="accordionHeader">
					<h2><span>Folder</span>安全管理</h2>
				</div>
				<div class="accordionContent">
					<ul class="tree treeFolder">
						<li><a href="" target="navTab" rel="">用户管理</a></li>
						<li><a href="" target="navTab" rel="">组织管理</a></li>
						<li><a href="" target="navTab" rel="">模块管理</a></li>
						<li><a href="" target="navTab" rel="">角色管理</a></li>
						<li><a href="" target="navTab" rel="">系统配置</a></li>
					</ul>
				</div>			
			</div>
		</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
			<div class="tabsPageHeader">
				<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
					<ul class="navTab-tab">
						<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">主页</span></span></a></li>
					</ul>
				</div>
				<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
				<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
				<div class="tabsMore">more</div>
			</div>
			<ul class="tabsMoreList">
				<li><a href="javascript:void(0)">主页</a></li>
			</ul>
			<div class="navTab-panel tabsPageContent layoutBox">
				<div class="page unitBox">
					<div class="accountInfo">
						<div class="right">
							<p><fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd EEEE"/></p>
						</div>
						<p><span>欢迎, ${login_user.realname } .</span></p>
					</div>
					<div class="pageFormContent" layouth="80">
					<fieldset>
						<legend>基本信息</legend>
						<dl>
							<dt>登录名称：</dt>
							<dd><span class="unit">${login_user.username }</span></dd>
						</dl>
						<dl>
							<dt>真实名字：</dt>
							<dd><span class="unit">${login_user.realname }</span></dd>
						</dl>
						<dl>
							<dt>电话：</dt>
							<dd><span class="unit">${login_user.phone }</span></dd>
						</dl>
						<dl>
							<dt>E-Mail：</dt>
							<dd><span class="unit">${login_user.email }</span></dd>
						</dl>
						<dl>
							<dt>创建时间：</dt>
							<dd><span class="unit"><fmt:formatDate value="${login_user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></dd>
						</dl>
						<dl>
							<dt>可用状态：</dt>
							<dd><span class="unit">${(login_user.status == "enabled")? "可用":"不可用"}</span></dd>
						</dl>
						<dl>
							<dt>所属机构：</dt>
							<dd><span class="unit">${login_user.organization.name }</span></dd>
						</dl>
					</fieldset>
					</div>
				</div>
			</div>
		</div>
		</div>

	</div>

	<div id="footer">版权所有： <%
 out.print(com.whp.framework.SecurityConstants.configMap.get("copyright"));
 %></div>

<!-- 注意此处js代码用于google站点统计，非DWZ代码，请删除 -->
<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-16716654-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? ' https://ssl' : ' http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

</body>
</html>
