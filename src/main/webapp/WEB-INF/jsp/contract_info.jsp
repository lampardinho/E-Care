<%--
  Created by IntelliJ IDEA.
  User: Kolia
  Date: 08.07.2015
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Contract info</h3>
<p style="font-size:120%">
	Balance: <%= session.getAttribute("email") %>
	<p class="text-right">
		<button type="button" class="btn btn-danger btn-lg">Block contract</button>
	</p>
</p>
