<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<h2 class="contentTitle">添加系统变量</h2>
<form method="post" action="<%=basePath %>/management/sys/constant/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<input type="hidden" name="parent.id" value="${parentConstant.id }"/>
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>变量名称：</dt>
			<dd>
				<input type="text" name="name" class="required" size="32" maxlength="32" alt="请输入变量名称"/>
			</dd>
		</dl>
		<dl>
			<dt>变量代码：</dt>
			<dd>
				<input type="text" name="code" class="required" size="32" maxlength="32" alt="请输入变量代码"/>
			</dd>
		</dl>
		<dl>
			<dt>变量值：</dt>
			<dd>
				<input type="text" name="value" class="required" size="32" maxlength="32" alt="请输入变量对应的值"/>
			</dd>
		</dl>	
		<dl>
			<dt>备注：</dt>
			<dd>
				<textarea name="remark" cols="32" rows="3" maxlength="255"></textarea>
			</dd>
		</dl>	
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>