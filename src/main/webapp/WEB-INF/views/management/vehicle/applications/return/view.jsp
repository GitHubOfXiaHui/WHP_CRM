<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageFormContent" layoutH="97">
	<div>
		<p>
			<label>车牌号：</label>
			<input type="text" value="${application.parent.license }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人姓名：</label>
			<input type="text" value="${application.departure }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>目的地：</label>
			<input type="text" value="${application.destination }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>驾驶员：</label>
			<input type="text" value="${application.driver }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>乘车人数（人）：</label>
			<input type="text" value="${application.passengerNum }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>车辆用途：</label>
			<input type="text" value="${application.applicationIntent }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人：</label>
			<input type="text" value="${application.applicationUser.realname }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请人所在派出所：</label>
			<input type="text" value="${application.applicationUser.organization.name }" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>申请时间：</label>
			<input type="text" value="<fmt:formatDate value="${application.startTime }" pattern="yyyy-MM-dd"/>" size="20" readonly="readonly"/>
		</p>
	</div>
	<div class="divider"></div>
	
	<div>
		<p>
			<label>车行驶数始码：</label>
			<input type="text" value="${application.startFGReading }" name="startFGReading" size="20"/>
		</p>
		<p>
			<label>车行驶数止码：</label>
			<input type="text" value="${application.endFGReading }" name="endFGReading" />
		</p>
		<p>
			<label>实际驾驶人：</label>
			<input type="text" value="${application.actualDriver }"  name="actualDriver" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>还车地点：</label>
			<input type="text" value="${application.returnSite }" size="20" readonly="readonly"/>
		</p>
				<p>
			<label>还车人：</label>
			<input type="text" value="${application.returnUser }" size="20" readonly="readonly"/>
		</p>
				<p>
			<label>还车时间：</label>
			<input type="text" value="<fmt:formatDate value="${application.returnDate }" pattern="yyyy-MM-dd HH:mm"/>" size="20" readonly="readonly"/>
		</p>
		<p>
			<label>还车备注：</label>
			<textarea value="" rows="1" cols="30"  name="returnRemark" size="20" readonly="readonly">${application.returnRemark }</textarea>
		</p>
		<p >
		<label> 是否事故：</label>
		<c:if test="${application.accident }">
		<input type="text" value="是" size="20" readonly="readonly"/></c:if>
		<c:if test="${!application.accident }">
		<input type="text" value="否" size="20" readonly="readonly"/></c:if>
		</p>
		<p>
			<label>事故备注：</label>
			<textarea rows="1" cols="30" name="accidentRemark" size="20" readonly="readonly">${application.accidentRemark }</textarea>
		</p>
	</div>
	
	
</div>
<div class="formBar">
	<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
</div>
