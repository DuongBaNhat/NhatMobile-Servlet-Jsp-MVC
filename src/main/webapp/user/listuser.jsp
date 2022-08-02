<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set scope="page" var="contextRoot" value="${pageContext.servletContext.contextPath}" />

<div class="list">

	<form action="searchadmin" method="post">
		<input type="hidden" name="action" value="index" />
		<p>
			Search : <input type="text" name="nsearch" value="${vsearch}">
			<input type="submit" value="Search">
	</form>

	<form action="addproduct" method="GET">
		<p>
			<input type="submit" value="Add"
				onclick="return confirm('Are your sure?');">
	</form>

	<%-- list order --%>
	<table border="1">
		<tr>
			 <th>Order ID</th>
	         <th>Product</th>
	         <th>Price</th>
	         <th>Status</th>
		</tr>
		<tr><c:if test="${empty orders}">
			<h4><c:out value="Your history is empty!"/></h4>
		</c:if> </tr>
		<c:forEach var="o" items="${orders}">
			<tr>
				<td><a href="#">${o.id}</a></td>
				<td>
					<ul>
						<c:forEach var="p" items="${o.lp}">
							<li>
								<a href="${contextRoot}/infoproduct?id=${p.productId}">${p.nameProduct}</a>
							</li>
						</c:forEach>
					</ul>
				
				</td>
				<td>($) ${Math.round(o.price * 100.0)/ 100.0}</td>
				<td>${o.status}</td>
				
				
	
				<td><a href="#"
					onclick="return confirm('Are you sure ?');">Delete</a></td>
				<td><a href="#">Update</a></td>
				<td><a href="#">Update Number</a></td>
			</tr>
		</c:forEach>
	</table>

	<%-- pagination --%>
	<c:import url="../assets/pattern-jsp/pagination.jsp"></c:import>
	<%-- back to admin page --%>
	
</div>