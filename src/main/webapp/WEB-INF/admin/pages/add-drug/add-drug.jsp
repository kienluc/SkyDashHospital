<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-12 grid-margin">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Add Drug</h4>
            <form:form method="post" modelAttribute="adddrug" cssClass="form-sample">
                <form:errors path="*" element="div" cssClass="alert alert-danger" />
                <p class="card-description">
                    Drugs Info
                </p>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Drug Name</label>
                            <div class="col-sm-9">
                                <form:input type="text" cssClass="form-control" path="name" required="true;"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Unit</label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="unit" required="true;" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Price</label>
                            <div class="col-sm-9">
                                <form:input type="text" cssClass="form-control" path="price" required="true;"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Decription</label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="decription" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 text-right">
                        <button type="submit" class="btn btn-outline-primary">
                            <div class="row">
                                <div class="col-sm-1"><i class="mdi mdi-account-plus"></i></div>
                                <div class="col-sm-9"><strong> Create Drug</strong></div>
                            </div>
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>