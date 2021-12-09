<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-12 grid-margin">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Edit Account</h4>
            <form:form method="post" modelAttribute="account" cssClass="form-sample">
                <form:errors path="*" element="div" cssClass="alert alert-danger" />
                <form:hidden path="id"/>
                <p class="card-description">
                    Accounts Info
                </p>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Doctor Name</label>
                            <div class="col-sm-9">
                                <input disabled="true" class="form-control" value="${account.doctor.name}"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Role</label>
                            <div class="col-sm-9">
                                <form:select cssClass="form-control" path="role">
                                    <c:forEach items="${roles}" var="role">
                                        <c:if test="${role.id == account.role.id}">
                                            <option selected value="${role.id}">${role.role}</option>
                                        </c:if>
                                        <c:if test="${role.id != account.role.id}">
                                            <option value="${role.id}">${role.role}</option>
                                        </c:if>
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
                                <form:input type="password" cssClass="form-control" path="confirmPassword" required="true;" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 text-right">
                        <button type="submit" class="btn btn-outline-primary">
                            <div class="row">
                                <div class="col-sm-1"><i class="mdi mdi-account-plus"></i></div>
                                <div class="col-sm-9"><strong> Save Changes</strong></div>
                            </div>
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>