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
    <title>Register doctors</title>
</head>
<body>
<jsp:include page="element/header.jsp" />
<div class="row">
    <div class="col m6 offset-m3 l4 offset-l4 s12">
        <div class="card-panel z-depth-5" style="min-height: 90vh; margin-top: 4vh; position: relative">
            <form method="post" action=${pageContext.request.contextPath}/admin/registerDoctor class="center-block" style="text-align: center; min-width: 80%">

                    <div class="input-field ">
                        <input  id="doctorId" type="text" name="doctorId">
                        <label class="active" for="doctorId"><fmt:message key="doctorId"/> </label>
                    </div>

                    <div class="input-field ">
                        <input id="userId" type="text" name="userId">
                        <label class="active" for="userId"><fmt:message key="userId"/> </label>
                    </div>

                    <div class="input-field ">
                        <input  id="doctorType" type="text" name="doctorType">
                        <label class="active" for="doctorType"><fmt:message key="doctorType"/> </label>
                    </div>

                 <div class="input-field center">
                   <button class="btn right red darken-4" type="submit"><fmt:message key="register"/></button>
                 </div>
            </form>
            <a style="position: absolute; bottom: 2%" href="${pageContext.request.contextPath}/admin"><fmt:message key="home"/> </a>
        </div>
    </div>
</div>
<jsp:include page="element/footer.jsp" />

</body>
</html>
