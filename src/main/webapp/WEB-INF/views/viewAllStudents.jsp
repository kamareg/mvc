<%--
  Created by IntelliJ IDEA.
  User: Malikova
  Date: 04.07.2022
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Students info</title>
    <link href="css/demo.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>Students info:</h2>
<table border="1" cellspacing="10", cellpadding="10">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Group</th>
        <th>Edit</th>
        <th>Remove</th>
    </tr>

    <c:forEach var="student" items="${listOfStudents}">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.age}</td>
        <td>${student.group}</td>
        <td><a href="/app/students/editStudent/${student.id}">Edit</a></td>
        <td><a href="/app/students/removeStudent/${student.id}">Remove</a></td>

    </tr>
    </c:forEach>
</table>
<p><a href="/app/students/addStudent">Add student</a></p>
</body>
</html>
