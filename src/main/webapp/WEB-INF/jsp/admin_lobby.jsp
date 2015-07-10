<%@ page import="com.tsystems.javaschool.ecare.entities.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Kolia
  Date: 01.07.2015
  Time: 21:23
  To change this template use File | Settings | File Templates.
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
		<link rel="icon" href="../../img/favicon.ico">

		<title>Admin lobby</title>

		<!-- Bootstrap core CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="../../css/navbar.css" rel="stylesheet">


	</head>

	<body>

		<%
			User user = (User)session.getAttribute("user");
		%>


		<div class="container">

			<!-- Static navbar -->
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">E-Care</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">

						<div class="navbar-right">
							<p class="navbar-text"><%= user.getEmail() %></p>

							<button type="button" class="btn btn-default navbar-btn">Sign out</button>
						</div>

						<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
							<li class="active"><a href="#clients" data-toggle="tab">Clients</a></li>
							<li><a href="#contracts" data-toggle="tab">Contracts</a></li>
							<li><a href="#tariffs" data-toggle="tab">Tariffs</a></li>
							<li><a href="#options" data-toggle="tab">Options</a></li>
						</ul>

					</div><!--/.nav-collapse -->
				</div><!--/.container-fluid -->
			</nav>


			<!-- Main component for a primary marketing message or call to action -->
			<div id="content" class="jumbotron">
				<div id="my-tab-content" class="tab-content">

					<div class="tab-pane active" id="clients">
						<div id="clients_info" class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">Clients</h3>
							</div>
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Birth Date</th>
											<th>Passport</th>
											<th>Address</th>
											<th>E-mail</th>
											<th>Privileges</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="option" items="${options}">
											<tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Otto</td>
												<td>@mdo</td>
												<td>@mdo</td>
												<td>@mdo</td>
												<td>@mdo</td>
												<td>@mdo</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<br>
								<form class="form-inline">
									<div class="form-group">
										<label for="searchEmail">Phone number</label>
										<input type="text" class="form-control" id="searchEmail" placeholder="123456">
									</div>
									<button type="submit" class="btn btn-default" id="searchUser">Search</button>
								</form>

								<br>
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUser">Add user</button>

								<!-- Modal -->
								<div class="modal fade" id="addUser" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">New Client</h4>
											</div>
											<div class="modal-body">

												<form class="form-horizontal">
													<div class="form-group">
														<label for="user_firstName" class="col-sm-2 control-label">First name</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="user_firstName" placeholder="First name">
														</div>
													</div>
													<div class="form-group">
														<label for="user_lastName" class="col-sm-2 control-label">Last name</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="user_lastName" placeholder="Last name">
														</div>
													</div>
													<div class="form-group">
														<label for="user_birthDate" class="col-sm-2 control-label">Birth date</label>
														<div class="col-sm-10">
															<input type="date" class="form-control" id="user_birthDate" placeholder="Birth date">
														</div>
													</div>
													<div class="form-group">
														<label for="user_password" class="col-sm-2 control-label">Password</label>
														<div class="col-sm-10">
															<input type="password" class="form-control" id="user_password" placeholder="Password">
														</div>
													</div>
													<div class="form-group">
														<label for="user_address" class="col-sm-2 control-label">Address</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="user_address" placeholder="Address">
														</div>
													</div>
													<div class="form-group">
														<label for="user_email" class="col-sm-2 control-label">E-mail</label>
														<div class="col-sm-10">
															<input type="email" class="form-control" id="user_email" placeholder="E-mail">
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<div class="checkbox">
																<label>
																	<input type="checkbox"> Admin
																</label>
															</div>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-success">Create user</button>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>



					<div class="tab-pane" id="contracts">
						<div id="contracts_info" class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">Contracts</h3>
							</div>
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>Phone Number</th>
											<th>Owner</th>
											<th>Balance</th>
											<th>Tariff</th>
											<th>Options</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="option" items="${options}">
											<tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Otto</td>
												<td>@mdo</td>
												<td>@mdo</td>
												<td>@mdo</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>


								<br>
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newContract">Add Contract</button>

								<!-- Modal -->
								<div class="modal fade" id="newContract" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">New Contract</h4>
											</div>
											<div class="modal-body">

												<form class="form-horizontal">
													<div class="form-group">
														<label for="owner" class="col-sm-2 control-label">Owner</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="owner" placeholder="Owner">
														</div>
													</div>
													<div class="form-group">
														<label for="phoneNumber" class="col-sm-2 control-label">Phone number</label>
														<div class="col-sm-10">
															<input type="tel" class="form-control" id="phoneNumber" placeholder="Phone number">
														</div>
													</div>
													<div class="form-group">
														<label for="balance" class="col-sm-2 control-label">Balance</label>
														<div class="col-sm-10">
															<input type="number" class="form-control" id="balance" placeholder="Balance">
														</div>
													</div>
													<div class="form-group">
														<label for="tariff" class="col-sm-2 control-label">Tariff</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="tariff" placeholder="Tariff">
														</div>
													</div>
													<div class="form-group">
														<label for="address" class="col-sm-2 control-label">Address</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="address" placeholder="Address">
														</div>
													</div>
													<div class="form-group">
														<label for="avail_options" class="col-sm-2 control-label">Options</label>
														<div class="col-sm-10">
															<input type="email" class="form-control" id="avail_options" placeholder="Options">
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-success">Create contract</button>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>

								<!-- Modal -->
								<div class="modal fade" id="editContract" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Edit Contract</h4>
											</div>
											<div class="modal-body">

												<form class="form-horizontal">
													<div class="form-group col-sm-10 col-sm-offset-2">
														<label>Tariff</label>
														<c:forEach var="option" items="${options}">
															<div class="radio">
																<label><input type="radio" name="optradio">Tariff 1</label>
															</div>
														</c:forEach>
													</div>
													<div class="form-group col-sm-10 col-sm-offset-2">
														<label>Selected options</label>
														<c:forEach var="option" items="${options}">
															<div class="checkbox">
																<label><input type="checkbox" value="">Option one is this and that</label>
															</div>
														</c:forEach>
													</div>

													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-success">Edit contract</button>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>



					<div class="tab-pane" id="tariffs">
						<div id="tariffs_info" class="panel panel-info">
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
											<th>Available Options</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="option" items="${options}">
											<tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Otto</td>
												<td>@mdo</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<br>
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newTariff">Add Tariff</button>

								<!-- Modal -->
								<div class="modal fade" id="newTariff" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">New Tariff</h4>
											</div>
											<div class="modal-body">

												<form class="form-horizontal">
													<div class="form-group">
														<label for="tariffName" class="col-sm-2 control-label">Name</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="tariffName" placeholder="Name">
														</div>
													</div>
													<div class="form-group">
														<label for="tariffPrice" class="col-sm-2 control-label">Price</label>
														<div class="col-sm-10">
															<input type="number" class="form-control" id="tariffPrice" placeholder="Price">
														</div>
													</div>
													<div class="form-group">
														<label for="tariffOptions" class="col-sm-2 control-label">Available options</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="tariffOptions" placeholder="Available options">
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-success">Create tariff</button>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>

								<!-- Modal -->
								<div class="modal fade" id="editTariff" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Edit Tariff</h4>
											</div>
											<div class="modal-body">

												<form class="form-horizontal">
													<div class="form-group col-sm-10 col-sm-offset-2">
														<label>Available options</label>
														<c:forEach var="option" items="${options}">
															<div class="checkbox">
																<label>
																	<input type="checkbox" value="">
																	Option one is this and that
																</label>
															</div>
														</c:forEach>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-success">Edit tariff</button>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-danger" data-dismiss="modal">Delete</button>
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>



					<div class="tab-pane" id="options">
						<div id="options_info" class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">Options</h3>
							</div>
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>Name</th>
											<th>Connection Price</th>
											<th>Monthly Price</th>
											<th>Locked Options</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="option" items="${options}">
											<tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Mark</td>
												<td>Otto</td>
												<td>@mdo</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<!-- Modal -->
								<div class="modal fade" id="editOption" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Edit Option</h4>
											</div>
											<div class="modal-body">

												<form class="form-horizontal">
													<div class="form-group col-sm-10 col-sm-offset-2">
														<label>Locked options</label>
														<c:forEach var="option" items="${options}">
															<div class="checkbox">
																<label>
																	<input type="checkbox" value="">
																	Option one is this and that
																</label>
															</div>
														</c:forEach>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-success">Edit option</button>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
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
