<%--
  Created by IntelliJ IDEA.
  User: Bohdan
  Date: 29.09.2020
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="Content"/>

<html lang="${language}">
<head>
    <title>Main page</title>
</head>
<body>
<div class="container">
    <button onclick="location.href='/login.jsp'"><fmt:message key="login"/></button>
    <button onclick="location.href='/registration'"><fmt:message key="login"/></button>
    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        </select>
    </form>
</div>
<h1><fmt:message key="hospital"/></h1>
<h3><fmt:message key="home"/></h3>
</body>
</html>