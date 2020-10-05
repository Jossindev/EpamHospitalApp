

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
    <title>Hospital Project</title>
</head>
<body>
<header>
    <nav>
        <div class="container">
            <div class="nav-wrapper">
                <a href="firstJsp.jsp" class="brand-logo"><i class="material-icons">local_hospital</i><fmt:message key="hospital" /></a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li>
                        <div>
                            <form>
                                <select id="language" name="language" onchange="submit()">
                                    <option  value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                                    <option  value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>
                                 </select>
                            </form>
                        </div>
                    </li>
                    <li><a href="#"><fmt:message key="home" /></a></li>
                    <li><a href="aboutUs.jsp"><fmt:message key="aboutUs" /></a></li>
                    <li><a href="login.jsp.jsp" class="btn"><fmt:message key="login" /></a></li>
                </ul>
            </div>
        </div>
    </nav>

    <ul class="sidenav" id="mobile-demo">
        <li><a href="#"><fmt:message key="home" /></a></li>
        <li><a href="aboutUs.jsp"><fmt:message key="aboutUs" /></a></li>
    </ul>
</header>

<section class="container section scrollspy" id="photos">
    <div class="col s12 l4">
        <img src="${pageContext.request.contextPath}/img/stay_home.jpg" alt="image" class="responsive-img materialboxed z-depth-3 hoverable">
    </div>
    <div class="col s12 l6 offset-l1">
        <h2 class="indigo-text text-darken-4"><fmt:message key="hospital"/></h2>
        <p>Адміністратору системи доступний список Лікарів за категоріями (педіатр, травматолог, хірург, ...) і список
            Пацієнтів. <br>
            Реалізувати можливість сортування:<br>
        <ul>
            <li> 1.Пацієнтів:
                <ol>-за алфавітом;</ol>
                <ol>-за датою народження;</ol>
            </li>
            <li>2.Лікарів:
                <ol>-за алфавітом;</ol>
                <ol>-за категорією;</ol>
                <ol>-за кількістю пацієнтів.</ol>
            </li>
        </ul>
        Адміністратор реєструє в системі пацієнтів і лікарів і призначає пацієнтові лікаря.<br>
        Лікар визначає діагноз, робить призначення пацієнту (процедури, ліки, операції), які фіксуються в Лікарняній
        картці.<br>
        Призначення може виконати Медсестра (процедури, ліки) або Лікар (будь-яке призначення). <br>
        Пацієнт може бути виписаний з лікарні, при цьому фіксується остаточний діагноз. <br>
        (Опціонально: реалізувати можливість збереження / експорта документа з інформацією про виписку пацієнта).
    </div>
</section>

<!-- Footer -->
<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text"><fmt:message key="hospitalProject"/></h5>
                <p class="grey-text text-lighten-4"><fmt:message key="timeCreate"/><br>
                    <fmt:message key="developer"/></p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text"><fmt:message key="connect"/> </h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="https://github.com/Jossindev">GitHub</a></li>
                    <li><a class="grey-text text-lighten-3" href="https://www.linkedin.com/in/bohdan-boiko-07773b1a4/">LinkedIn</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2020 <fmt:message key="fakeHospital"/>
        </div>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('.sidenav').sidenav();
        $('.materialboxed').materialbox();
        $('select').formSelect();
    });
</script>
</body>
</html>
