<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath}/management/security/config/update"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<input type="hidden" name="id" value="${config.id}" />
		<div class="pageFormContent" layoutH="58">
			<p>
				<label>配置名称：</label> <input type="text" name="key"
					class="validate[required,maxSize[32]] required" size="32"
					maxlength="32" value="${config.key }" />
			</p>

			<p>
				<label>有效状态：</label> <select name="status">
					<option value="1"
						${config.status == "1" ? 'selected="selected"' : ''}>有效</option>
					<option value="0"
						${config.status == "0" ? 'selected="selected"' : ''}>无效</option>
				</select>
			</p>
			<p>
				<label>配置值：</label>
				<textarea name="value"
					class="validate[required,maxSize[1024]] required" cols="32" rows="3" maxlength="1024"
					 >${config.value }</textarea>
			</p>
			<p></p>
			<p>
				<label>描述：</label>
				<textarea name="description" cols="32" rows="3" maxlength="64">${config.description }</textarea>
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">确定</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">关闭</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>