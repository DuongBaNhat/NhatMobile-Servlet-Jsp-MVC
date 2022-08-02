<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />
	
<%-- Head --%>
<c:import url="../assets/pattern-jsp/head.jsp">
	<c:param name="title" value="List page" />
</c:import>



<body>
	<div class="row">
		<c:import url="../assets/pattern-jsp/menu.jsp" />
	</div>
	<c:import url="navigation_admin.jsp" />

	<div class="list">
		<%-- search --%>
		<form action="searchadmin" method="post">
			<input type="hidden" name="action" value="search" />
			<p>
				Search : <input type="text" name="nsearch" value="${vsearch}">
				<input type="submit" value="Search">
		</form>
		<%-- add --%>
		<form action="addproduct" method="GET">
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
					<td>$ <fmt:formatNumber type="number" maxIntegerDigits="4"
							maxFractionDigits="3" value="${s.price}" /></td>

					<td>${s.number}</td>
					<td><a
						href="${contextRoot}/deleteproduct?action=listdelete&id=${s.id}&search=${param.search}"
						onclick="return confirm('Are you sure ?');">Delete</a></td>
					<td><a href="${contextRoot}/admin/update?id=${s.id}">Update</a></td>
					<td><a href="updatenumber?id=${s.id}">Update Number</a></td>
				</tr>
			</c:forEach>
		</table>

		<%-- pagination --%>
		<c:import url="../assets/pattern-jsp/pagination.jsp"></c:import>

	</div>
</body>
</html>