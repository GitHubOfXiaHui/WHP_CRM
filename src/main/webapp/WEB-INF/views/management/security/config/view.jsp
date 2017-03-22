<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<fieldset style='height:90%'>
		<legend >配置信息</legend>
			<p>
				<label>配置名称：</label> <input type="text" name="key" size="32"
					value="${config.key }" readOnly=readOnly />
			</p>
			<p>
				<label>最后更新时间：</label> <input type="text" name="updatetime"
					size="32" value="${modTime }" readOnly=readOnly/>
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
				<textarea name="value" cols="32" rows="3" readOnly=readOnly>${config.value }</textarea>
			</p>
			<p></p>
			<p>
				<label>描述：</label>
				<textarea name="description" cols="32" rows="3" readOnly=readOnly>${config.description }</textarea>
			</p>
			</fieldset>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button">
					<div class="buttonContent">
						<button type="button" class="close">关闭</button>
					</div>
				</div></li>
		</ul>
	</div>
</div>