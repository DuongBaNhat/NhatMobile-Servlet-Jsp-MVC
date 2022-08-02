<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />

<%-- declare attribute --%>

<%@ attribute name="id" required="true" rtexprvalue="true"
	type="java.lang.Integer" description="the id of product"%>

<%@ attribute name="textdown" required="true" rtexprvalue="true"
	type="java.lang.String" description="the text to show"%>
<%@ attribute name="textup" required="true" rtexprvalue="true"
	type="java.lang.String" description="the text to show"%>

<%@ attribute name="value" required="true" rtexprvalue="true"
	type="java.lang.Integer" description="the form up/down number"%>

<%-- onclick link --%>
<c:url var="linkdown" value="${controller}">
	<c:param name="id" value="${id}" />
	<c:param name="action" value="down" />
	<c:param name="number" value="${number}" />
</c:url>

<c:url var="linkup" value="${controller}">
	<c:param name="id" value="${id}" />
	<c:param name="action" value="up" />
	<c:param name="number" value="${number}" />
</c:url>


<%-- show on the screen --%>
<div style="display: flex;">

	<a
		style="text-decoration: none; font-size: 25px; background-color: white;"
		href="${linkdown}">${textdown}</a> 
		<span style="width: 50%;"><input
		type="number" name="number" value="${value}"></span> 
		<a
		style="text-decoration: none; font-size: 25px; background-color: white;"
		href="${linkup}">${textup}</a>
</div>
