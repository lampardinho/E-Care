<%--
  Created by IntelliJ IDEA.
  User: Kolia
  Date: 06.07.2015
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Options</h3>
<ul class="list-group">
	<c:forEach var="option" items="${options}">
		<a href="#" class="list-group-item">
			<p class="list-group-item-text">${option.name}</p>
			<p class="list-group-item-text">Connection price: ${option.connectionPrice}</p>
			<p class="list-group-item-text">Monthly price: ${option.monthlyPrice}</p>
		</a>
	</c:forEach>

	<a href="#" class="list-group-item list-group-item-success">
		<p class="list-group-item-text">option name</p>
		<p class="list-group-item-text">Price:</p>
	</a>

	<a href="#" class="list-group-item disabled">
		<p class="list-group-item-text">option name</p>
		<p class="list-group-item-text">Price:</p>
	</a>
</ul>
