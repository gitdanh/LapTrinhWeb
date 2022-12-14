<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${emailSent}"><div class="alert alert-info">An
	email has been sent to the email address you just
	registered. Please validate your email address and update
	your password information.</div>
</c:if>
<form action="verifyRegister" role="form" method="post">
	
	<span class="input-group-addon"><i
		class="glyphicon glyphicon-envelope color-blue"></i></span> <input
		id="opt" name="otp" placeholder="Enter OTP"
		class="form-control" type="text" required="required">
	<c:if test="${not empty message}">
		<span>${message}</span>
	</c:if>
	
	<div>
		<input value="Submit" type="submit">
	</div>
</form>