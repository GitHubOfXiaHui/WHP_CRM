<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<form method="post"
		action="${contextPath}/management/security/orgCode/edit"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
<input type="hidden" name="id" value="${orgCodes.id}" />
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<fieldset>
		<legend>机构信息</legend>
			<p>
				<label>机构代码：</label> <input type="text" name="origorgcode" size="32"
					value="${orgCodes.origorgcode }" />
			</p>
			<p>
				<label>机构名称：</label> <input type="text" name="orgname" size="32"
					value="${orgCodes.orgname }" />
			</p>
			<p>
				<label>所属行政区划代码：</label> <input type="text" name="yycsdm" size="32"
					value="${orgCodes.yycsdm }" />
			</p>
			<p>
				<label>银行业务编号：</label> <input type="text" name="bankYwbh" size="32"
					value="${orgCodes.bankYwbh }" />
			</p>
			<p>
				<label>通联商户代码：</label> <input type="text" name="tlsfdm" size="32"
					value="${orgCodes.tlsfdm }" />
			</p>
			<p>
				<label>TPDU：</label> <input type="text" name="tlTpdu" size="32"
					value="${orgCodes.tlTpdu }" />
			</p>
			
			</fieldset>
	</div>

	<div class="formBar">
		  <ul>
			<li>
			    <div class="button">
				   <div class="buttonContent"><button type="submit">确定</button></div>
				</div>
			</li>
			
			<li>
			    <div class="button">
					<div class="buttonContent"><button type="button" class="close">关闭</button></div>
				</div>
			</li>
		</ul>
	</div>
	
</div>
</form>