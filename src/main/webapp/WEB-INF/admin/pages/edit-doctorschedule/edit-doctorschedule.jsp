<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-12 grid-margin">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Edit Doctor Schedule</h4>
            <form:form method="post" modelAttribute="doctorschedule" cssClass="form-sample">
                <form:errors path="*" element="div" cssClass="alert alert-danger" />
                <p class="card-description">
                    Doctor Schedule Info
                </p>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Doctor Name</label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="doctor" id="doctor" disabled="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Days Of Week</label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="dayofweek" required="true;"
                                            type="number" value="2" min="2" max="8"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Shift</label>
                            <div class="col-sm-9">
                                <form:select cssClass="form-control" path="shiftid" id="shift">
                                    <c:forEach items="${shifts}" var="shift">
                                        <%--<c:if test="${doctor.account.id == null}">--%>
                                        <option value="${shift.id}">${shift.name}</option>
                                        <%--</c:if>--%>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 text-right">
                        <button type="submit" class="btn btn-outline-primary">
                            <div class="row">
                                <div class="col-sm-1"><i class="mdi mdi-account-plus"></i></div>
                                <div class="col-sm-9"><strong> Save changes</strong></div>
                            </div>
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>