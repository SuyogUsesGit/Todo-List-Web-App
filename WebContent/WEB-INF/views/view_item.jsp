<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Items</title>
</head>

<body>
    <div align="center">
        <table>
             <tr>
                 <td><label>ID</label></td>
                 <td>
                    <c:out value="${todoItem.id}"/>
                 </td>
             </tr>
             <tr>
                 <td><label>Title</label></td>
                 <td>
                    <c:out value="${todoItem.title}"/>
                 </td>
             </tr>
             <tr>
                 <td><label>Deadline</label></td>
                 <td>
                    <c:out value="${todoItem.date}"/>
                 </td>
             </tr>
             <tr>
                 <td><label>Details</label></td>
                 <td>
                    <c:out value="${todoItem.details}"/>
                 </td>
             </tr>

        </table>

        <c:url var="tableUrl" value="showList"/>
        <a href="${tableUrl}">Show Items</a>

    </div>
</body>

</html>