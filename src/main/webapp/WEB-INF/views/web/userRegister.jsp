<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<form:form action="register" method="post" modelAttribute="userModel">
	<div class="form-group">
		<c:if test="${usernameExists}"><span
			style="color: red;">Username already exists. Choose a different one.</span>
		</c:if> 
		<label for="newUsername">Username: </label>&nbsp;
		<input
			required="required" type="text" class="form-control"
			id="newUsername" name="username" /><form:errors path="username"/>
		<p style="color: #828282">Enter your username here.</p>
	</div>

	<div class="form-group">
		<c:if test="${emailExists}">
			<span
			style="color: red;">Email
			already exists. Choose a different one.</span> 
		</c:if>
		<label for="email">Email Address: </label>
			<input
			required="required" type="text" class="form-control"
			id="email" name="email" /> <form:errors path="email"></form:errors>
		<p style="color: #828282">A valid email address. All
			emails from the system will be sent to this address. The
			email address is not made public and will only be used if
			you wish to receive a new password or wish to receive
			certain notification.</p>
	</div>

	<button type="submit" class="btn btn-primary">Create
		new account</button>
</form:form>