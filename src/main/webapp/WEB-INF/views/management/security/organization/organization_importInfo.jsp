<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
 

<form id="frm" name="frm"  method="post" action="${contextPath }/management/security/organization/importOrganization" enctype="multipart/form-data" onsubmit="return iframeCallback(this,dialogAjaxDoneRefreshNavTab)">

<input type="hidden" name="parentid" value="${parentOrganizationId }"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="57">
		<dl>
			<dt>附件：</dt><dd><input type="file" id = "importFile" name="importFile" accept="application/msexcel" size="30" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><a class="button" href="${contextPath}/management/security/organization/download/organization" target="dwzExport" title="需要下载导入模版吗?"><span>下载模版</span></a></li>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">上传</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>