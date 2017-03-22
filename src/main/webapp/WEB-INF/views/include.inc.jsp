<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="keta" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
	String basePath = request.getContextPath();
%>
