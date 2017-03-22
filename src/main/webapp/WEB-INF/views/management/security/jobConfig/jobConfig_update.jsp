<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="${contextPath }/management/job/jobConfig/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${entity.id }"/>
	<input type="hidden" name="triggerName" value="${entity.triggerName }"/>
	<div class="pageFormContent" layoutH="58">
	<dl>
			<dt>任务名称：</dt>
			<dd>
				<input type="text" class="required" name="jobName" value="${entity.jobName}"   />
			</dd>
		</dl>
		<dl>
			<dt>任务分组：</dt>
			<dd>
			     <input type="text" name="jobGroup" value="${entity.jobGroup}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>     
			<dt>任务状态：</dt>
			<dd> 
				 <select name="jobStatus" id="jobStatus">
						<option value="1" <c:if test="${entity.jobStatus=='1' }">selected="selected"</c:if>>启用</option>
						<option value="0" <c:if test="${entity.jobStatus=='0' }">selected="selected"</c:if>>禁用</option>
				</select>
			</dd>
		</dl>	
		<dl>
			<dt>任务运行时间表达式：</dt>
			<dd>
				<input type="text" name="cronExpression" class="validate[maxSize[64]]" size="32" value="${entity.cronExpression }" maxlength="64"/>
			</dd>
		</dl>		
		<dl>
			<dt>任务描述：</dt>
			<dd>
				<textarea name="description" cols="28" rows="3" maxlength="255">${entity.description }</textarea>
			</dd>
		</dl>	
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>