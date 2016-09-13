<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="common/header.jspf"%>

<div class="container">
    <div class="row well">
        <div class="span10 offset1">
            <div class="row">

                <div class="span5">
                    <h3>Welcome to Tax estimator MVC</h3>
                    <p>
                    <h4>Tax estimator MVC is a web-based task manager which allows you to:</h4>
                    <ul>
                        <li>Save and organize your donation list</li>
                        <li>Search easily your donation list</li>
                        <li>Export and report your donation list</li>
                    </ul>
                    <h4>And which is totally Free! Enjoy !</h4>
                    </p>

                    <c:if test="${sessionScope.user == null}">
                    <p>
                        <a class="btn btn-primary btn-large" href="/login"> Sign in </a> or <a class="btn btn-primary btn-large" href="/register"> Sign up </a>
                    </p>
                    </c:if>

                    <c:if test="${sessionScope.user != null}">
                        <p>
                            <a class="btn btn-primary btn-large" href="/donations"> Go to my Home page </a>
                        </p>
                    </c:if>

                </div>

                <div class="span5">
                    <img src="/static/img/donationlist.jpg" alt="donationlist">
                </div>

            </div>

        </div>

    </div>
</div>

<%@ include file="common/footer.jspf"%>