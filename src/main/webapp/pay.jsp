<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- head --%>
<c:import url="assets/pattern-jsp/head.jsp">
	<c:param name="title" value="Pay page" />
</c:import>

<body>
	<div class="row">
		<c:import url="assets/pattern-jsp/header.jsp" />
	</div>

	<div class="row">
		<c:import url="assets/pattern-jsp/menu.jsp" />
	</div>
	<div class="pay">

		<div style="display: flex; justify-content: center; padding: 5%;">
			<div class="content">
				<h1>Thank you very murch !</h1>
				<h3>
					Back to <a
						href="${pageContext.servletContext.contextPath}/${controlsrc}">Shop</a>
				</h3>
			</div>
		</div>

		<c:import url="assets/pattern-jsp/footer.jsp" />
	</div>
</body>
</html>