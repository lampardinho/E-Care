<%--
  Created by IntelliJ IDEA.
  User: Kolia
  Date: 06.07.2015
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav navbar-nav">
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Select contract<span class="caret"></span></a>
		<ul class="dropdown-menu">
			<c:forEach var="contract" items="${contracts}">
				<li><a href="#">${contract.phoneNumber}</a></li>
			</c:forEach>
		</ul>
	</li>
</ul>
