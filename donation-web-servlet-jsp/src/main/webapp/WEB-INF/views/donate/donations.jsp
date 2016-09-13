<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tl" uri="http://donationlist.org/taglib" %>
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
                    <h1>My Donation list</h1>
                </div>

                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Estimate</th>
                        <th>Tax Deductible</th>
                        <th>Year</th>
                        
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.donationList}" var="currentDonation">
                        <tr>
                            <td>${currentDonation.id}</td>
                            <td>${currentDonation.description}</td>
                            <td>${currentDonation.estimate}</td>
                            <td>${currentDonation.tax_deductible}</td>
                            <td>${currentDonation.year}</td>
                            <td>
                                <a class="btn btn-mini btn-primary" href="/donations/update?donationId=${currentDonation.id}"><i class="icon-edit icon-white"></i> Edit</a>
                                <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_${currentDonation.id}"><i class="icon-remove icon-white"></i> Delete</a>
                                <div class="modal hide" id="confirm_delete_${currentDonation.id}">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
                                        <h3>Confirmation</h3>
                                    </div>
                                    <div class="modal-body">
                                        <p>Are you sure to delete donation ${currentDonation.id} '${currentDonation.description}' ?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <form action="/donations/delete.do" method="post">
                                            <input type="hidden" name="donationId" value="${currentDonation.id}">
                                            <a href="#" class="btn" data-dismiss="modal">Cancel</a> <button type="submit" class="btn btn-primary">Confirm</button>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="2"><div align="center">Total = <span class="badge badge-inverse">${requestScope.totalCount}</span></div></td>
                        <td colspan="2"><div align="center">Donation = <span class="badge">${requestScope.donationCount}</span></div></td>
                        <td colspan="2"><div align="center">Done = <span class="badge badge-success">${requestScope.doneCount}</span></div></td>
                    </tr>
                    </tfoot>
                </table>

                <c:if test="${empty requestScope.donationList}">
                    <div class="alert alert-info">
                        <div align="center">Your donation list is empty !</div>
                    </div>
                </c:if>

                <c:if test="${not empty requestScope.donationList}">
                <div align="center">
                    <button class="btn" onclick="javascript:window.print()">
                        <i class="icon-print"></i>
                        Print my donation list
                    </button>
                </div>
                </c:if>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
