<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Đăng Nhập</h1>
	<c:if test="${param.error != null}">
		<div style="color: red;">Incorrect username or password.</div>
	</c:if>

	<form action="" method="post">
		<div class="form-group">
			<label for="username">Username: </label> <input required="required"
				type="text" class="form-control" id="username" name="username" />
			<p style="color: #828282">Enter your username here.</p>
		</div>

		<div class="form-group">
			<label for="password">Password: </label> <input required="required"
				type="password" class="form-control" id="password" name="password" />
			<p style="color: #828282">Enter the password that accompanies
				your username</p>
		</div>

		<button type="submit" class="btn btn-primary">Đăng nhập</button>
		
	</form>
	<a th:href="/@{/forgot_password}">Forgot your password?</a>
</body>
</html>