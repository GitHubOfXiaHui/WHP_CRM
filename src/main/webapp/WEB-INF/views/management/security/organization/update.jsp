<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<script type="text/javascript"  >
// 检查组织机构代码是否存在 
function checkUnique() {
	var oldOrgCode = $("input[name='oldCode']").val();
	var orgCode = $("input[name='code']").val();
	// 如果无改动，则不必去校验，副本数据原因
	if ((oldOrgCode == orgCode)) {
		return true;
	}	
	
	var obj = $("#code");
    //var params = $('#frm').serializeObject();
    var result = false;
	jQuery.ajax({
	    url:"<%=basePath%>/management/security/organization/checkUnique",
	    type:"POST",
	    cache:false,
	    async:false,
	    dataType: "json",
	    data: {code:orgCode},
	    success:function(json, textStatus) {
	        if (json.statusCode != "200") {
	            alert(json.message);
	            obj.select();
	        } else {
//	            obj.removeClass("error");
	            result = true;
	        }
	    },
	    error:function(XMLHttpRequest, textStatus, errorThrown) {
	        alert("检查组织机构代码，是否存在时出现异常！");
	        obj.select();
	    }
	});
    
    return result;
}

 


</script>
<a id="refreshJbsxBox2organizationTree" rel="jbsxBox2organizationTree" target="ajax" href="${request.contextPath}/management/security/organization/tree" style="display:none;"></a>
<div class="pageContent">
<form method="post" action="${contextPath }/management/security/organization/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadRel2Org);">
	<input type="hidden" name="id" value="${organization.id }"/>
	<input type="hidden" name="parent.id" value="${organization.parent.id }"/>
	<div class="pageFormContent" layoutH="58">
	<dl>
			<dt>行政区划名称：</dt>
			<dd>
			    <input type="hidden" val="xzqhGroup.areaName" name="areaName" value="${organization.areaName}"  />
				<input type="text" class="required" val="xzqhGroup.areaName" name="xzqhGroup.areaName" value="${organization.areaName}"  readonly="readonly" />
				<a class="btnLook" href="<%=basePath %>/management/security/organization/lookup/list" lookupGroup="xzqhGroup" title="行政区划列表" width="700">查找带回</a>	
			</dd>
		</dl>
		
		<dl>
			<dt>行政区划代码：</dt>
			<dd>
			     <input type="text" val="xzqhGroup.areaCode" name="areaCode" value="${organization.areaCode}" onblur="checkUnique()"/>
			</dd>
		</dl>
		
		<dl>
			<dt>名称：</dt>
			<dd>
				<input type="text" name="name" class="validate[required,maxSize[64]] required" size="32" maxlength="64" value="${organization.name }" alt="请输入组织名称"/>
			</dd>
		</dl>
				<dl>
			<dt>代码：</dt>
			<dd> 
			  <input type="hidden"  value="${organization.code }" name="oldCode" />
				<input type="text" onblur="checkUnique()" id="code" name="code" class="validate[required,maxSize[64]] required" size="32" maxlength="64" value="${organization.code }" alt="请输入组织代码"/>
			</dd>
		</dl>
		<dl>     
			<dt>机构类型：</dt>
			<dd> 
				 <select name="jglx" id="jglx">
						<option value="1" <c:if test="${organization.jglx=='1' }">selected="selected"</c:if>>医疗机构</option>
						<option value="2" <c:if test="${organization.jglx=='2' }">selected="selected"</c:if>>供应商</option>
						<option value="3" <c:if test="${organization.jglx=='3' }">selected="selected"</c:if>>银行</option>
						<option value="4" <c:if test="${organization.jglx=='4' }">selected="selected"</c:if>>区级管理机构</option>
						<option value="5" <c:if test="${organization.jglx=='5' }">selected="selected"</c:if>>市级管理机构</option>
				</select>
			</dd>
		</dl>	
		<dl>
			<dt>父组织：</dt>
			<dd>
				<input name="parent.id" value="${organization.parent.id }" type="hidden"/>
				<input class="validate[required] required" name="parent.name" type="text" readonly="readonly" value="${organization.parent.name }"/>
				<a class="btnLook" href="${contextPath}/management/security/organization/lookupParent/${organization.id}" lookupGroup="parent" mask="true" title="更改父组织" width="400">查找带回</a>
			</dd>
		</dl>	
		<dl>
			<dt>平台自编码：</dt>
			<dd>
				<input type="text" name="ptzbm" class="validate[maxSize[64]]" size="32" value="${organization.ptzbm }" maxlength="64" alt="请输入平台自编码"/>
			</dd>
		</dl>		
		<dl>
			<dt>描述：</dt>
			<dd>
				<textarea name="description" cols="28" rows="3" maxlength="255">${organization.description }</textarea>
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