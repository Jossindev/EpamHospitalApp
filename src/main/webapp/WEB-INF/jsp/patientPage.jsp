<%@ page import="model.entity.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Content"/>

<html lang="${language}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <title>Patient Page</title>
    <style>
        body {
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }
        main {
            flex: 1 0 auto;
        }
    </style>
</head>
<body>
<jsp:include page="element/header.jsp" />

<%Patient patient = (Patient) request.getAttribute("currentPatient"); %>
<main>
    <div class="container">
        <ul class="collection with-header">
            <li class="collection-header"><h4><%= patient.getUser().getName() %><a href="#" class="btn right red darken-4"><fmt:message key="hospitalCard" /></a></h4> </li>
            <li class="collection-item ">
                <span class="title"><%= patient.getUser().getName() %></span>
                <p><%= patient.getUser().getSurname() %></p>
                <p><%= patient.getUser().getBirthday() %></p>
            </li>
        </ul>
    </div>
</main>

<jsp:include page="element/footer.jsp" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function(){
        $('select').formSelect();
        $('.sidenav').sidenav();
    });
</script>
</body>
</html>
