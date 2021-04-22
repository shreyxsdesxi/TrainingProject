<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<a class="navbar-brand" href="#"
			style="color: white; margin-left: 20px">Generic Insurance Website</a>
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
				<li class="nav-item"><a class="nav-link" href="/logout"
					style="color: white;">Logout</a></li>
				<li class="nav-item"><a class="nav-link" href="/viewAllClaims"
					style="color: white;">View Claims</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		
		<h2>Claims</h2>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Sr. No</th>
					<th>Claim ID</th>
					<th>Policy ID</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${claims}" var="item" varStatus="loop">
					<tr>
						<td>${loop.index + 1 }</td>
						<td>${item.claimNumber }</td>
						<td>${item.policyNumber }</td>
						<td><a class="btn btn-warning" href="/getClaimStatus/${item.policyNumber}/${item.claimNumber}">View Status</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>