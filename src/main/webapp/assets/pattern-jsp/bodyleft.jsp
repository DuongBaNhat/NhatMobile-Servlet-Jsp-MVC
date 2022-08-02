<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextRoot"
	value="${pageContext.servletContext.contextPath}" scope="page" />

<div class="bodyleft row">
	<c:forEach var="p" items="${products}">
		<div class="col-s-6 col-3">

			<div class="product-box">

				<div class="fakeimg">
					<a href='<c:out value="${contextRoot}/infoproduct?id=${p.id}"></c:out>'> 
					<img
						class="img" alt='<c:out value="${p.name}"></c:out>' 
						src='<c:out value="${p.src}"/>'/>
					</a>
				</div>
	
				<a class="category" 
				href='<c:out value="${contextRoot}/infoproduct?id=${p.id}"/>' >
				<c:out value="${fn:toUpperCase(p.type)}"/> 
				</a>
				<br> <a class="title"
					href='<c:out value="${contextRoot}/infoproduct?id=${p.id}"></c:out>' >
					<c:out value="${p.name}"></c:out></a>
				<p class="price">
					<b><fmt:formatNumber type="number" maxIntegerDigits="4"
							maxFractionDigits="3" value="${p.price}" /> $</b>
				</p>

			</div>
		</div>
	</c:forEach>
</div>

<%-- pagination --%>
<c:import url="assets/pattern-jsp/pagination.jsp" />