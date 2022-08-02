<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--head --%>
<c:import url="assets/pattern-jsp/head.jsp">
	<c:param name="title" value="Login page" />
</c:import>

<body>

	<%-- Header --%>
	<div class="row">
		<c:import url="assets/pattern-jsp/header.jsp" />
	</div>

	<div class="row">
		<c:import url="assets/pattern-jsp/menu.jsp" />
	</div>
	<div id="login">
		<div class="login col-6 col-s-9">
			<%-- Login form --%>

			<%-- Register form --%>
			<div class="loginright ">
				<div>
					<h1>REGISTER FORM</h1>
				</div>
				<form id="loginid" class="form" onsubmit="return validate()"
					action="register" method="post">
					<div class="loginsub">
						<input type="hidden" name="action" value="doregister"> <label
							for="nameid">Name:</label><br> <input type="text"
							id="userid" name="name" value=""><br> <label
							for="userid">Email:</label><br> <input type="text"
							id="userid" name="username" value="${cookie['username'].value}"><br>

						<label for="passid">Password:</label><br> <input
							type="password" id="passid" name="password" value=""><br>

						<label for="rpass">Repeat password</label><br> <input
							type="password" id="rpassid" name="repassword" value=""><br>

						<label for="addressid">Address:</label><br> <input
							type="text" id="addressid" name="address" value=""><br>
						<label for="phoneid">Phone:</label><br> <input type="tel"
							id="phoneid" name="phone" value=""><br>


						<%-- remember me --%>
						<input id="remember" type="checkbox" name="remember"
							value="checked" ${not empty sessionScope && sessionScope.remember eq "checked" ? "checked" : ""}
							style="width: auto;"> <label for="remember"
							class="remember">Remember me</label><br> <br>
						<%-- submit --%>
						<input class="submits" type="submit" value="Submit">
					</div>
				</form>
				<p class="error">${message}</p>
			</div>
		</div>
	</div>
	<%-- Footer --%>
	<c:import url="assets/pattern-jsp/footer.jsp" />
</body>
</html>