<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.regex.Pattern" %><%--
  Created by IntelliJ IDEA.
  User: Ania
  Date: 25.05.2019
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<footer>
    <div>
        <span>Autor: Anna</span>
        <span><%= LocalDateTime.now()%></span>
    </div>
</footer>
