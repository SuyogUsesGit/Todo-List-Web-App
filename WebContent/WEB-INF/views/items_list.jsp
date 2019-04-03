<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:url var="addUrl" value="addItem"/>
    	<a href="${addUrl}">Click here to Add New Item</a>
		<table border="1" cellpadding="5">
			<caption><h2>ToDo Items</h2></caption>
			
			<tr>
				<th>Title</th>
				<th>Deadline</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach var="item" items="${myList}">
				
				<c:url var="viewUrl" value="viewItem">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="editUrl" value="addItem">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="deleteUrl" value="deleteItem">
                    <c:param name="id" value="${item.id}"/>
                 </c:url>
				
				<tr>
					<td><c:out value="${item.title}"/></td>
					<td><c:out value="${item.date}"/></td>		
					<td><a href="${viewUrl}">View</a></td>
					<td><a href="${editUrl}">Edit</a></td>				
					<td><a href="${deleteUrl}">Delete</a></td>								
				</tr>
				
			</c:forEach>
			
		</table>
	</div>
</body>
</html>