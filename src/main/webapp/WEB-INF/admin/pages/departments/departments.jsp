<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">All Departments</p>
                    </div>
                    <div class="col-sm-8 col-9 text-right">
                        <a href="/departments/add-department" class="btn btn-outline-primary btn-sm"><i class="mdi mdi-account-plus"></i> Add Department</a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table id="mytable" class="display expandable-table" style="width: 100%; text-align: center">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name </th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="i" value="0"/>
                                <c:forEach items="${departments}" var="department">
                                    <tr id="patient${department.id}">
                                        <td>${i = i + 1}</td>
                                        <td>${department.name}</td>
                                        <td style="text-align: right">
                                            <div class="dropdown">
                                                <button type="button" class="btn btn-outline-info dropdown-toggle" id="dropdownMenuIconButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="ti-settings"></i>
                                                </button>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuIconButton3">
                                                    <a class="dropdown-item" href="/departments/edit-department/?departmentId=${department.id}">
                                                        Edit
                                                    </a>
                                                    <form onsubmit="return false;" action="/departments/delete/${department.id}" method="post" id="${department.id}">
                                                        <button type="submit" class="dropdown-item" onclick="alert('warning-message-and-cancel','${department.id}')">
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
