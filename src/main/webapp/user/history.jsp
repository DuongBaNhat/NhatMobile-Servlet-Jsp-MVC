<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />

<c:import url="../assets/pattern-jsp/head.jsp">
	<c:param name="title" value="History page" />
</c:import>

<body>

	<c:if test="${role == 0}">
		<div class="row">
			<c:import url="../assets/pattern-jsp/header.jsp" />
		</div>
		<div class="row">
			<c:import url="../assets/pattern-jsp/menu.jsp" />
		</div>
		<jsp:include page="navigation_user.jsp" />
	</c:if>
	<c:if test="${role == 1}">
		<div class="row">
			<c:import url="../assets/pattern-jsp/menu.jsp" />
		</div>
		<c:import url="../admin/navigation_admin.jsp" />
	</c:if>



	<div class="list">
		<c:if test="${empty orders}">
			<h4>
				<c:out value="Your history is empty!" />
			</h4>
		</c:if>
		<c:if test="${not empty orders}">
			<%-- list order --%>
			<table border="1">
				<tr>
					<th>Order ID</th>
					<th>Product</th>
					<th>Price</th>
					<th>Status</th>
				</tr>
				<c:forEach var="o" items="${orders}">
					<tr>
						<td style="width: 5%;"><a href="#">${o.id}</a></td>
						<td>
							<ul>
								<c:forEach var="p" items="${o.lp}">
									<li><a href="${contextRoot}/infoproduct?id=${p.productId}">${p.nameProduct}</a>
									</li>
								</c:forEach>
							</ul>

						</td>
						<td>$ <fmt:formatNumber type="number" maxIntegerDigits="4"
								maxFractionDigits="3" value="${o.price}" /></td>


						<td style="color: green">${o.status eq 2 ? "Successfull": "Not yet"}</td>

					</tr>
				</c:forEach>
			</table>
			<%-- pagination --%>
			<c:import url="../assets/pattern-jsp/pagination.jsp"></c:import>

		</c:if>


	</div>

	<%-- <c:import url="../assets/pattern-jsp/footer.jsp" /> --%>
</body>
</html>