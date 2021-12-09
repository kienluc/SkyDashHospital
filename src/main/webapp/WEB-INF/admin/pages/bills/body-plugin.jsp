
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/resources/vendors/chart.js/Chart.min.js"/>"></script>

<script>
    $(document).ready(function() {
        $('#mytable').DataTable();
    })
</script>

<script src="<c:url value="/resources/vendors/datatables.net/jquery.dataTables.js"/>"></script>
<script src="<c:url value="/resources/vendors/datatables.net-bs4/dataTables.bootstrap4.js"/>"></script>
<script src="<c:url value="/resources/js/dataTables.select.min.js"/>"></script>