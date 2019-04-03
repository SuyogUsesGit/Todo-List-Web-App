<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List TodoItems using Service</title>
</head>
<body>
	<h1>Listing TodoItems using Service</h1>
	
	<c:forEach var="row" items="${todolist}">
		id: ${row.id} <br/>
		Title: ${row.title} <br/>
		Details: ${row.details} <br/>
		Date: ${row.date} <br/><br/>
	</c:forEach>>
</body>
</html>