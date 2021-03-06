<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Content"/>

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