<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<%--	<link rel="stylesheet" href="resources/css/custom.css">--%>
	<title>Информация о событиях </title>
</head>
<body>
<br>
	<header>
		<hgroup>
			<h1>
				Список пользователей, которые начали активность на форме и не дошли до конца
			</h1>
		</hgroup>
	</header>
	<nav>

		<table class="table table-striped">
			<thead  class="thead-dark">
				<tr>
					<th class="col-md-1" scope="col">Пользователь</th>
					<th class="col-md-1" scope="col">Последний шаг</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.getSsoID()}" /></td>
					<td><c:out value="${user.getSubtype()}" /></td>
				</tr>
			</c:forEach>
			</tbody>
			<tbody>
		</table>

	</nav>


</body>
</html>