<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert Details</title>
</head>
<body>

<h2>Add New Child</h2>

<form action="/AddNewChild" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" maxlength="30" size="25" /></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input type="text" name="surname" maxlength="40" size="35" /></td>
        </tr>
        <tr />
    </table>
    <br /> <input type="submit" value="Insert Data" />
</form>
<br />
<input type="button" value="Return to Home"
       onclick="window.location.href='home.jsp'" />
</body>

</html>
