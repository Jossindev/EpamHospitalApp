<%--
  Created by IntelliJ IDEA.
  User: Bohdan
  Date: 29.09.2020
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
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
                <form action="firstJsp.jsp" method="POST" class="center-block" style="text-align: center">
                    <h1>Register</h1>
                    <div class="input-field" style="margin-top: 40px">
                        <i class="material-icons prefix">account_circle</i>
                        <input type="text" id="name">
                        <label for="name">Your name</label>
                    </div>
                    <div class="input-field" >
                        <i class="material-icons prefix">account_circle</i>
                        <input type="text" id="surname">
                        <label for="surname">Your surname</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">email</i>
                        <input type="email" id="email">
                        <label for="email">Your Email</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">date_range</i>
                        <input type="text" id="birthday">
                        <label for="birthday">Your Birthday</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">lock</i>
                        <input type="password" id="password">
                        <label for="password">Your Password</label>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">vpn_key</i>
                        <input type="password" id="confirm-password">
                        <label for="confirm-password">Repeat Password</label>
                    </div>
                    <div class="left-align" style="margin-left: 1vh">
                        <p><strong>Choose account type:</strong></p>
                        <div class="input-field">
                            <p>
                                <label>
                                    <input class="with-gap" name="group1" type="radio" checked />
                                    <span>Patient</span>
                                </label>
                            </p>
                            <p>
                                <label>
                                    <input class="with-gap" name="group1" type="radio" />
                                    <span>Nurse</span>
                                </label>
                            </p>
                            <p>
                                <label>
                                    <input class="with-gap" name="group1" type="radio" />
                                    <span>Doctor</span>
                                </label>
                            </p>
                        </div>
                    </div>
                    <p>Already have an account? <a href="login.jsp">Log in</a></p>
                    <div class="input-field center">
                        <button class="btn-large purple darken-4" type="submit">Create an account</button>
                    </div>
                </form>
                <a style="position: absolute; bottom: 2%" href="firstJsp.jsp">Go home</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>


