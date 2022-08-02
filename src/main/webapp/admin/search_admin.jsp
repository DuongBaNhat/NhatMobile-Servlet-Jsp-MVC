<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../assets/pattern-jsp/head.jsp">
	<c:param name="title" value="List page" />
</c:import>

<body>
	<div class="row">
		<c:import url="../assets/pattern-jsp/menu.jsp" />
	</div>
	<c:import url="navigation_admin.jsp" />

	<div class="list">
		<c:if
			test="${sessionScope.productAll ne null && sessionScope.productAll gt 0}">
			<p>Result: ${sessionScope.productAll} products</p>
		</c:if>
		<c:if
			test="${sessionScope.productAll eq null || sessionScope.productAll le 0}">
			<p>Result: not found product!</p>
		</c:if>
		<%-- search --%>
		<form action="searchadmin" method="post">
			<input type="hidden" name="action" value="searchadmin" />
			<p>
				Search : <input type="text" name="nsearch" value="${vsearch}">
				<input type="submit" value="Search">
		</form>

		<%-- add --%>
		<form action="addproduct" method="GET">
			<input type="hidden" name="action" value="addproduct2">
			<c:if test="${sessionScope.vsearch ne null }">
				<input type="hidden" name="vsearch" value="${sessionScope.vsearch}">
			</c:if>
			<p>
				<input type="submit" value="Add">
		</form>

		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Number</th>
				<th>Delete</th>
				<th>Update</th>
				<th>Update Number</th>
			</tr>
			<c:forEach var="s" items="${products}">
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.price}</td>
					<td>${s.number}</td>
					<td><a href="deleteproduct?action=searchdelete&id=${s.id}&search=${param.search}"
						onclick="return confirm('Are you sure ?');">Delete</a></td>
					<td><a href="update?id=${s.id}">Update</a></td>
					<td><a href="updatenumber?action=updatenumberSearch&id=${s.id}">Update Number</a></td>
				</tr>
			</c:forEach>
		</table>

		<%-- pagination --%>
		<c:import url="../assets/pattern-jsp/pagination.jsp"></c:import>

	</div>
</body>
</html>