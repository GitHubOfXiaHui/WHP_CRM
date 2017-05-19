<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<ul class="tree expand">
			<li><a href="javascript:">系统用户</a>
				<ul>
					<c:forEach items="${userList}" var="item">
						<li>
							<a href="javascript:" href="javascript:" onclick="$.bringBack({ mc:'${item.realname }'})">${item.realname }</a>
						</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
