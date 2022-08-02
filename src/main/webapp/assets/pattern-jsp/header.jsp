<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set scope="page" var="contextRoot"
	value="${pageContext.servletContext.contextPath}"></c:set>

<div class="header">
	<div class="col-3 col-s-4 logo">
		<img src="${contextRoot}/media/img_icon/logo.png" alt="logo">
	</div>
	<div class="col-9 col-s-8 ">
		<form class="form-search" action="search" method="post"
			style="width: 100%;">
			<%-- category --%>
			<div class="col-3 col-s-4">
				<select name="product_cat" id="category-search-name"
					class="category-search-select">
					<option value="all" ${type == "all" ? "selected" : ""}>Search
						all categories</option>
					<option class="level-0" value="cellphone"
						${type == "cellphone" ? "selected" : ""}>Cell Phone</option>
					<option class="level-0" value="earphone"
						${type == "earphone" ? "selected" : ""}>Earphone</option>
					<option class="level-0" value="speaker"
						${type == "speaker" ? "selected" : ""}>Speaker</option>
					<option class="level-0" value="powerbank"
						${type == "powerbank" ? "selected" : ""}>Power Bank</option>
					<option class="level-0" value="screenstickers"
						${type == "screenstickers" ? "selected" : ""}>Screen
						Stickers</option>
					<option class="level-0" value="cable-charger"
						${type == "cable-charger" ? "selected" : ""}>Cable
						Charger</option>
					<option class="level-0" value="case"
						${type == "case" ? "selected" : ""}>Case</option>
				</select>

			</div>
			<%-- form search --%>
			
			<div class="col-9 col-s-8 search">
				<input type="hidden" name="action" value="search"> <input
					class="input" id="searchid" type="text" name="nsearch"
					value="${vsearch}" placeholder="Search here"> <input
					class="submit" type="submit" value="Search">
			</div>
		</form>
	</div>
</div>