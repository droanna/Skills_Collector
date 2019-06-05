<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ania
  Date: 05.06.2019
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User-skills</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<h1>Your skills</h1>
<table>
    <tr>
        <td>Lp.</td>
        <td>Umiejętność</td>
        <td>Poziom umiejętności</td>
    </tr>
    <tr>
        <c:forEach items="${skills}">
            <td>${stat.count}.</td>
            <td>${skills.entry.key.name}</td>
            <td>${skills.entry.value}</td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
