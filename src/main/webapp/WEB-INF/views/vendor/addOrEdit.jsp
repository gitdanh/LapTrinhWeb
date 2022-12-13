<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<c:url value="/vendor/product/saveOrUpdate" var="saveOrUpdateUrl"/>
<form:form action="${saveOrUpdateUrl}" method="post" modelAttribute="book" enctype="multipart/form-data">
	<form:label path="">Book name:</form:label>
	<form:input path="bookName"/>
	<h4>Book author:</h4>
	<form:input path="author"/>
	<form:errors path="author"/>
	<div>
	<c:if test="${book.image != null}">
		<img id="image" alt="" src="${book.image}" style="width: 60%;">
	</c:if>
	<c:if test="${book.image == null}">
		<img id="image" alt="" src="/templates/images/noimage.png" style="width: 60px;">
	</c:if>
	<h4>Choose image: <input type="file" onchange="chooseFile(this)" id="imageFile" name="imageFile" placeholder="Book image"  accept=".jpg, .png"></h4>
	<h4>Tình trạng: <select name="isSelling" id="isSelling">
									<option ${book.isSelling==true?'selected':''} value="1">Mở bán</option>
									<option ${book.isSelling==false?'selected':''} value="0">Lưu trữ</option>
								</select>
	</h4> </div>
	<h4>Book category: 
	<form:select path="categoryId" items="${categories}" itemLabel="categoryName" itemValue="categoryId"></form:select>
	</h4>
	<input type="submit" value="Thêm"/>
</form:form>
