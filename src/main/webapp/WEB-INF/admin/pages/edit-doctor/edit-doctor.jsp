<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-12 grid-margin">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Edit Doctor</h4>
            <form:form method="post" modelAttribute="doctor" cssClass="form-sample"
                       enctype="multipart/form-data">
                    <form:hidden path="id"/>
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p class="card-description">
                    Doctor Info
                </p>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Name</label>
                            <div class="col-sm-9">
                                <form:input type="text" cssClass="form-control" path="name" />
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Date of Birth</label>
                            <div class="col-sm-9">
                                <form:input type="date" cssClass="form-control" path="dateOfBirth"/>
                            </div>
                        </div>
                    </div>
                </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">CCID</label>
                                <div class="col-sm-9">
                                    <form:input cssClass="form-control" path="ccid" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Email</label>
                                <div class="col-sm-9">
                                    <form:input type="text" cssClass="form-control" path="email"/>
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Address</label>
                            <div class="col-sm-9">
                                <form:input type="text" cssClass="form-control" path="address"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Phone Number</label>
                            <div class="col-sm-9">
                                <form:input type="text" cssClass="form-control" path="phone"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Department</label>
                            <div class="col-sm-9">
                                <form:select cssClass="form-control" path="departmentid">
                                    <c:forEach items="${departments}" var="dep">
                                        <c:if test="${dep.id == doctor.departmentid.id}">
                                            <option selected value="${dep.id}">${dep.name}</option>
                                        </c:if>
                                        <c:if test="${dep.id != doctor.departmentid.id}">
                                            <option value="${dep.id}">${dep.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Gender</label>
                            <div class="col-sm-4">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <form:radiobutton cssClass="form-check-input"
                                                          name="membershipRadios" id="membershipRadios1"
                                                          path="gender" value="Male"/>
                                        Male
                                    </label>
                                </div>
                            </div>
                            <div class="col-sm-5">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <form:radiobutton cssClass="form-check-input" name="membershipRadios"
                                                          id="membershipRadios2" path="gender" value="Female"/>
                                        Female
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Image</label>
                            <div class="col-sm-9">
                                <form:input type="file" cssClass="file-upload-default" placeholder="Upload Image" path="img"/>
                                <div class="input-group col-xs-12">
                                        <form:input cssClass="form-control file-upload-info" placeholder="Upload Image" path="image"/>
                                    <span class="input-group-append">
                                        <button class="file-upload-browse btn btn-primary" type="button">Upload</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    <div class="row">
                        <div class="col-sm-12 text-right">
                            <button type="submit" class="btn btn-outline-primary">
                                <div class="row">
                                    <div class="col-sm-1"><i class="mdi mdi-content-save"></i></div>
                                    <div class="col-sm-9"><strong> Save Changes</strong></div>
                                </div>
                            </button>
                        </div>
                    </div>
                </form:form>
        </div>
    </div>
</div>