<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="common/header.jspf"%>

<%--content--%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="common/sidebar.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>About Tax Estimator MVC</h1>
                </div>
                <table class="table table-bordered table-striped">
                    <tbody>
                    <tr>
                        <td colspan="2"><strong>About</strong></td>
                    </tr>
                    <tr>
                        <td>Home page</td>
                        <td><a href="https://github.com/benas/todolist-mvc">https://github.com/benas/todolist-mvc</a></td>
                    </tr>
                    
                        <td colspan="2"><strong>Frameworks</strong></td>
                    </tr>
                    <tr>
                        <td><a href="http://www.oracle.com/technetwork/java/index-jsp-135475.html">Servlet / JSP</a></td>
                        <td>3.0 / 2.2</td>
                    </tr>
                    <tr>
                        <td><a href="http://spring.io/">Spring</a></td>
                        <td>3.2</td>
                    </tr>
                    <tr>
                        <td><a href="http://www.hibernate.org/">Hibernate</a></td>
                        <td>4.3</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<%--end content--%>
<%@ include file="common/footer.jspf"%>