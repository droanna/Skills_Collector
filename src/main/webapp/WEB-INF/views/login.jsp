<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ania
  Date: 25.05.2019
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<h1>Logowanie</h1>
<form method="post" action="/login" action="/logout">
    <p>Nazwa uzytkownika: <input type="text" name="username" required/>
    <p>Hasło: <input type="text" name="password" required/></p>
    <c:if test="${error != null}">
        <p style="color: red">${error}</p>
    </c:if>
    <p><input type="submit" value="Zaloguj"></p>
</form>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
