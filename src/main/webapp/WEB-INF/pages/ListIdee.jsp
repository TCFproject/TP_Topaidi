<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Vous êtes connecté <c:out value="${test}"></c:out> </p>
	<form action="" method="post">
		<input type="text" name="description" placeholder="description">
		<input type="text" name="url" placeholder="url">
		<input type="text" name="titre" placeholder="titre">
		<select name="cathegorie">
			<c:forEach items="${cathe}" var="uneCathe">
				<option><c:out value="${uneCathe.getLibelle()}"/></option>
			</c:forEach> 
		</select>
		<input type="submit">
	</form>
	<ul>
		<c:forEach items="${listIdee}" var="idee">
			<li> <c:out value="${idee.getTitre()}"></c:out> </li>
		</c:forEach>
	</ul>
</body>
</html>