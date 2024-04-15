<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<% List eList = (List)session.getAttribute("user");
    request.setAttribute("eList", eList);
%>
<html xmlns:th="http://www.thymeleaf.org">


<head>
    <title>Web Application</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>

<p>
    <span th:text="List of Users"></span>
</p>

<div>
    <table>
        <tr>
            <th>Name</th>
            <th>User Name</th>
            <th>Password</th>
            <th>Email</th>
        </tr>

        <c:forEach items="${eList}" var="userInfo">
            <tr>
                <td>${userInfo.name}</td>
                <td>${userInfo.username}</td>
                <td>${userInfo.password}</td>
                <td>${userInfo.emal}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/logout">logout</a>
</div>
</body>


</html>