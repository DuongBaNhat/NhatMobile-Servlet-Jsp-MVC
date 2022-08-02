<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot"
	value="${pageContext.servletContext.contextPath}" scope="page" />

<c:import url="../assets/pattern-jsp/head.jsp">
	<c:param name="title" value="Update page" />
</c:import>
<body>
	<div class="row">
		<c:import url="../assets/pattern-jsp/menu.jsp" />
	</div>
	<c:import url="navigation_admin.jsp" />

	<div id="updatenumber" class="list">

		<%--Form --%>
		<form action="updatenumber" method="post">
			<input type="hidden" name="action" value="submit">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Number</th>

				</tr>
				<c:forEach var="s" items="${products}">

					<c:if test="${s.id eq productId}">
						<c:if
							test="${sessionScope.update ne null && sessionScope.update eq 1}">
							<c:set scope="page" var="productnumber"
								value="${sessionScope.productnumber}" />
						</c:if>
						<c:if
							test="${sessionScope.update eq null || sessionScope.update eq 0}">
							<c:set scope="page" var="productnumber" value="${s.number}" />
						</c:if>
						<tr>
							<td style="width: 5%;"><input readonly="readonly"
								style="width: 100%;" name="id" value="${s.id}" /></td>
							<td style="width: 20%"><input readonly="readonly"
								style="width: 100%" type="text" name="name" value="${s.name}"></td>
							<td style="width: 5%"><input style="width: 100%"
								required="required" type="number" name="number"
								value="${productnumber}"></td>

						</tr>


					</c:if>
				</c:forEach>
			</table>
			<input class="submit" type="submit" value="Submit">
		</form>
		<h3>${message}</h3>
		<%-- pagination --%>

	</div>
</body>
</html>