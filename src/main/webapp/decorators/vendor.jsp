<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop</title>
</head>
<body>
	<%@ include file="/common/vendor/header.jsp" %>
	<div>
		<sitemesh:write property='body'/>
	</div>
	<%@ include file="/common/vendor/footer.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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
</body>
</html>