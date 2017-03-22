<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath }/management/security/config/create"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<div class="pageFormContent" layoutH="58">

			<!-- 		<p>
			<label>序号：</label>
			<input type="text" name="id" class="validate[required,maxSize[16]] required" size="20" maxlength="16"/>
		</p> -->

			<dl>
				<dt>配置名称：</dt>
				<dd>
					<input type="text" name="key"
						class="validate[required,maxSize[32]] required" size="32"
						maxlength="32" />
				<dd>
			</dl>

			<dl>
				<dt>有效状态：</dt>
				<dd>
					<select name="status">
						<option value="1">有效</option>
						<option value="0">无效</option>
					</select>
				</dd>
			</dl>
		
		<dl>
			<dt>配置值：</dt>
			<dd>
				<textarea name="value" class="validate[required] required" 
				cols="32" rows="3" maxlength="1024"></textarea>
			</dd>
		</dl>
        <dl></dl>
		<dl>
			<dt>任务描述：</dt>
			<dd>
				<textarea name="description" cols="32" rows="3" maxlength="255"></textarea>
			</dd>
		</dl>

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