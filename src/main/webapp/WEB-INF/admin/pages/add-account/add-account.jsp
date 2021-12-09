<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-12 grid-margin">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Add Account</h4>
            <form:form method="post" modelAttribute="addaccount" cssClass="form-sample">
                <form:errors path="*" element="div" cssClass="alert alert-danger" />
                <p class="card-description">
                    Accounts Info
                </p>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Doctor Name</label>
                            <div class="col-sm-9">
                                <form:select cssClass="form-control" path="doctor" id="doctor" onchange="isNull()">
                                    <option value="">Choose the doctor</option>
                                    <c:forEach items="${doctors}" var="doctor">
                                        <c:if test="${doctor.account.id == null}">
                                            <option value="${doctor.id}">${doctor.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Role</label>
                            <div class="col-sm-9">
                                <form:select cssClass="form-control" path="role">
                                    <c:forEach items="${roles}" var="role">
                                        <option selected value="${role.id}">${role.role}</option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">User Name</label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="username" required="true;"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Password</label>
                            <div class="col-sm-9">
                                <form:input type="password" cssClass="form-control" path="password" required="true;"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Confirm Password</label>
                            <div class="col-sm-9">
                                <form:input type="password" cssClass="form-control" path="confirmPassword" required="true;"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 text-right">
                        <button type="submit" class="btn btn-outline-primary" id="create" disabled>
                            <div class="row">
                                <div class="col-sm-1"><i class="mdi mdi-account-plus"></i></div>
                                <div class="col-sm-9"><strong> Create Account</strong></div>
                            </div>
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>