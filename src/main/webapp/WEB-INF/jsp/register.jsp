<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Content"/>

<!DOCTYPE html>
<html lang="${language}" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <meta charset="utf-8">
    <title>Hospital | Registration</title>
</head>

<body class="red lighten-2">
<div class="row">
    <div class="col m6 offset-m3 l4 offset-l4 s12">
        <div class="card-panel z-depth-5" style="min-height: 90vh; margin-top: 4vh; position: relative">
            <div class="valign-wrapper">
                <form action="${pageContext.request.contextPath}/register" method="POST" class="center-block" style="text-align: center">
                    <h1><fmt:message key="register"/></h1>
                    <% if (request.getAttribute("bad_getaway") != null ) {%>
                    <p class="red-text"><fmt:message key="incorrectRegister" /></p>
                    <% } %>
                    <div class="input-field" style="margin-top: 40px">
                        <i class="material-icons prefix">account_circle</i>
                        <input type="text" id="name" name="name" >
                        <label for="name"><fmt:message key="name"/></label>
                    </div>
                    <div class="input-field" >
                        <i class="material-icons prefix">account_circle</i>
                        <input type="text" id="surname" name="surname">
                        <label for="surname"><fmt:message key="surname"/></label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">email</i>
                        <input type="email" id="email" name="email">
                        <label for="email"><fmt:message key="email"/></label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">date_range</i>
                        <input type="text" id="birthday" name="birthday">
                        <label for="birthday"><fmt:message key="birthday"/></label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">lock</i>
                        <input type="password" id="password" name="password">
                        <label for="password"><fmt:message key="pass"/></label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">vpn_key</i>
                        <input type="password" id="confirm-password" name="confirm-password">
                        <label for="confirm-password"><fmt:message key="repeatPass"/></label>
                    </div>
                    <div class="left-align" style="margin-left: 1vh">
                        <p><strong><fmt:message key="chooseTypeAcc"/></strong></p>
                        <div class="input-field">
                            <p>
                                <label>
                                    <input class="with-gap" name="role" type="radio" value="1" checked />
                                    <span><fmt:message key="patients"/></span>
                                </label>
                            </p>
                            <p>
                                <label>
                                    <input class="with-gap" name="role" type="radio" value="2" />
                                    <span><fmt:message key="doctors"/></span>
                                </label>
                            </p>
                            <p>
                                <label>
                                    <input class="with-gap" name="role" type="radio" value="3" />
                                    <span><fmt:message key="admins"/></span>
                                </label>
                            </p>
                        </div>
                    </div>
                    <p><fmt:message key="haveAccount"/> <a href="${pageContext.request.contextPath}/login"><fmt:message key="login"/></a></p>
                    <div class="input-field center">
                        <button class="btn-large purple darken-4" type="submit"><fmt:message key="createAccount"/></button>
                    </div>
                </form>
                <a style="position: absolute; bottom: 2%" href="${pageContext.request.contextPath}/"><fmt:message key="home"/> </a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>


