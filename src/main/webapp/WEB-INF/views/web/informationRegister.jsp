<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<form action="newuserinfo" method="post">
<input type="hidden" name="userId" value="${user.userId}" />

<div class="form-group">
	<div class="row">
		<div class="col-xs-6">
			<label for="firstName">First Name</label> <input
				type="text" class="form-control" id="firstName"
				name="firstName" value="${user.firstName}" />
</div>
<div class="col-xs-6">
	<label for="lastName">Last Name</label> <input
		type="text" class="form-control" id="lastName"
		name="lastName" value="${user.lastName}" />
		</div>
	</div>
</div>
<div class="col-xs-6">
	<label for="address">Address: </label> <input
		type="text" class="form-control" id="address"
		name="address" value="${user.address}" />
</div>
	
<c:if test="${user.avatar != null}">
		<img id="image" alt="" src="${user.avatar}" style="width: 60%;">
	</c:if>
	<c:if test="${user.avatar == null}">
		<img id="image" alt="" src="/templates/images/noimage.png" style="width: 60px;">
	</c:if>
	<h4>Choose image: <input type="file" onchange="chooseFile(this)" id="avatarFile" name="avatarFile" placeholder="User avatar"  accept=".jpg, .png"></h4>

<div class="form-group">
	<label for="userName">UserName</label> <input type="text"
		class="form-control" id="userName" name="username"
		value="${user.username}" />
</div>

<div class="form-group">
	<label for="email">Email: </label> <input
		type="text" class="form-control" id="email" name="email"
		value="${user.email}" />
</div>
<div class="form-group">
	<label for="phone">Phone: </label> <input
		type="text" class="form-control" id="phone" name="phone"
		value="${user.phone}" />
</div>

<div class="form-group">
	<label for="txtNewPassword">Password</label>&nbsp;<span
		id="checkPasswordMatch" style="color: red;"></span> <input
		type="password" class="form-control" id="txtNewPassword"
		name="password" />
</div>
<p style="color: #828282">Nhập mật khẩu cho user</p>
<div class="form-group">
	<label for="txtConfirmPassword">Confirm Password</label> <input
		type="password" class="form-control"
		id="txtConfirmPassword" name="confirmPassword" />
</div>


	<button id="updateUserInfoButton" type="submit"
		class="btn btn-primary">Save All</button>
</form>
<script type="text/javascript">
		function chooseFile(fileInput){
			if(fileInput.files && fileInput.files[0]){
				var reader = new FileReader();
				reader.onload = function(e){
					$('#image').attr('src', e.target.result);
				}
				reader.readAsDataURL(fileInput.files[0]);
			}
		}							
	</script>