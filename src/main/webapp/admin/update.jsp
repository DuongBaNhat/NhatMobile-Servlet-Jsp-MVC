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

	<div id="update" class="list">

		<%--Form --%>
		<form action="update" method="post">
			<input type="hidden" name="action" value="submit">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Number</th>

					<th>Type</th>
					<th>Brand</th>
				</tr>

				<c:forEach var="p" items="${products}">
					<c:if test="${p.id eq productId}">
						<c:if
							test="${sessionScope.update ne null && sessionScope.update eq 1}">
							<c:set scope="page" var="s" value="${sessionScope.product}" />
						</c:if>
						<c:if
							test="${sessionScope.update eq null || sessionScope.update eq 0}">
							<c:set scope="page" var="s" value="${p}" />
						</c:if>
						<tr>
							<td style="width: 5%;"><input readonly="readonly"
								style="width: 100%;" name="id" value="${s.id}" /></td>
							<td><input required="required" style="width: 100%"
								type="text" name="name" value="${s.name}"></td>
							<td><input required="required" style="width: 100%"
								type="text" name="price" value="${s.price}"></td>
							<td><input required="required" style="width: 100%"
								type="number" name="number" value="${s.number}"></td>
							<td><input required="required" style="width: 100%"
								type="text" name="type" value="${s.type}"></td>

							<td><input required="required" style="width: 100%"
								type="text" name="brand" value="${s.brand}"></td>
						</tr>
						<tr>
							<td>Source image</td>
							<td colspan="4"><input required="required"
								style="width: 100%" type="text" name="src" value="${s.src}"></td>
							<td style="width: 10%;"><img style="width: 100%;"
								alt="image" src="${s.src}"></td>
						</tr>
						<tr style="">
							<td>Description</td>
							<td colspan="5"><textarea required="required" rows="6"
									cols="50" name="description"><c:out
										value="${s.description}" /></textarea></td>
						</tr>

					</c:if>
				</c:forEach>
			</table>
			<input class="submit" type="submit" value="Submit">
		</form>
		<h3>${message}</h3>


	</div>
</body>
</html>