<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Children List</title>
</head>
<body>
<h1>Children List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <c:forEach var="child" items="${childList}">
        <tr>
            <td>${child.id}</td>
            <td>${child.name}</td>
            <td>${child.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
