<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${contextRoot}/css/css_asm2.css"
	type="text/css">
<link rel="stylesheet"
	href="${contextRoot}/admin/css/css_admin_asm2.css" type="text/css" />
<link rel="stylesheet"
	href="${contextRoot}/admin/css/css_login_asm2.css" type="text/css" />
<link rel="stylesheet"
	href="${contextRoot}/admin/css/css_staff_asm2.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${contextRoot}/css/css_infoproduct.css" />
<link rel="stylesheet" type="text/css" href="${contextRoot}/css/css_cart.css" />
<link rel="stylesheet" type="text/css" href="${contextRoot}/assets/pattern-jsp/css-pattern/css_menu.css"/>
<link rel="stylesheet" type="text/css" href="${contextRoot}/css/css-register.css" >
<link rel="stylesheet" type="text/css" href="${contextRoot}/admin/css/css_update.css"/>
<link rel="stylesheet" type="text/css" href="${contextRoot}/admin/css/css_updatenumber.css"/>
<link rel="stylesheet" type="text/css" href="${contextRoot}/admin/css/css_addproduct.css"/>

<link rel="stylesheet" type="text/css" href="${contextRoot}/css/css_error.css" />
<link rel="stylesheet" type="text/css" href="${contextRoot}/css/css_about.css" />
<link rel="stylesheet" type="text/css" href="${contextRoot}/assets/pattern-jsp/css-pattern/css_pagination.css" />
<link rel="stylesheet" type="text/css" href="${contextRoot}/assets/pattern-jsp/css-pattern/css_header.css"/>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="icon" href="${contextRoot}/media/img_icon/logo.png"
	type="image/x-icon">


<%-- javascrip --%>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
	type="text/javascript"></script>
<script src="assets/login.js" type="text/javascript"></script>



<title>${param.title}</title>
</head>