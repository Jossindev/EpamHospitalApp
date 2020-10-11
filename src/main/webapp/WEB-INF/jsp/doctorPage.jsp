<%@ page import="model.entity.Doctor" %>
<%@ page import="model.entity.Patient" %>
<%@ page import="java.util.List" %>
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
    <title>Doctor Page</title>
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
<%Doctor doctor = (Doctor) request.getAttribute("currentDoctor"); %>
<main>
    <div class="container">
        <ul class="collection with-header">
            <li class="collection-header">
                <h4> <%= doctor.getUserId().getName()%>
                <%= doctor.getUserId().getSurname()%></h4>
            </li>
            <% for (Patient patient : (List<Patient>)request.getAttribute("patients")) { %>
            <li class="collection-item ">
                <span class="title"><%= patient.getUser().getName()%></span>

                <a class="btn right red darken-4 modal-trigger" href="#modal1"><fmt:message key="completeAssignment" /></a>

                <div id="modal1" class="modal">
                    <form method="post" action=${pageContext.request.contextPath}/doctor/completeAssign class="center-block" style="text-align: center; min-width: 80%">

                        <div class="input-field " style="margin-top: 40px">
                            <input type="text" id="userId1" name="userId1">
                            <label class="active" for="userId1"><fmt:message key="userId"/></label>
                        </div>

                        <div class="input-field ">
                            <input type="text" id="patientId1" name="patientId1">
                            <label class="active" for="patientId1"><fmt:message key="patients"/></label>
                        </div>
                        <div class="input-field center">
                            <button class="btn right red darken-4" type="submit"><fmt:message key="submit"/></button>
                        </div>
                    </form>
                </div>
                <p><%= patient.getUser().getSurname()%>
                <a class="btn right red darken-4 modal-trigger" href="#modal2"><fmt:message key="createAssignment" /></a>

                <div id="modal2" class="modal">
                    <form method="post" action=${pageContext.request.contextPath}/doctor/createAssign class="center-block" style="text-align: center; min-width: 80%">

                        <div class="input-field " style="margin-top: 40px">
                            <input type="text" id="userId2" name="userId2">
                            <label class="active" for="userId2"><fmt:message key="userId"/></label>
                        </div>

                        <div class="input-field ">
                            <input type="text" id="patientId2" name="patientId2">
                            <label class="active" for="patientId2"><fmt:message key="patients"/></label>
                        </div>
                        <div class="input-field center">
                            <button class="btn right red darken-4" type="submit"><fmt:message key="submit"/></button>
                        </div>
                    </form>
                </div>
                <p><%= patient.getUser().getBirthday()%>
                <a class="btn right red darken-4 modal-trigger" href="#modal3"><fmt:message key="defineDiagnosis" /></a>

                <div id="modal3" class="modal">
                    <form method="post" action=${pageContext.request.contextPath}/doctor/defineDiagnosis class="center-block" style="text-align: center; min-width: 80%">
                        <div class="container">
                        <div class="input-field " style="margin-top: 40px">
                            <input type="text" id="user" name="user">
                            <label class="active" for="user"><fmt:message key="userId"/></label>
                        </div>

                        <div class="input-field ">
                            <input type="text" id="treatment" name="treatment">
                            <label class="active" for="treatment"><fmt:message key="treatmentId"/></label>
                        </div>
                        <div class="input-field center">
                            <button class="btn right red darken-4" type="submit"><fmt:message key="submit"/></button>
                        </div>
                        </div>
                    </form>
                </div>
            </li>
            <% } %>
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
        $('.modal').modal();
    });
</script>
</body>
</html>