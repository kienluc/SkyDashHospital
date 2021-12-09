<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">All Bills</p>
                    </div>
                    <div class="col-sm-8 col-9 text-right">
                        <a href="/bills/add-bill" class="btn btn-outline-primary btn-sm"><i class="mdi mdi-account-plus"></i> Add Bill</a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table id="mytable" class="display expandable-table" style="width: 100%; text-align: center">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Patient Name </th>
                                    <th>Date</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${bills}" var="bill">
                                    <tr id="bill${bill.id}">
                                        <td>${bill.id}</td>
                                        <td>${bill.patient.name}</td>
                                        <td>${bill.date}</td>
                                        <td>${bill.total}</td>
                                        <td style="text-align: right">
                                            <div class="dropdown">
                                                <button type="button" class="btn btn-outline-info dropdown-toggle" id="dropdownMenuIconButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="ti-settings"></i>
                                                </button>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuIconButton3">
                                                    <a class="dropdown-item" href="/bills/edit-bill/?drugId=${bill.id}">
                                                        Edit
                                                    </a>
                                                    <form onsubmit="return false;" action="/bills/delete/${bill.id}" method="post" id="${bill.id}">
                                                        <button type="submit" class="dropdown-item" onclick="alert('warning-message-and-cancel','${bill.id}')">
                                                            Delete
                                                        </button>
                                                    </form>

                                                </div>
                                            </div>
                                        </td>
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
</div>
