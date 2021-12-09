<%@ taglib prefix="input" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <title><input:insertAttribute name="title2"/></title>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="<c:url value="/resources/client/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/client/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/client/css/animate.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/client/css/owl.carousel.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/client/css/owl.theme.default.min.css"/>"/>

    <!-- MAIN CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/client/css/tooplate-style.css"/>"/>

</head>
<body id="top" data-spy="scroll" data-target=".navbar-collapse" data-offset="50">


    <input:insertAttribute name="header2"/>
    <input:insertAttribute name="body2"/>
    <input:insertAttribute name="footer2"/>



<!-- SCRIPTS -->
<script src="<c:url value="/resources/client/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/client/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/client/js/jquery.sticky.js"/>"></script>
<script src="<c:url value="/resources/client/js/jquery.stellar.min.js"/>"></script>
<script src="<c:url value="/resources/client/js/wow.min.js"/>"></script>
<script src="<c:url value="/resources/client/js/smoothscroll.js"/>"></script>
<script src="<c:url value="/resources/client/js/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/resources/client/js/custom.js"/>"></script>

</body>
</html>