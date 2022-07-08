<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.07.2022
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add new student</title>
</head>
<body>
<h1>Add new student</h1>
<form:form action="/app/students/saveStudent" method="post">
<table>
    <tr>
        <td>Enter ID: </td>
        <td><form:input path="id"/> </td>
    </tr>
    <tr>
        <td>Enter name: </td>
        <td><form:input path="name"/> </td>
    </tr>
    <tr>
        <td>Enter age: </td>
        <td><form:input path="age"/> </td>
    </tr>
    <tr>
        <td>Enter group: </td>
        <td><form:input path="group"/> </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save student"/> </td>
    </tr>
</table>
</form:form>
</body>
</html>
