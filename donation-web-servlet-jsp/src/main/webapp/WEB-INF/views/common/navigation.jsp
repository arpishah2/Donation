<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/index">Tax Estimator</a>

            <%--logged in mode --%>
            <c:if test="${sessionScope.user != null}">
            <ul class="nav">
                <li class="${requestScope.homeTabStyle}"><a href="/todos">Home</a></li>
                <li class="${requestScope.aboutTabStyle}"><a href="/about">About</a></li>
            </ul>
            <div class="btn-group pull-right">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"></i> Hi ${sessionScope.user.name} ! <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/user/account">My account</a></li>
                    <li class="divider"></li>
                    <li><a href="/user/logout">Sign out</a></li>
                </ul>
            </div>
            </c:if>

            <%--not logged in mode --%>
            <c:if test="${sessionScope.user == null}">
            <ul class="nav pull-right">
                <li class="${requestScope.registerTabStyle}"><a href="/register">Register</a></li>
                <li class="${requestScope.loginTabStyle}"><a href="/login">Login</a></li>
            </ul>
            </c:if>

        </div>
    </div>
</div>