<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="assets/pattern-jsp/head.jsp">
	<c:param name="title" value="Product page" />
</c:import>

<body>
	<div class="row">
		<c:import url="assets/pattern-jsp/header.jsp" />
	</div>

	<div class="row">
		<c:import url="assets/pattern-jsp/menu.jsp" />
	</div>

	<div class="row">
		<jsp:include page="assets/pattern-jsp/bodyleft.jsp" />
	</div>

	<c:import url="assets/pattern-jsp/footer.jsp" />
</body>
</html>