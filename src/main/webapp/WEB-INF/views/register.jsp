<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ania
  Date: 25.05.2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<html>

<head>
    <title>Rejestracja</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<h1>Rejestracja</h1>
<form method="post" action="/register">
    <p>Nazwa uzytkownika: <input type="text" name="username" required/>
        <c:if test="${error != null}">
            <span style="color: red">${error}</span>
        </c:if>

    </p>

    <p>Hasło: <input type="text" name="password" required/></p>
    <p>Imię: <input type="text" name="firstName"/></p>
    <p>Nazwisko: <input type="text" name="lastName"/></p>
    <p><input type="submit" value="Zarejestruj"></p>

</form>

<jsp:include page="fragments/footer.jsp"/>
</body>

</html>
