<%--
  User: Kolia
  Date: 01.07.2015
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="../img/favicon.ico">

		<title>Client lobby</title>

		<!-- Bootstrap core CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="../css/navbar.css" rel="stylesheet">


	</head>

	<body>

		<div class="container">

			<!-- Static navbar -->
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>--%>
						<a class="navbar-brand" href="#">E-Care</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Select contract<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">5234535</a></li>
									<li><a href="#">521341234</a></li>
									<li><a href="#">673635356</a></li>
								</ul>
							</li>
						</ul>
						<p class="navbar-text">Current contract: 32423434</p>
						<div class="navbar-right">
							<p class="navbar-text"><%= request.getParameter("email") %></p>

							<button type="button" class="btn btn-default navbar-btn">Sign out</button>
						</div>

					</div><!--/.nav-collapse -->
				</div><!--/.container-fluid -->
			</nav>

			<!-- Main component for a primary marketing message or call to action -->
			<div class="jumbotron">

				<h3>Options</h3>
				<ul class="list-group">
					<a href="#" class="list-group-item">
						<p class="list-group-item-text">option name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
					<a href="#" class="list-group-item list-group-item-success">
						<p class="list-group-item-text">option name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
					<a href="#" class="list-group-item">
						<p class="list-group-item-text">option name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
					<a href="#" class="list-group-item disabled">
						<p class="list-group-item-text">option name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
					<a href="#" class="list-group-item">
						<p class="list-group-item-text">option name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
				</ul>

				<h3>Tariffs</h3>
				<ul class="list-group">
					<a href="#" class="list-group-item">
						<p class="list-group-item-text">tariff name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
					<a href="#" class="list-group-item active">
						<p class="list-group-item-text">tariff name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
					<a href="#" class="list-group-item">
						<p class="list-group-item-text">tariff name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
					<a href="#" class="list-group-item">
						<p class="list-group-item-text">tariff name</p>
						<p class="list-group-item-text">Price:</p>
					</a>
				</ul>
			</div>

		</div> <!-- /container -->


		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	</body>
</html>

