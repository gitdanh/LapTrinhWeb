<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/styleForFooter.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Your Store</title>
</head>
<body>
	<%@ include file="/common/vendor/header.jsp"%>
	<div>
	<sitemesh:write property='body'></sitemesh:write>
	</div>
	<%-- <div>
	<%@ include file="/common/vendor/footer.jsp"%>
	</div> --%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script type="text/javascript">
		function chooseFile(fileInput) {
			if (fileInput.files && fileInput.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#image').attr('src', e.target.result);
				}
				reader.readAsDataURL(fileInput.files[0]);
			}
		}
	</script>
	<script type="text/javascript">
		function changeEdit() {
		    var edit = document.getElementById("StoreEditButton");
		    var cancel = document.getElementById("StoreCancelEdit");
		    var update = document.getElementById("StoreUpdateButton");
		    
		    document.getElementById("storeName").removeAttribute("readonly");
			document.getElementById("storeAvatar").style.display="block";
			document.getElementById("storeDescription").removeAttribute("readonly");
			document.getElementById("isOpen").removeAttribute("disabled");
		    edit.style.display="none";
		    update.style.display="block";
		    cancel.style.display="block";
		}
		
		function cancelChange() {
			var edit = document.getElementById("StoreEditButton");
		    var cancel = document.getElementById("StoreCancelEdit");
		    var update = document.getElementById("StoreUpdateButton");
		    
		    document.getElementById("storeName").setAttribute("readonly", "readonly");
		    document.getElementById("storeAvatar").style.display="none";
			document.getElementById("storeDescription").setAttribute("readonly", "readonly");
			document.getElementById("isOpen").setAttribute("disabled", "disabled");
			document.getElementById("storeName").value = document.getElementById("storeName").defaultValue;
			document.getElementById("storeDescription").value = document.getElementById("storeDescription").defaultValue;;
			edit.style.display="block";
			update.style.display="none";
	    	cancel.style.display="none";
		}
	</script>
</body>
</html>
