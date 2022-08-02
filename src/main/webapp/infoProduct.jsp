<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="assets/pattern-jsp/head.jsp">
	<c:param name="title" value="Information of product" />
</c:import>
<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />


<body>
	<div class=row>
		<c:import url="assets/pattern-jsp/header.jsp" />
	</div>
	<div class="row">
		<c:import url="assets/pattern-jsp/menu.jsp" />
	</div>
	<div id="infoproduct">
		<div class="infoproduct">
			<div class="product-boxs">

				<div class="image">
					<%-- <img alt="${product.name}" src="${product.src}">  --%>
					<img
						alt='<c:out value="${product.name }"/>'
						src='<c:out value="${product.src}"/>' />
				</div>
				<div class="detail">
					<ul>
						<li class="name"><c:out value="${product.name}"/> </li>
						<li class="price">($) <fmt:formatNumber type="number"
								maxIntegerDigits="4" maxFractionDigits="3"
								value="${product.price}" /></li>
						<li class="brand"><c:out value="${product.brand}"/> </li>
						<li class="description"><c:out value="${product.description}"/> </li>
					</ul>

				</div>


			</div>

			<div class="addtocart">
				<a href="${contextRoot}/cart?action=add&id=${product.id}">Add to
					cart</a>
			</div>
		</div>
	</div>
	<div>
		<c:import url="assets/pattern-jsp/footer.jsp" />
	</div>

</body>
</html>