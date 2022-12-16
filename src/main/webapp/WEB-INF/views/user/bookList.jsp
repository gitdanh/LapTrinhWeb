<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box grey-cascade">
					<div class="portlet-title">
						<div
							class="caption d-flex justify-content-center align-items-center">
							<i class="fa fa-globe"></i>Quản lý Category
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<!-- Hiển thị thông báo -->
							<%-- <%@include file="/common/info.jsp"%> --%>
							<!-- Kết thúc hiển thị thông báo -->
							<div class="row mt-2 mb-2">
								<div class="col-md-6">
									<form action="/list">
										<div class="input-group">
											<input type="text" class="form-control ml-2" name="name"
												id="name" placeholder="Nhập để tìm kiếm">
											<button class="btn btn-outline-primary ml-2">Search
											</button>
										</div>
								</div>
								<table class="table table-striped table-responsive">
									<thead class="thear-inverse">
										<tr>
											<th>Book Name</th>
											<th>Author</th>
											<th>Sold</th>
											<th>Price</th>
											<th>Sale</th>
											<th>Rating</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${books}" var="book">
											<tr>
												<td>${book.bookName}</td>
												<td>${book.author}</td>
												<td>${book.sold}</td>
												<td>${book.price}</td>
												<td>${book.promotionalPrice}</td>
												<td>${book.rating}</td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item"><a class="page-link" href="#">Previous</a></li>
										<li class="page-item"><a class="page-link" href="#">1</a></li>
										<li class="page-item"><a class="page-link" href="#">2</a></li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#">Next</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
	</div>
</div>