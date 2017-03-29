<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="com.wondersgroup.framework.service.StatusDefinition.RegStatus" %>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>


<form method="post" action="${contextPath }/management/register/regSupplier/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="97">
		<p>
			<label>供应商名称：</label>
			<input type="text" name="name" class="validate[required,maxSize[64]] required" size="22" maxlength="64" /> 
			<input type="hidden" name="status" value='<%=RegStatus.OPER_SAVE.getCode() %>' />
		</p>
		<p>
			<label>简称：</label>
			<input type="text" name="forshort" class="validate[maxSize[20]]" size="22" maxlength="20"/> 
		</p>
		<p>
			<label>英文名称：</label>
			<input type="text" name="ename" class="validate[maxSize[64]]" size="22" maxlength="64"/> 
		</p>
		<p >
			<label>名称拼音：</label>
			<input type="text" name="spell" class="validate[maxSize[128]]" size="22" maxlength="128"/>
		</p>
		<p>
			<label>机构类型：</label>
			<select	name="type" class="validate[required,maxSize[16]] required">
				<option value="">请选择</option>
				<c:forEach var="supplier" items="${supplierTypes}">
					<option value="${supplier.code}"}>${supplier.name}</option>
				</c:forEach>
			</select>
			<label><font color="red">*</font></label>
		</p>
		<p>
			<label>法人代表：</label>
			<input type="text" name="legal" class="validate[maxSize[32]]" size="22" maxlength="32"/>
		</p>
		<p>
			<label>法人代表电话：</label>
			<input type="text" name="legalPhone" class="validate[custom[phone],maxSize[20]]" size="22" maxlength="20" /> 
		</p>
		<p>
			<label>公司地址：</label>
			<input type="text" name="regAddress" class="validate[maxSize[128]]" size="22" maxlength="128" /> 
		</p>
		<p>
			<label>公司网址：</label>
			<input type="text" name="website" class="validate[maxSize[128]]" size="22"/> 
		</p>
			<p>
			<label>营业执照号：</label>
			<input type="text" name="workNo" class="validate[maxSize[64]]" size="22" maxlength="64" /> 
		</p>
		<p>
			<label>开票单位：</label>
			<input type="text" name="invoiceProvideUnit" class="validate[maxSize[64]]" size="22" maxlength="64" /> 
		</p>
			<p>
			<label>税号：</label>
			<input type="text" name="taxId" class="validate[maxSize[32]]" size="22" maxlength="32" /> 
		</p>
		<p>
			<label>开户行：</label>
			<input type="text" name="bank" class="validate[maxSize[128]]" size="22" maxlength="128" /> 
		</p>
		<p>
			<label>银行账号：</label>
			<input type="text" name="accountNo" class="validate[number,maxSize[64]]" size="22" maxlength="64" /> 
		</p>
		<p>
			<label>备注：</label>
			<textarea rows="1" cols="20" name="remark" maxlength="255"></textarea>
		</p>
		<div class="divider"></div>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:void(0)"><span>联系人列表</span></a></li>
						<li class="selected"><a href="javascript:void(0)"><span>产品列表</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 220px;">
				<div>
					<table class="list nowrap itemDetail" addButton="添加" width="100%">
						<thead align="center">
							<tr>
								<th type="text" name="linkmanList[#index#].manName" size="20" fieldClass="validate[required,maxSize[64]] required">姓名</th>
								<th type="text" name="linkmanList[#index#].mobilePhone" size="20" fieldClass="validate[required,custom[phone],maxSize[64]] required">移动电话</th>
								<th type="text" name="linkmanList[#index#].telephone" fieldClass="validate[custom[phone],maxSize[64]]" size="20">固定电话</th>
								<th type="text" name="linkmanList[#index#].fax" size="10" fieldClass="validate[custom[phone],maxSize[64]]">传真号码 </th>
								<th type="text" name="linkmanList[#index#].email" size="20" fieldClass="validate[custom[email],maxSize[64]]">Email</th>
							    <th type="text" name="linkmanList[#index#].linkmanAddress" size="30">联系地址</th>
							    <th type="text" name="linkmanList[#index#].remark" size="30">备注</th>
								<th type="del" width="40">操作</th>
							</tr>
						</thead>
						<tbody align="center"></tbody>
					</table>
				</div>
				
				<div>
					<table class="list nowrap itemDetail" addButton="添加" width="100%">
						<thead align="center">
							<tr>
								<th type="text" name="produceItemList[#index#].productName" size="20" fieldClass="validate[required,maxSize[64]] required">商品名称</th>
								<th type="text" name="produceItemList[#index#].productCode" size="20" fieldClass="validate[required,maxSize[64]] required">商品编号</th>
								<th type="text" name="produceItemList[#index#].healthRecordNo" size="20">卫生部备案编号</th>
								<th type="text" name="produceItemList[#index#].versionNo" size="10">商品版本号 </th>
								<th type="text" name="produceItemList[#index#].brand" size="20" fieldClass="validate[required,maxSize[64]] required">品牌</th>
							    <th type="text" name="produceItemList[#index#].specs" size="20">规格</th>
							    <th type="text" name="produceItemList[#index#].modelNumber" size="20">型号</th>
							    <th type="text" name="produceItemList[#index#].unitPrice" size="20" fieldClass="validate[custom[number]]">单价（元）</th>
							    <th type="text" name="produceItemList[#index#].qtyUnit" size="20">单位</th>
							    <th type="text" name="produceItemList[#index#].sku" size="20" fieldClass="validate[custom[integer]]">最小包装量（个）</th>
							    <th type="text" name="produceItemList[#index#].packageSize" size="20">运输包装尺寸（cm*cm*cm）</th>
							    <th type="text" name="produceItemList[#index#].packageGW" size="20" fieldClass="validate[custom[number]]">运输包装毛重（kg）</th>
							    <th type="text" name="produceItemList[#index#].describe" size="20">描述</th>
								<th type="del" width="40">操作</th>
							</tr>
						</thead>
						<tbody align="center"></tbody>
					</table>
				</div>
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>