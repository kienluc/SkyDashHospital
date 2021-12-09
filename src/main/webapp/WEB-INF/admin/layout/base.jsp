<%@ taglib prefix="input" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- plugins:css -->
    <link rel="stylesheet" href="<c:url value="/vendors/feather/feather.css" />">
    <link rel="stylesheet" href="<c:url value="/vendors/ti-icons/css/themify-icons.css"/>">
    <link rel="stylesheet" href="<c:url value="/vendors/css/vendor.bundle.base.css"/>">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <input:insertAttribute name = "head-plugin" />

    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="<c:url value="/css/vertical-layout-light/style.css"/>">
    <!-- endinject -->
    <link rel="shortcut icon" href="<c:url value="/images/favicon.png"/>" >

    <title><input:insertAttribute name="title" /></title>

</head>
<body>
<div class="container-scroller">
    <input:insertAttribute name="header" />
        <div class="container-fluid page-body-wrapper" >
            <input:insertAttribute name="setting-panel" />
            <input:insertAttribute name="sidebar" />
            <div class="main-panel" >
                <div class="content-wrapper">
                    <input:insertAttribute name="body" />
                </div>
                <!-- content-wrapper ends -->
                <!-- partial:partials/_footer.html -->
                <input:insertAttribute name="footer" />
                <!-- partial -->
            </div>
            <!-- main-panel ends -->
        </div>
    <!-- page-body-wrapper ends -->
</div>

<!-- container-scroller -->

<!-- plugins:js -->
<script src="<c:url value="/vendors/js/vendor.bundle.base.js"/>"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
    <input:insertAttribute name = "body-plugin" />
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="<c:url value="/js/off-canvas.js"/>"></script>
<script src="<c:url value="/js/hoverable-collapse.js"/>"></script>
<script src="<c:url value="/js/template.js"/>"></script>
<script src="<c:url value="/js/settings.js"/>"></script>
<script src="<c:url value="/js/todolist.js"/>"></script>
<!-- endinject -->
<!-- Custom js for this page-->
  <script src="<c:url value="/js/dashboard.js"/>"></script>
  <script src="<c:url value="/js/Chart.roundedBarCharts.js" />"></script>
<!-- End custom js for this page-->
</body>

</html>

