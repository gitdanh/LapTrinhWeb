<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:if test="${success==true}"><h1>Cập nhật thành công</h1></c:if>
<h1>Thông tin của shop</h1>
<form action="storeprofile" method="post" enctype="multipart/form-data">
			
            <div>
            	<label for="storeName">Tên của cửa hàng:</label>
                <input id="storeName" name="storeName" type="text" placeholder="Tên cửa hàng..." value="${store.storeName}" readonly="readonly"/>
                <form:errors path="storeName"/>
			</div>
			<div>
				<label for="storeAvatar">Ảnh đại diện của cửa hàng:</label>
				<c:if test="${store.avatar != null}">
					<img id="image" alt="" src="${store.avatar}" style="width: 100px;">
				</c:if>
				<c:if test="${store.avatar == null}">
					<img id="image" alt="" src="/templates/images/nostoreavatar.png"
					style="width: 100px;">
				</c:if>
				<input id="storeAvatar" type="file" name="avatarFile" onchange="chooseFile(this)" style="display: none;"/>
			</div>
			<div>
				<label for="storeDescription">Mô tả:</label>
			    <textarea id="storeDescription" name="description" placeholder="Mô tả về cửa hàng..." readonly="readonly">${store.description}</textarea>
			    <form:errors path="description"/>
			</div>
			<div>
				<label for="isOpen">Trạng thái cửa hàng:</label>
				<select name="open" id="isOpen" disabled="disabled">
					<option ${store.open==true?'selected':''} value="1">Mở cửa</option>
					<option ${store.open==false?'selected':''} value="0">Đóng cửa</option>
				</select>
			</div>
        <input id="StoreEditButton" type="button" onclick="changeEdit()" value="Chỉnh sửa" style="display: block;"/>
        <input id="StoreUpdateButton" type="submit" value="Cập nhật" style="display: none;"/>
		<input id="StoreCancelEdit" type="button" onclick="cancelChange()" value="Hủy" style="display: none;"/>
</form>