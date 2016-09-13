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
                    <h1>Update donation</h1>
                </div>

                <form action="/donations/update.do" method="post" class="form-horizontal">

                    <fieldset>

                        <div class="control-group">
                            <label class="control-label" for="id">Donation Id:</label>
                            <div class="controls">
                                <input type="text" id="id" name="id" value="${requestScope.donation.id}" disabled="disabled"/>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="description">Description:</label>
                            <div class="controls">
                                <input type="text" id="description" name="description" value="${requestScope.donation.description}" required="required" autofocus="autofocus" />
                            </div>
                        </div>
                        
                        <div class="control-group">
                            <label class="control-label" for="estimate">Estimate:</label>
                            <div class="controls">
                                <input type="text" id="estimate" name="estimate" value="${requestScope.donation.estimate}" required="required" autofocus="autofocus" />
                            </div>
                        </div>
                        
                        <div class="control-group">
                            <label class="control-label" for="year">Year(yyyy):</label>
                            <div class="controls">
                                <input type="text" id="year" name="year" value="${requestScope.donation.year}" required="required" autofocus="autofocus" />
                            </div>
                        </div>
                        
                         <div class="control-group">
                            <label class="control-label" for="tax_deductible">Deductable Tax:</label>
                            <div class="controls">
                                <input type="text" id="tax_deductible" name="tax_deductible" value="${requestScope.donation.tax_deductible}" disabled="disabled"/>
                            </div>
                        </div>


                        <input type="hidden" name="donationId" value="${requestScope.donation.id}"/>

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-refresh icon-white"></i> Update</button>
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