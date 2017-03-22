<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<a id="refreshJbsxBox2organizationTree" rel="jbsxBox2organizationTree" target="ajax" href="${request.contextPath}/management/security/organization/tree" style="display:none;"></a>
<div class="pageContent">
<form method="post" action="${contextPath }/management/security/organization/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadRel2Org);">
	<input type="hidden" name="parent.id" value="${parentOrganizationId }"/>
	<div class="pageFormContent" layoutH="58">
		<dl>
			<dt>行政区划名称：</dt>
			<dd>
			     <input type="hidden" val="xzqhGroup.areaName" name="areaName" />
				<input type="text" class="required" val="xzqhGroup.areaName" name="xzqhGroup.areaName"  readonly="readonly" />
				<a class="btnLook" href="<%=basePath %>/management/security/organization/lookup/list" lookupGroup="xzqhGroup" title="行政区划列表" width="700">查找带回</a>	
			</dd>
		</dl>
		
		<dl>
			<dt>行政区划代码：</dt>
			<dd>
			     <input type="text" val="xzqhGroup.areaCode" name="areaCode"  readonly="readonly"/>
			</dd>
		</dl>
		
	<dl>
			<dt>代码：</dt>
			<dd>
				<input type="text" name="code" class="validate[required,maxSize[16]] required" size="32" maxlength="16" alt="请输入组织代码"/>
			</dd>
		</dl>
		<dl>
			<dt>名称：</dt>
			<dd>
				<input type="text" name="name" class="validate[required,maxSize[16]] required" size="32" maxlength="16" alt="请输入组织名称"/>
			</dd>
		</dl>	
		<dl>     
			<dt>机构类型：</dt>
			<dd> 
				 <select name="jglx" id="jglx">
						<option value="1" >医疗机构</option>
						<option value="2" >供应商</option>
						<option value="3" >银行</option>
						<option value="4" >区级管理机构</option>
						<option value="5" >市级管理机构</option>
				</select>
			</dd>
		</dl>	
		<dl>
			<dt>平台自编码：</dt>
			<dd>
				<input type="text" name="ptzbm" class="validate[maxSize[64]]" size="32" maxlength="64" alt="请输入平台自编码"/>
			</dd>
		</dl>		
		<dl>
			<dt>描述：</dt>
			<dd>
				<textarea name="description" cols="28" rows="3" maxlength="255"></textarea>
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