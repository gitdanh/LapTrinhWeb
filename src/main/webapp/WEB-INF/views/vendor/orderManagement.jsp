<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


<div>
	<a href="/vendor/order/notprocessed">Đơn chờ xử lý</a> <hr>
	<a href="/vendor/order/processing">Đơn đang xử lý</a> <hr>
	<a href="/vendor/order/shipped">Đơn đang vận chuyển</a> <hr>
	<a href="/vendor/order/delivered">Đơn đã giao</a> <hr>
	<a href="/vendor/order/cancelled">Đơn đã hủy</a> <hr>
</div>
<div style="color: red;">
	<c:if test="${message!=null}">${message}</c:if>
</div>
<table>
<thead>
 <tr>
	<th>| Người Đặt</th>
	<th>| Địa Chỉ Giao</th>
	<th>| Tình Trạng Thanh Toán</th>
	<th>| Tình trạng Đơn Hàng</th>
</tr>
</thead>

<tbody>
     <c:forEach items="${orders}" var="o">
        <tr style="margin: 8px 0;">
            <td>| ${o.user.username}</td>
            <td>| ${o.address}</td>
            <td>| ${o.paidBefore?'Đã thanh toán':'Chưa thanh toán'}</td>
            
            <c:set var = "s" value = "${o.status}"/>
            <c:choose>
                <c:when test="${s=='not_processed'}">
                    <td>| Chờ xử lý</td>												
                </c:when>
                <c:when test="${s=='processing'}">
                    <td>| Đang xử lý</td>									
                </c:when>
                <c:when test="${s=='shipped'}">
                    <td>| Đang giao</td>									
                </c:when>	
                <c:when test="${s=='delivered'}">
                    <td>| Đã giao</td>									
                </c:when>	
                <c:when test="${s=='cancelled'}">
                    <td>| Đã hủy</td>									
                </c:when>										
            </c:choose>
            <td>| <a href="/vendor/order/detail/${o.orderId}">Chi tiết</a></td>
        </tr>
    </c:forEach>
</tbody>
</table>