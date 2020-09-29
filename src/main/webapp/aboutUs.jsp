<%--
  Created by IntelliJ IDEA.
  User: Bohdan
  Date: 29.09.2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <title>About Hospital</title>
</head>
<body>
<header>
    <nav>
        <div class="container">
            <div class="nav-wrapper">
                <a href="firstJsp.jsp" class="brand-logo"><i class="material-icons">local_hospital</i>HOSPITAL</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="firstJsp.jsp">Home</a></li>
                    <li><a href="#">About us</a></li>
                    <li><a href="register.jsp" class="btn">Login</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <ul class="sidenav" id="mobile-demo">
        <li><a href="firstJsp.jsp">Home</a></li>
        <li><a href="#">About us</a></li>
    </ul>
</header>
<!--   Card elements  -->
<div class="row">
    <div class="col s12 m4">
        <div class="card z-depth-3 hoverable">
            <div class="card-image">
                <img src="${pageContext.request.contextPath}/img/home.jpg" alt="image">
                <span class="card-title">Doctors</span>
            </div>
            <div class="card-content">
                <p>The earliest known occurrences of Lorem ipsum passages are on Letraset dry-transfer sheets from early 1970s, which were produced to be used graphic designers.</p>
            </div>
            <div class="card-action">
                <a href="#">Read More</a>
            </div>
        </div>
    </div>

    <div class="col s12 m4">
        <div class="card z-depth-3 hoverable">
            <div class="card-image">
                <img src="${pageContext.request.contextPath}/img/home.jpg" alt="image">
                <span class="card-title">Nurses</span>
            </div>
            <div class="card-content">
                <p>The earliest known occurrences of Lorem ipsum passages are on Letraset dry-transfer sheets from early 1970s, which were produced to be used graphic designers.</p>
            </div>
            <div class="card-action">
                <a href="#">Read More</a>
            </div>
        </div>
    </div>

    <div class="col s12 m4">
        <div class="card z-depth-3 hoverable">
            <div class="card-image">
                <img src="${pageContext.request.contextPath}/img/home.jpg" alt="image">
                <span class="card-title">Patients</span>
            </div>
            <div class="card-content">
                <p>The earliest known occurrences of Lorem ipsum passages are on Letraset dry-transfer sheets from early 1970s, which were produced to be used graphic designers.</p>
            </div>
            <div class="card-action">
                <a href="#">Read More</a>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Hospital Project</h5>
                <p class="grey-text text-lighten-4">This project was created in Autumn 2020<br> By Bohdan Boyko developer</p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Connect</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="https://github.com/Jossindev">GitHub</a></li>
                    <li><a class="grey-text text-lighten-3" href="https://www.linkedin.com/in/bohdan-boiko-07773b1a4/">LinkedIn</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2020 Fake hospital
        </div>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function(){
        $('.sidenav').sidenav();
    });
</script>
</body>
</html>
