<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty sessionScope.cart}">
	<c:set scope="page" var="amount"
		value="${sessionScope.cart.productAll}" />
</c:if>

<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />

<div class="topnav" id="myTopnav">
	<a href="${contextRoot}/controller?action=home&status=home"
		class="${param.status eq 'home' ? 'active' : '' }">Home</a> <a
		href="${contextRoot}/controller?action=product&status=product"
		class="${param.status eq 'product' ? 'active' : '' }">Products</a> <a
		href="${contextRoot}/controller?action=about&status=about"
		class="${param.status eq 'about' ? 'active' : '' }">About</a>

	<%-- not Login --%>
	<c:if test="${empty sessionScope || sessionScope.check ne 1}">
		<div class="dropdown split">
			<form action="login">
				<input type="hidden" name="status" value="login">
				<button class="dropbtn ${param.status eq 'login' ? 'active' : '' }">
					Login<i class="fa fa-caret-down"></i>
				</button>
			</form>
			<div
				class="dropdown-content ${param.status eq 'register' ? 'active' : '' }">
				<a href="${contextRoot}/register?status=register">Register</a>
			</div>
		</div>
	</c:if>

	<%-- logined --%>
	<c:if test="${not empty sessionScope && sessionScope.check eq 1}">
		<div class="dropdown split">
			<button class="dropbtn }">
				${sessionScope.username}</<i class="fa fa-caret-down"></i>
			</button>

			<div class="dropdown-content">
				<%-- admin --%>
				<c:if test="${sessionScope.role ne null && sessionScope.role eq 1}">
					<a href="${contextRoot}/controller?action=index&status=profile"
						class="${param.status eq 'profile' ? 'active' : '' }">Profile</a>
					<a href="${contextRoot}/list?status=list"
						class="${param.status eq 'list' ? 'active' : '' }">Product
						manager</a>
				</c:if>
				<%-- user --%>
				<c:if test="${sessionScope.role eq null || sessionScope.role eq 0}">
					<a href="${contextRoot}/controller?action=user&status=profile"
						class="${param.status eq 'profile' ? 'active' : '' }">Profile</a>
				</c:if>

				<a href="${contextRoot}/history?status=history"
					class="${param.status eq 'history' ? 'active' : '' }">History
					order</a> <a href="${contextRoot}/logout?status=logout"
					class="${param.status eq 'logout' ? 'active' : '' }">Logout</a>
			</div>

		</div>
	</c:if>

	<%--Cart --%>
	<a class="cart ${param.status eq 'cart' ? 'active' : '' }"
		href="${contextRoot}/cart?status=cart"> <c:if
			test="${amount gt 0}">
			<i class="sticky has-sticky">${amount}</i>
		</c:if> <span>Cart</span>
	</a>

	<%-- responsive --%>
	<a href="javascript:void(0);" style="font-size: 15px;" class="icon"
		onclick="myFunction()">&#9776;</a>
</div>

<script>
	function myFunction() {
		var x = document.getElementById("myTopnav");
		if (x.className === "topnav") {
			x.className += " responsive";
		} else {
			x.className = "topnav";
		}
	}
</script>