<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
	type="text/javascript"></script>
<script src="assets/login.js" type="text/javascript"></script>


<c:import url="assets/pattern-jsp/head.jsp">
	<c:param name="title" value="Login page" />
</c:import>

</head>
<body>
	<%-- Header --%>
	<div class="row">
		<c:import url="assets/pattern-jsp/header.jsp" />
	</div>

	<div class="row">
		<c:import url="assets/pattern-jsp/menu.jsp" />
	</div>
	<div id="login">
		<div class="login col-s-9 col-6">
			<%-- Login form --%>
			<div class="loginleft">
				<div>
					<h1>LOGIN FORM</h1>
				</div>
				<div>
					<form id="loginid" class="form" action="login"
						onsubmit="return validate()" method="post">
						<div class="loginsub">
							<input type="hidden" name="action" value="dologin"> <label
								for="fname">Email:</label><br> <input type="text"
								id="fname" name="username" value="${cookie['username'].value}"><br>

							<label for="lname">Password:</label><br> <input
								type="password" id="lname" name="password" value=""><br>

							<%-- remember me --%>
							<input id="remember" type="checkbox" name="remember" value="checked" 
								 ${sessionScope.remember eq "checked" ? "checked" : ""}
								style="width: auto;"> 
								<label for="remember"
								class="remember">Remember me</label><br> <br> 
								
								<input
								type="submit" value="Submit">
						</div>

					</form>
				</div>
				<p class="error">${message}</p>
			</div>

		</div>
	</div>
	<%-- Footer form --%>
	<c:import url="assets/pattern-jsp/footer.jsp" />
</body>
</html>