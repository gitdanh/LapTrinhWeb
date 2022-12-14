<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<nav class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#"><img src="/templates/images/boker-high-resolution-logo-color-on-transparent-background.png" width="65" height="auto"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#"> <i
					class="fa fa-home"></i> Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fa fa-envelope-o"> <span class="badge badge-danger">11</span>
				</i> Your Store
			</a></li>
			<li class="nav-item"><a class="nav-link " href="#"> <i
					class="fa fa-envelope-o"> <span class="badge badge-warning">11</span>
				</i> Dash Board
			</a></li>
		</ul>
		<ul class="navbar-nav ">
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fa fa-bell"> <span class="badge badge-info">11</span>
				</i> Order
			</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="text" placeholder="Search"
				aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>