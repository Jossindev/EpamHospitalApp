<%--
  Created by IntelliJ IDEA.
  User: Bohdan
  Date: 30.09.2020
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" isErrorPage="true"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error Page</title>
</head>
<body>
<h2>
    Error Page<br/>
    <i>Error <%= exception %></i>
</h2>
<br>
<a href="${pageContext.request.contextPath}/">Home</a>


</body>
</html>