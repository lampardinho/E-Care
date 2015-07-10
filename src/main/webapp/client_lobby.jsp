<%@ page import="com.tsystems.javaschool.ecare.entities.User" %>
<%@ page import="com.tsystems.javaschool.ecare.services.UserService" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.tsystems.javaschool.ecare.entities.Contract" %>
<%@ page import="com.tsystems.javaschool.ecare.services.ContractService" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  User: Kolia
  Date: 01.07.2015
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="img/favicon.ico">

		<title>Client lobby</title>

		<!-- Bootstrap core CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="/css/ecare.css" rel="stylesheet">


	</head>

	<body class="navbar-body">

		<%
			User user = (User)session.getAttribute("user");
			List<Contract> contracts = (List<Contract>)session.getAttribute("contracts");
			Contract currentContract = (Contract) session.getAttribute("currentContract");

		%>


		<div class="container">

			<!-- Static navbar -->
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">E-Care</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">


						<div id="contracts">
							<p class="navbar-text" >Select contract:</p>
							<ul class="nav navbar-nav">
								<li class="dropdown">
									<a class="dropdown-toggle" id="current_contract" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= currentContract.getPhoneNumber() %></a>
									<ul class="dropdown-menu">
										<c:forEach var="contract" items="${contracts}">
											<li><a href="#" class="contracts">${contract.phoneNumber}</a></li>
										</c:forEach>
									</ul>
								</li>
							</ul>
						</div>


						<div class="navbar-right">
							<p class="navbar-text" id="user"><%= user.getEmail() %></p>

							<button type="button" class="btn btn-default navbar-btn" id="logout">Sign out</button>
						</div>

					</div><!--/.nav-collapse -->
				</div><!--/.container-fluid -->
			</nav>

			<!-- Main component for a primary marketing message or call to action -->
			<div id="content" class="jumbotron">

				<%
					user = (User)session.getAttribute("user");
					contracts = (List<Contract>)session.getAttribute("contracts");
					currentContract = (Contract) session.getAttribute("currentContract");

				%>

				<div id="contract_info" class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Contract info</h3>
					</div>
					<div class="panel-body">
						<p >
							Balance: <%= currentContract.getBalance() %>
						</p>
						<p >
							Owner: <%= currentContract.getUser().getName() + " " + currentContract.getUser().getSurname()%>
						</p>
						<p class="text-right">

							<button class="btn btn-primary btn-lg" type="button" data-toggle="modal" data-target="#myModal">
								<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
								<span class="badge">4</span>
							</button>

							<button type="button" class="btn btn-danger btn-lg">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>Block contract
							</button>


							<!-- Modal -->
						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Actions history</h4>
									</div>
									<div class="modal-body">
										<c:forEach var="tariff" items="${tariffs}">
											<a href="#" class="list-group-item">
												<p   class="list-group-item-text">${tariff.name}</p>
												<p   class="list-group-item-text">Price: ${tariff.price}</p>
											</a>
										</c:forEach>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-success">Apply</button>
										<button type="button" class="btn btn-warning">Cancel</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									</div>
								</div>

							</div>
						</div>
						</p>

					</div>
				</div>



				<div id="options" class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Options</h3>
					</div>
					<div class="panel-body">

						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Name</th>
									<th>Connection price</th>
									<th>Monthly price</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="option" items="${options}">
									<c:choose>
										<c:when test="${currentContract.selectedOptions.contains(option)}">
											<tr class="success">
										</c:when>
										<c:when test="${disabledOptions.contains(option)}">
											<tr class="danger">
										</c:when>
										<c:otherwise>
											<tr>
										</c:otherwise>
									</c:choose>
										<th scope="row">1</th>
										<td>${option.name}</td>
										<td>${option.connectionPrice}</td>
										<td>${option.monthlyPrice}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<strong>Warning!</strong> Better check yourself, you're not looking too good.
				</div>


				<div id="tariffs" class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Tariffs</h3>
					</div>
					<div class="panel-body">

						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Name</th>
									<th>Price</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="tariff" items="${tariffs}">
									<c:choose>
										<c:when test="${tariff == currentTariff}">
											<tr class="success">
										</c:when>
										<c:otherwise>
											<tr>
										</c:otherwise>
									</c:choose>
										<th scope="row">1</th>
										<td>${tariff.name}</td>
										<td>${tariff.price}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>

		</div> <!-- /container -->


		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="/js/ecare.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	</body>
</html>

