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
		<link rel="icon" href="../../img/favicon.ico">

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
							<ul class="nav navbar-nav">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= currentContract.getPhoneNumber() %><span class="caret"></span></a>
									<ul class="dropdown-menu">
										<c:forEach var="contract" items="${contracts}">
											<li><a href="#">${contract.phoneNumber}</a></li>
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



				<div id="contract_info">
					<h3>Contract info</h3>
					<p style="font-size:120%">
						Balance: <%= session.getAttribute("email") %>
					<p class="text-right">
						<button type="button" class="btn btn-danger btn-lg">Block contract</button>
					</p>
					</p>
				</div>



				<div id="options">
					<h3>Options</h3>
					<ul class="list-group">
						<c:forEach var="option" items="${options}">
							<c:choose>
								<c:when test="${currentContract.selectedOptions.contains(option)}">
									<a href="#" class="list-group-item list-group-item-success">
										<p  style="font-size:120%" class="list-group-item-text">${option.name}</p>
										<p  style="font-size:120%" class="list-group-item-text">Connection price: ${option.connectionPrice}</p>
										<p  style="font-size:120%" class="list-group-item-text">Monthly price: ${option.monthlyPrice}</p>
									</a>
								</c:when>
								<c:when test="${disabledOptions.contains(option)}">
									<a href="#" class="list-group-item disabled">
										<p  style="font-size:120%" class="list-group-item-text">${option.name}</p>
										<p  style="font-size:120%" class="list-group-item-text">Connection price: ${option.connectionPrice}</p>
										<p  style="font-size:120%" class="list-group-item-text">Monthly price: ${option.monthlyPrice}</p>
									</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="list-group-item">
										<p  style="font-size:120%" class="list-group-item-text">${option.name}</p>
										<p  style="font-size:120%" class="list-group-item-text">Connection price: ${option.connectionPrice}</p>
										<p  style="font-size:120%" class="list-group-item-text">Monthly price: ${option.monthlyPrice}</p>
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>




				<div id="tariffs">
					<h3>Tariffs</h3>
					<ul class="list-group">
						<c:forEach var="tariff" items="${tariffs}">
							<c:choose>
								<c:when test="${tariff == currentTariff}">
									<a href="#" class="list-group-item active">
										<p  style="font-size:120%" class="list-group-item-text">${tariff.name}</p>
										<p  style="font-size:120%" class="list-group-item-text">Price: ${tariff.price}</p>
									</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="list-group-item">
										<p  style="font-size:120%" class="list-group-item-text">${tariff.name}</p>
										<p  style="font-size:120%" class="list-group-item-text">Price: ${tariff.price}</p>
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
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

