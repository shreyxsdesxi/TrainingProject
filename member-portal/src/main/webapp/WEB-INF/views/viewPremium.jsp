<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Premium</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	<style>
		.container {
			margin-top: 100px;
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<a class="navbar-brand" href="#" style="color: white; margin-left: 20px">Generic Insurance Website</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<!--  <li class="nav-item active"><a class="nav-link" href="#" style="color: white;">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#" style="color: white;"></a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true" style="color: white;">Disabled</a></li>-->
				<li class="nav-item"><a class="nav-link" href="/logout" style="color: white;">Logout</a></li>
				<li class="nav-item"><a class="nav-link" href="/viewAllClaims" style="color: white;">View Claims</a></li>
				<li class="nav-item active"><a class="nav-link" href="/submitClaim" style="color: white;">Submit Claim</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2>Premium</h2>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Policy Id</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${result}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.policyId}</td>
						<td><a class="btn btn-primary"
							href="/viewBills/${item.policyId}">View Details</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
</body>
</html>