<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath }/management/security/orgCode/create"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<div class="pageFormContent" layoutH="58">

			<dl>
				<dt>机构代码：</dt>
				<dd>
					<input type="text" name="origorgcode"
						class="validate[required,maxSize[32]] required" size="32"
						maxlength="32" />
				<dd>
			</dl>

			<dl>
				<dt>机构名称：</dt>
				<dd>
					<input type="text" name="orgname"
						class="validate[required,maxSize[16]] required" size="32"
						maxlength="16" />
				</dd>
			</dl>
			 
			<dl>
				<dt>所属行政区划代码：</dt>
				<dd>
					<input type="text" name="yycsdm"
						class="validate[required,maxSize[10],minSize[6]] required" size="32"
						maxlength="10" />
				</dd>
			</dl>

			<dl>
				<dt>汉口银行业务编号：</dt>
				<dd>
					<input type="text" name="bankYwbh"
						class="validate[maxSize[16]] " size="32"
						maxlength="10" />
				</dd>
			</dl>
			<dl>
				<dt>通联商户代码 ：</dt>
				<dd>
					<input type="text" name="tlsfdm"
						class="validate[maxSize[16]] " size="32"
						maxlength="10" />
				</dd>
			</dl>
			<dl>
				<dt>TPDU ：</dt>
				<dd>
					<input type="text" name="tlTpdu"
						class="validate[maxSize[16]] " size="32"
						maxlength="10" />
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