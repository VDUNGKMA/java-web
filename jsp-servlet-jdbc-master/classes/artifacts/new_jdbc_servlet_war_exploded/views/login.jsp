<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>

<body>
	<div class="container">
		<div class="card card-container">
			<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
			<img id="profile-img" class="profile-img-card"
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			
				<c:if test="${ not empty message}">
					<div class="alert alert-${alert}">${message}</div>
				</c:if>
				
			<form class="form-signin" action="<c:url  value='/dang-nhap'/>"
				id="formLogin" method="POST">

				<span id="reauth-email" class="reauth-email"></span> <input
					type="username" id="inputUsername" name="userName"
					class="form-control" placeholder="UserName" required autofocus>
				<input type="password" id="inputPassword" name="password"
					class="form-control" placeholder="Password" required> <input
					type="hidden" value="login" name="action" />
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Sign in</button>
			</form>
			<!-- /form -->

		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->

</body>

</html>