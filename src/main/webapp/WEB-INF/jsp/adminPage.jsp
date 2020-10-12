<%@ page import="model.entity.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Patient" %>
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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <title>Admin Page</title>
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
<jsp:include page="element/header.jsp"/>

<main>
    <div class="container">
        <ul class="collection with-header">
            <li class="collection-header"><h4>Admin
                <a href="${pageContext.request.contextPath}/admin/registerDoctor" style="margin: 0 1%;"
                   class="btn right red darken-4"><fmt:message key="registerDoctor"/></a>
                <a href="${pageContext.request.contextPath}/admin/registerPatient"
                   class="btn right red darken-4"><fmt:message key="registerPatient"/></a>
            </h4></li>
        </ul>
    </div>

    <div class="container">
        <div class="row">
            <div class="col s12">
                <ul class="tabs">
                    <li class="tab col s6"><a href="#test1"><fmt:message key="doctorsList"/> </a></li>
                    <li class="tab col s6"><a href="#test2"><fmt:message key="patientsList"/></a></li>
                </ul>
            </div>

            <!-- Doctors -->
        <div id="test1" class="col s12">
            <div class="input-field col s4">
                <form action="${pageContext.request.contextPath}/admin/sorting" method="post">
                    <select name="type">
                        <option value="0" disabled selected><fmt:message key="sortingType"/></option>
                        <option value="1"><fmt:message key="alphabet"/></option>
                        <option value="2"><fmt:message key="category"/></option>
                    </select>
                    <button type="submit" class="btn middle red darken-4" style="width: 100%">
                        <strong>sort</strong>
                    </button>
                </form>
            </div>

            <ul class="collection col s12">
                <% for (Doctor doctor : (List<Doctor>) request.getAttribute("activeDoctors")) { %>
                <li class="collection-item ">
                    <span class="title"><%= doctor.getUserId().getName()%></span>
                        <p><%= doctor.getUserId().getSurname()%></p>
                        <p><%= doctor.getDoctorType()%></p>
                </li>
                <% } %>
            </ul>
        </div>

            <!-- Patients -->
        <div id="test2" class="col s12">
            <div class="input-field col s4">
                <form action="${pageContext.request.contextPath}/admin/sorting" method="post">
                    <select name="type">
                        <option value="0" disabled selected><fmt:message key="sortingType"/></option>
                        <option value="3"><fmt:message key="alphabet"/></option>
                        <option value="4"><fmt:message key="date"/></option>
                    </select>
                        <button type="submit" class="btn middle red darken-4" style="width: 100%">
                            <strong>sort</strong>
                        </button>
                </form>
            </div>
                <ul class="collection col s12">
                    <% for (Patient patient : (List<Patient>) request.getAttribute("activePatients")) { %>
                <li class="collection-item ">
                    <span class="title"><%= patient.getUser().getName()%>
                        <a class="btn right red darken-4 modal-trigger" href="#modal1"><fmt:message key="assignDoctor"/></a>
                        <div id="modal1" class="modal">
                            <form method="post" action=${pageContext.request.contextPath}/admin/assignDoctor
                                  class="center-block" style="text-align: center; min-width: 80%">
                                <div class="container">
                                    <div class="input-field " style="margin-top: 40px">
                                        <input type="text" id="userId" name="userId">
                                        <label class="active" for="userId"><fmt:message key="userId"/></label>
                                    </div>
                                    <div class="input-field ">
                                        <input type="text" id="doctorId" name="doctorId">
                                        <label class="active" for="doctorId"><fmt:message key="doctorId"/></label>
                                    </div>
                                      <div class="input-field ">
                                        <input type="text" id="nurseId" name="nurseId">
                                        <label class="active" for="nurseId"><fmt:message key="nurseId"/></label>
                                    </div>
                                    <div class="input-field center">
                                        <button class="btn right red darken-4" type="submit"><fmt:message
                                                key="submit"/></button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        </span>
                        <p><%= patient.getUser().getSurname()%></p>
                        <p><%= patient.getId()%></p>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </div>
</main>

<jsp:include page="element/footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('select').formSelect();
        $('.tabs').tabs();
        $('.sidenav').sidenav();
        $('.modal').modal();
    });
</script>
</body>
</html>
