<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:url var="down" value="${controller}">
	<c:param name="id" value="${x.id}" />
	<c:param name="action" value="delete" />
</c:url>
<a href="${down}">+</a>
