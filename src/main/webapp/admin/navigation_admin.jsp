<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set scope="page" var="contextRoot" value= "${pageContext.servletContext.contextPath}"/>

<div class = "navigation">
	<ul>
		<li><a class='${action == "index" ? "active" : ""}'
			href="${contextRoot}/controller?action=index">Welcome</a></li>
		<li><a class='${action == "list" ? "active" : ""}' 
			href="${contextRoot}/list">Product manager</a></li>
		<li><a class='${action == "staff" ? "active" : ""}' 
			href="${contextRoot}/admin/listaccount">Acount manager</a></li>
			
		<li><a class='${action == "history" ? "active" : ""}' 
			href="${contextRoot}/history">History order</a></li>	
		<li><a href="${contextRoot}/logout">Logout</a></li>
	</ul>
</div>
