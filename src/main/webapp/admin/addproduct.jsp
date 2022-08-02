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

	<div id="addproduct" class="list">

		<%--Form --%>
		<form action="addproduct" method="post">
			<input type="hidden" name="action" value="submit">
			<table border="1">
				<tr>
					<!-- <th>ID</th> -->
					<th>Name</th>
					<th>Price</th>
					<th>Number</th>

					<th>Type</th>
					<th>Brand</th>
				</tr>
				<%-- name of product --%>
				<c:if
					test="${sessionScope.addproduct ne null && sessionScope.addproduct eq 1}">
					<c:set scope="page" var="s" value="${sessionScope.product}" />
					<c:set scope="page" var="nameproduct"
						value="${sessionScope.product.name}" />
				</c:if>
				<c:if
					test="${sessionScope.addproduct eq null || sessionScope.addproduct eq 0}">
					<c:set scope="page" var="nameproduct"
						value="${sessionScope.vsearch}" />
				</c:if>
				<%-- enter information of product --%>
				<tr>
					<td><input required="required" style="width: 100%" type="text"
						name="name" value="${nameproduct}"></td>
					<td><input required="required" style="width: 100%" type="text"
						name="price" value="${s.price}"></td>
					<td><input required="required" style="width: 100%"
						type="number" name="number" value="${s.number}"></td>
					<td><input required="required" style="width: 100%" type="text"
						name="type" value="${s.type}"></td>

					<td><input required="required" style="width: 100%" type="text"
						name="brand" value="${s.brand}"></td>
				</tr>
				<tr>
					<td>Source image</td>
					<td colspan="3"><input required="required" style="width: 100%"
						type="text" name="src" value="${s.src}"></td>
					<td style="width: 10%;"><img style="width: 100%;" alt="image"
						src="${s.src}"></td>
				</tr>
				<tr style="">
					<td>Description</td>
					<td colspan="5"><textarea required="required" rows="6"
							cols="50" name="description"><c:out
								value="${s.description}" /></textarea></td>
				</tr>

			</table>
			<input class="submit" type="submit" value="Submit">
		</form>
		<h3>${message}</h3>

	</div>
</body>
</html>