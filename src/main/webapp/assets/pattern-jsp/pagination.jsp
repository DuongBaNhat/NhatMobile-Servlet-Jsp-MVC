<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- set variable --%>
<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}" />
<div id="pagination">
	<div class="pagination">
		<a
			href="${contextRoot}/${controller}?action=${action}&page=${page <= 1 ? 1 : (page - 1)}">&lt;&lt;</a>

		<c:forEach var="i" begin="1" end="${pageAll}">
			<a class='${page == i ? "active" : "" }'
				href="${contextRoot}/${controller}?action=${action}&page=${i}">${i}</a>
		</c:forEach>

		<a
			href="${contextRoot}/${controller}?action=${action}&page=${page >= pageAll ? pageAll : page + 1}">&gt;&gt;</a>

	</div>
</div>
