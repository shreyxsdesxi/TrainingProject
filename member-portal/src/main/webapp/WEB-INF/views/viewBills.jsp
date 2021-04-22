<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bills</title>
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
				<li class="nav-item"><a class="nav-link" href="#" style="color: white;">Features</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true" style="color: white;">Disabled</a></li>-->
				<li class="nav-item"><a class="nav-link" href="/logout" style="color: white;">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
	<h2>Premium Details</h2>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td><b>Firstname</b></td>
				<td>${result.members.firstname}</td>
			</tr>
			<tr>
				<td><b>Lastname</b></td>
				<td>${result.members.lastname}</td>
			</tr>
			<tr>
				<td><b>Email</b></td>
				<td>${result.members.email}</td>
			</tr>
			<tr>
				<td><b>Age</b></td>
				<td>${result.members.age}</td>
			</tr>
			<tr>
				<td><b>Policy ID</b></td>
				<td>${result.policyId}</td>
			</tr>
			<tr>
				<td><b>Amount</b></td>
				<td>${result.amount}</td>
			</tr>
			<tr>
				<td><b>Due Date</b></td>
				<td>${result.due}</td>
			</tr>
			<tr>
				<td><b>Last Paid Date</b></td>
				<td>${result.lastPaidDate}</td>
			</tr>
			<tr>
				<td><b>Late Payment Charges</b></td>
				<td>${result.latePaymentCharges}</td>
			</tr>
			<tr>
				<td colspan="2"><a class="btn btn-success">Pay Premium</a></td>
			</tr>
		</tbody>
	</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
</body>
</html>