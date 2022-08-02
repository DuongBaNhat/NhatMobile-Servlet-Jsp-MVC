<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />

<c:import url="assets/pattern-jsp/head.jsp">
	<c:param name="title" value="About page" />
</c:import>

<body>
	<div class="row">
		<c:import url="assets/pattern-jsp/header.jsp" />
	</div>

	<div class="row">
		<c:import url="assets/pattern-jsp/menu.jsp" />
	</div>

	<div id="about">
		<div class="content-box">
			<div class="content">
				<h1>PRJ321x Assignment 3</h1>
				<p>
					Sinh viên: Dương Bá nhật <br> MSSV: nhatdbfx09444<br>
				</p>
			</div>
		</div>


	</div>
	<c:import url="assets/pattern-jsp/footer.jsp" />
</body>
</html>