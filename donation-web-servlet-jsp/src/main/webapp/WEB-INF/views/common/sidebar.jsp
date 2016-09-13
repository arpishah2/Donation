<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="well sidebar-nav">
    <ul class="nav nav-list">
        <li class="nav-header">Hi ${sessionScope.user.name} !</li>
        <li><a href="/todos"><i class="icon-home"></i> Home</a></li>
        <li><a href="/user/account"><i class="icon-user"></i> My account</a></li>
        <li><a href="/todos/new"><i class="icon-file"></i> Add a donation</a></li>
        <li class="divider"></li>
        <li class="nav-header">Search donation</li>
        <li>
            <form class="form-search" action="/donations/search" id="searchForm" method="get">
                <div class="input-append">
                    <input type="text" name="title" class="input-small search-query" placeholder="search by description" required="required">
                    <button type="submit" class="btn">Go!</button>
                </div>
            </form>
        </li>
    </ul>
</div>