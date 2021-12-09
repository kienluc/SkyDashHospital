<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row" style="border: #0B0F32">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-4 col-3">
                        <p class="card-title">All Doctors</p>
                    </div>
                    <div class="col-sm-8 col-9 text-right m-b-20">
                        <a href="/doctors/add-doctor" class="btn btn-outline-primary btn-sm"><i class="mdi mdi-account-plus"></i> Add Doctor</a>
                    </div>
                </div>
                <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <c:set var="i" value="0"/>
                <c:forEach items="${departments}" var="dep">
                    <div class="row">
                        <div class="col-sm-4 col-3">
                            <p class="card-title">${dep.name}</p>
                        </div>
                    </div>
                    <br>
                <div class="row">
                    <c:forEach items="${doctors}" var="doctor">
                        <c:if test="${dep.id == doctor.departmentid.id}">
                    <div class="col-md-4 col-sm-4  col-lg-3" id="doctor${i = i + 1}">
                        <div class="profile-widget">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="doctor-img">
                                        <a class="avatar" href="#">
                                            <img alt="" src="${doctor.image}" width="150px" height="150px"
                                                 class="rounded-circle"></a>
                                    </div>
                                </div>
                                <div class="col-md-4 text-md-right">
                                    <div class="dropdown">
                                        <button type="button" class="btn btn-sm " id="dropdownMenuIconButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="ti-settings"></i>
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuIconButton3">
                                            <a class="dropdown-item" href="/doctors/edit-doctor/?doctorId=${doctor.id}" >Edit</a>
                                            <form onsubmit="return false;" action="/doctors/delete/${doctor.id}" method="post" id="${doctor.id}">
                                                <button type="submit" class="dropdown-item" onclick="alert('warning-message-and-cancel','${doctor.id}')">
                                                    Delete
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <h4 class="doctor-name text-ellipsis"><a href="#">${doctor.name}</a></h4>
                            <div class="doc-prof">${doctor.phone}</div>
                            <div class="user-country">
                                    ${doctor.address}
                            </div>
                        </div>
                        <br>
                        <br>
                    </div>
                        </c:if>
                    </c:forEach>
                </div>
                <br>
                    <br>
                </c:forEach>
            </div>
        </div>
    </div>
</div>