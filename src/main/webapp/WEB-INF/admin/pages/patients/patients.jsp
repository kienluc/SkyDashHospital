<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">All Patients</p>
                    </div>
                    <div class="col-sm-8 col-9 text-right">
                        <a href="/patients/add-patient" class="btn btn-outline-primary btn-sm"><i class="mdi mdi-account-plus"></i> Add Patient</a>
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
                                    <th>CCID</th>
                                    <th>Date of Birth</th>
                                    <th>Gender</th>
                                    <th>Disease</th>
                                    <th>Email</th>
                                    <th>Phone nummber</th>
                                    <th>Address</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="i" value="0"/>
                                <c:forEach items="${patients}" var="patient">
                                <tr id="patient${patient.id}">
                                    <td>${i = i + 1}</td>
                                    <td>${patient.name}</td>
                                    <td>${patient.ccid}</td>
                                    <td>${patient.dateOfBirth}</td>
                                    <td>${patient.gender}</td>
                                    <td>${patient.disease}</td>
                                    <td>${patient.email}</td>
                                    <td>${patient.phone}</td>
                                    <td>${patient.address}</td>
                                    <td style="text-align: right">
                                        <div class="dropdown">
                                            <button type="button" class="btn btn-outline-info dropdown-toggle" id="dropdownMenuIconButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="ti-settings"></i>
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuIconButton3">
                                                <a class="dropdown-item" href="/patients/edit-patient/?patientId=${patient.id}">
                                                    Edit
                                                </a>
                                                <a class="dropdown-item" href="/appointments/add-appointment/${patient.id}">
                                                    Add Appointment
                                                </a>
                                                <form onsubmit="return false;" action="/patients/delete/${patient.id}" method="post" id="${patient.id}">
                                                    <button type="submit" class="dropdown-item" onclick="alert('warning-message-and-cancel','${patient.id}')">
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
