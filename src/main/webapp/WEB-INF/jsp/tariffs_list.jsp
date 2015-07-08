<%--
  Created by IntelliJ IDEA.
  User: Kolia
  Date: 06.07.2015
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Tariffs</h3>
<ul class="list-group">
	<c:forEach var="tariff" items="${tariffs}">
		<a href="#" class="list-group-item">
			<p  style="font-size:120%" class="list-group-item-text">${tariff.name}</p>
			<p  style="font-size:120%" class="list-group-item-text">Price: ${tariff.price}</p>
		</a>
	</c:forEach>

	<a href="#" class="list-group-item active">
		<p  style="font-size:120%" class="list-group-item-text">tariff name</p>
		<p  style="font-size:120%" class="list-group-item-text">Price:</p>
	</a>

</ul>
