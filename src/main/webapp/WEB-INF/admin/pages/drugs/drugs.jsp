<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">All Drugs</p>
                    </div>
                    <div class="col-sm-8 col-9 text-right">
                        <a href="/drugs/add-drug" class="btn btn-outline-primary btn-sm"><i class="mdi mdi-account-plus"></i> Add Drug</a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table id="mytable" class="display expandable-table" style="width: 100%; text-align: center">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Unit</th>
                                    <th>Price</th>
                                    <th>Decription</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="i" value="0"/>
                                <c:forEach items="${drugs}" var="drug">
                                    <tr id="drug${drug.id}">
                                        <td>${i = i+1}</td>
                                        <td>${drug.name}</td>
                                        <td>${drug.unit}</td>
                                        <td>${drug.price} VND</td>
                                        <td>${drug.decription}</td>
                                        <td style="text-align: right">
                                            <div class="dropdown">
                                                <button type="button" class="btn btn-outline-info dropdown-toggle" id="dropdownMenuIconButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="ti-settings"></i>
                                                </button>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuIconButton3">
                                                    <a class="dropdown-item" href="/drugs/edit-drug/?drugId=${drug.id}">
                                                        Edit
                                                    </a>
                                                    <form onsubmit="return false;" action="/drugs/delete/${drug.id}" method="post" id="${drug.id}">
                                                        <button type="submit" class="dropdown-item" onclick="alert('warning-message-and-cancel','${drug.id}')">
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
