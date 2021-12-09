<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value="/resources/vendors/chart.js/Chart.min.js"/>"></script>

<script>
    $(document).ready(function() {
        $('#mytable').DataTable();

        let t = $('#mytable1').DataTable();
        addOrdelete = function (id, name, unit, price) {
            let i = document.getElementById(id);
            if(i.checked) {
                t.row.add([
                    id,
                    name,
                    unit,
                    price,
                    '<input type="number" name="a" id="a" min="1" value="' + id + '" ' +
                    'onchange="getUnitandPrice(id, this)"/>'
                ]).draw().node().id = id;
                // for(let i = 0; i < t.rows().length; i++) {
                //     let amounts = t.row([i]).data();
                //     console.log(amounts[4]);}
                var data = t.column(0).data().toArray();
                var p = t.column(4).$('input').serialize(); // Mang p la: name1=value1&name2=value2
                var pp = p.slice(2);
                var split = pp.split("&a=");
                for(let i=0; i<data.length;i++) {
                    // console.log(data[i]);
                    console.log(split[i]);
                }

            }
            else
                t.row('#' + id).remove().draw();
        }

        getDataB4Submit = function () {
            let array = t.column(4).$('input').serialize();
            var pp = array.slice(2);
            var split = pp.split("&a=");
            let drugs = t.column(0).data().toArray();
            let str="";
            let hiddenInput = $("#drugs");

            for(let i = 0; i < t.rows().length; i++) {
                let drug = drugs[i];
                let amount = split[i];
                if(drug !== "" && amount !== "") {
                    str += drug + "-" + amount + ";";
                }
            }
            if(str !== "")
                hiddenInput.value = str;
            // console.log("STR:",str);
            document.querySelector("#addbill").submit();
        }

        // getUnitandPrice = function () {
        //     let price = document.querySelectorAll("td:nth(3)");
        // }
        //
        // total = function () {
        //
        // }

    })
</script>

<script src="<c:url value="/resources/vendors/datatables.net/jquery.dataTables.js"/>"></script>
<script src="<c:url value="/resources/vendors/datatables.net-bs4/dataTables.bootstrap4.js"/>"></script>
<script src="<c:url value="/resources/js/dataTables.select.min.js"/>"></script>
<script src="<c:url value="/resources/vendors/sweetalert/sweetalert.min.js" />"></script>
<script src="<c:url value="/resources/js/alerts.js"/>"></script>