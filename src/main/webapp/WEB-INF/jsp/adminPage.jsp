<%--
  Created by IntelliJ IDEA.
  User: Bohdan
  Date: 06.10.2020
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>


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
<jsp:include page="element/header.jsp" />

<main>

    <!-- Banner image-->

    <div class="container">
        <ul class="collection with-header">
            <li class="collection-header"><h4>Admin
                <a href="#" style="margin: 0 1%;" class="btn right red darken-4">register doctor</a>
                <a href="#" class="btn right red darken-4">register patient</a>
            </h4> </li>
        </ul>
    </div>

    <div class="container">
        <div class="row">
            <div class="col s12">
                <ul class="tabs">
                    <li class="tab col s6"><a href="#test1">Doctors</a></li>
                    <li class="tab col s6"><a href="#test2">Patients</a></li>
                </ul>
            </div>

            <!-- Doctors -->
            <div id="test1" class="col s12">
                <div class="input-field col s4">
                    <select>
                        <option value="" disabled selected>Choose sorting type</option>
                        <option value="1">Alphabeth</option>
                        <option value="2">Cathegory</option>
                        <option value="3">Count of patients</option>
                    </select>
                </div>
                <ul class="collection col s12">
                    <li class="collection-item ">
                        <span class="title">Name</span>
                        <p>Surname
                        <p>Date
                    </li>
                    <li class="collection-item ">
                        <span class="title">Name</span>
                        <p>Surname
                        <p>Date
                    </li>
                </ul>
            </div>

            <!-- Patients -->
            <div id="test2" class="col s12">
                <div class="input-field col s4">
                    <select>
                        <option value="" disabled selected>Choose sorting type</option>
                        <option value="1">Alphabeth</option>
                        <option value="2">Birthday date</option>
                    </select>
                </div>
                <ul class="collection col s12">
                    <li class="collection-item ">
                        <span class="title">Name  <a href="#" class="btn right red darken-4">assign a doctor</a> </span>
                        <p>Surname
                        <p>Date
                    </li>
                </ul>
            </div>
        </div>
    </div>
</main>

<jsp:include page="element/footer.jsp" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function(){
        $('select').formSelect();
        $('.tabs').tabs();
        $('.sidenav').sidenav();
    });
</script>
</body>
</html>
