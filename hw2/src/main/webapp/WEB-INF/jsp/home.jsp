<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome Page</title>
</head>
<body>

<h2 align="center">Welcome to Children database management system</h2>
<br />
<table align="center">

    <tr>
        <td>To view all children:</td>
        <td><input type="button" value="See all children"
                   onclick="window.location.href='resultChildren'" /></td>
    </tr>
    <tr>
        <td>To see all children in sections:</td>
        <td><input type="button" value="Children in sections"
                   onclick="window.location.href='Sections.jsp'" /></td>
    </tr>
    <tr>
        <td>To add new child into the database:</td>
        <td><input type="button" value="Insert data"
                   onclick="window.location.href='Insert.jsp'" /></td>
    </tr>
    <tr>
        <td>To delete details from the database:</td>
        <td><input type="button" value="Delete data"
                   onclick="window.location.href='Delete.jsp'" /></td>
    </tr>
    <tr>
        <td>To update details in the database:</td>
        <td><input type="button" value="Select data"
                   onclick="window.location.href='Update.jsp'" /></td>
    </tr>
</table>

</body>


</html>

