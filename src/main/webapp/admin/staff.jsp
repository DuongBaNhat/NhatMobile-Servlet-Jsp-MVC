<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />

<%-- Head --%>
<c:import url="../assets/pattern-jsp/head.jsp">
	<c:param name="title" value="List account page" />
</c:import>

<body>
	<div class="row">
		<c:import url="../assets/pattern-jsp/menu.jsp" />
	</div>
	<c:import url="navigation_admin.jsp" />

	<div class="list">
		<form action="#" method="post">
			<input type="hidden" name="action" value="list" />
			<p>
				Search : <input type="text" name="nsearch" value="${vsearch}">
				<input type="submit" value="Search">
		</form>

		<form action="#" method="GET">
			<c:if test="${sessionScope.vsearch ne null }">
				<input type="hidden" name="vsearch" value="${sessionScope.vsearch}">
			</c:if>
			<p>
				<input type="submit" value="Add">
		</form>

		<table border="1">
			<tr>
				<th>User</th>
				<th>Password</th>
				<th>Role</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Delete</th>
				<th>Update</th>
				<th>Update role</th>
			</tr>
			<c:forEach var="a" items="${sessionScope.accounts}">
				<tr>
					<td>${a.user}</td>
					<td>${a.password}</td>
					<td>${a.role}</td>
					<td>${a.name}</td>
					<td>${a.address}</td>
					<td>${a.phone}</td>
					<td><a href="#" onclick="return confirm('Are you sure ?');">Delete</a></td>
					<td><a href="#">Update</a></td>
					<td><a href="#">Update role</a></td>
				</tr>
			</c:forEach>
		</table>

		<%-- pagination --%>
		<c:import url="../assets/pattern-jsp/pagination.jsp"></c:import>

	</div>
</body>
</html>