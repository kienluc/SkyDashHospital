<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="row">
    <div class="col-md-6 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">Add Bill</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table id="mytable" class="display expandable-table" style="width: 100%; text-align: center">
                                <thead>
                                <tr>
                                    <th>Choose</th>
                                    <th>Name</th>
                                    <th>Unit</th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="i" value="0"/>
                                <c:forEach items="${drugs}" var="drug">
                                    <tr id="drug${drug.id}">
                                        <td><input type="checkbox" id="${drug.id}" name="check"
                                                   onclick="addOrdelete('${drug.id}','${drug.name}',
                                                           '${drug.unit}','${drug.price}')"/></td>
                                        <td>${drug.name}</td>
                                        <td>${drug.unit}</td>
                                        <td>${drug.price} VND</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="col-md-6 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">Bill Details</p>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table id="mytable1" class="display expandable-table" style="width: 100%; text-align: center">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Unit</th>
                                    <th>Price</th>
                                    <th>Amount</th>
                                </tr>
                                </thead>

                                <tbody id="table1body">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">Add Bill</p>
                    </div>
                </div>
<form:form onsubmit="return false;" method="post" modelAttribute="addbill" cssClass="form-sample" id="addbill">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <form:hidden path="patientid"/>
    <form:hidden path="str" id="drugs"/>
                <div class="row">
                    <div class="col-md-9">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Patient CCID</label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="ccid" required="true;"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Bill Date</label>
                            <div class="col-sm-9">
                                <form:input type="date" cssClass="form-control" path="date" required="true;"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Total</label>
                            <div class="col-sm-9">
                                <form:input cssClass="form-control" path="total"
                                            disabled="false"/>
                            </div>
                        </div>
                    </div>
                </div>
                    <div class="row">
                        <div class="col-sm-12 text-right">
                            <button onclick="getDataB4Submit()" type="submit" class="btn btn-outline-primary" >
                                <div class="row">
                                    <div class="col-sm-1"><i class="mdi mdi-account-plus"></i></div>
                                    <div class="col-sm-9"><strong> Create Bill</strong></div>
                                </div>
                            </button>
                        </div>
                    </div>
</form:form>
            </div>
        </div>
    </div>
</div>
