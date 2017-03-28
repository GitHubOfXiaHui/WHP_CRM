<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="${contextPath }/management/vehicle/installation/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${installation.id}"/>
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>加装项：</label>
			<input type="text" name="addItem" value="${installation.addItem }" size="20"/>
		</p>
		<p>
			<label>加装时间：</label>
			<input type="text" name="installationTime" value="${installation.installationTime }" size="20"/>
		</p>
		<p>
			<label>价格明细：</label>
			<input type="text" name="price" value="${installation.price }" size="20"/>
		</p>
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>