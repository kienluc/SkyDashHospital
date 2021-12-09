<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-12 grid-margin">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Add Appointment</h4>
            <form:form method="post" modelAttribute="addappointment" cssClass="form-sample">
                <form:errors path="*" element="div" cssClass="alert alert-danger" />
                <p class="card-description">
                    Patient Info
                </p>
                <form:hidden path="name"/>
                <form:hidden path="id"/>
                <form:hidden path="email"/>
                <form:hidden path="phone"/>
                <form:hidden path="ccid"/>

                <div class="row">
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Name</label>
                                <div class="col-sm-9">
                                    <input required="true;" class="form-control" disabled
                                           value="<c:out value="${patientss.name}"/>"/>

                                </div>
                            </div>
                        </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Date of Appointment</label>
                            <div class="col-sm-9">
                                <form:input type="date" cssClass="form-control" path="date" required="true;"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Department</label>
                            <div class="col-sm-9">
                                <form:select cssClass="form-control" path="department">
                                    <c:forEach items="${departmentss}" var="dep">
                                        <option value="${dep.id}">${dep.name}</option>
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
                                <div class="col-sm-9"><strong> Create Appointment</strong></div>
                            </div>
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>