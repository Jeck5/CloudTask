<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Информация о событиях </title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
</head>
<body>
<br>
	<header>
		<hgroup>
			<h1>
				Список из ${forms.size()} самых используемых форм
			</h1>
		</hgroup>
	</header>
	<nav>

		<table class="table table-striped">
			<thead class="thead-dark">
			<tr>
				<th class="col-md-1" scope="col">Форма</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${forms}" var="form">
				<tr>
					<td><c:out value="${form}" /></td>
				</tr>
			</c:forEach>
			</tbody>
			<tbody>
		</table>

	</nav>


</body>
</html>