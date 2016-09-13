<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../common/sidebar.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>Add a  new donation entry</h1>
                </div>

                <form id="createDonationForm" action="/donations/new.do" method="post" class="form-horizontal">

                    <fieldset>

                        <div class="control-group">
                            <label class="control-label" for="description">Description:</label>
                            <div class="controls">
                                <input type="text" id="description" name="description" required="required" autofocus="autofocus" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="estimate">Estimate Value:</label>
                            <div class="controls">
                                <input type="text" id="estimate" name="estimate" value="${requestScope.today}" required="required" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="year">Enter year(yyyy):</label>
                            <div class="controls">
                                <select id="priority" name="priority">
                                  <input type="text" id="year" name="year" value="${requestScope.today}" required="required" />
                                </select>
                            </div>
                        </div>

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Add</button>
                            <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                        </div>

                    </fieldset>
                </form>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>