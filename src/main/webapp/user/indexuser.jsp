<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- head --%>
<c:import url="../assets/pattern-jsp/head.jsp">
	<c:param name="title" value="User page" />
</c:import>

<body>
	<%-- Header --%>
	<div class="row">
		<c:import url="../assets/pattern-jsp/header.jsp" />
	</div>

	<div class="row">
		<c:import url="../assets/pattern-jsp/menu.jsp" />
	</div>
	<c:import url="navigation_user.jsp" />

	<div class="welcome">
		<h3>Welcome ${not empty sessionScope ? sessionScope.username : ""}</h3>

	</div>


</body>
</html>