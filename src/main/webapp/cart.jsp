<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />

<c:import url="assets/pattern-jsp/head.jsp">
	<c:param name="title" value="Cart page" />
</c:import>

<body>
	<div class=row>
		<c:import url="assets/pattern-jsp/header.jsp" />
	</div>
	<div class="row">
		<c:import url="assets/pattern-jsp/menu.jsp" />
	</div>

	<div id="cart">

		<div class="cart">
			<div class="flex-cart">
				<c:if
					test="${empty sessionScope.cart or sessionScope.cart.items.size() eq 0 }">
					<h1>Your cart is empty</h1>
				</c:if>
				<h3>
					click <a href="${contextRoot}/${controlsrc}">here</a> to shopping
				</h3>

				<%-- cart --%>

				<c:if
					test="${not empty sessionScope.cart and sessionScope.cart.items.size() ne 0}">


					
					<form action="pay" method="post">
						<%-- product in cart --%>
						<table class="tableproduct" border="1">
							<tr>
								<th>Products in cart: ${sessionScope.cart.items.size()}</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Amount</th>
								<th>Option</th>
							</tr>

							<c:forEach var="x" items="${sessionScope.cart.items}">

								<tr>
									<td>${x.name}<br>ID: ${x.id}
									</td>
									<td>$ <fmt:formatNumber type="number" maxIntegerDigits="4"
											maxFractionDigits="3" value="${x.price}" />
									</td>

									

									<td class="number">
										<div style="display: flex;">
											<a class="minus"
												href="${contextRoot}/${controller}?action=minus&id=${x.id}">&#8681;
											</a> <input class="value" type="text" name="${x.id}"
												onmouseout="${contextRoot}/${controller}?action=plus&id=${x.id}"
												value="${x.number}">
											<a class="plus"
												href="${contextRoot}/${controller}?action=plus&id=${x.id}">&#8679;
											</a>
										</div>
									</td>

									<td>$ <fmt:formatNumber type="number" maxIntegerDigits="4"
											maxFractionDigits="3" value="${x.price * x.number}" /></td>
									<td><c:url var="delete" value="${controller}">
											<c:param name="id" value="${x.id}" />
											<c:param name="action" value="delete" />
										</c:url> <a href="${delete}" onclick="return confirm('delete?')">delete</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" style="text-align: right;">Total: $ <fmt:formatNumber
										type="number" maxIntegerDigits="4" maxFractionDigits="3"
										value="${sessionScope.cart.amount}" />
								</td>
							</tr>

						</table>
						<%-- information of customer --%>

						<table>
							<tr>
								<td>Email:</td>
								<td><input type="email" name="email"
									value="${not empty sessionScope ? sessionScope.username : ''}"
									required="required"></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><input type="text" name="address" value=""></td>
							</tr>
							<tr>
								<td>Discount:</td>
								<td><input type="text" name="discount" value=""></td>
							</tr>

						</table>
						<%-- submit form --%>
						<input class="pay" type="submit" value="Pay">
					</form>
				</c:if>
			</div>
		</div>
	</div>
	<div>
		<c:import url="assets/pattern-jsp/footer.jsp" />
	</div>

</body>
</html>