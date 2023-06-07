<%--
Created by IntelliJ IDEA.
User: DANG HIEU
Date: 3/18/2023
Time: 6:12 PM
To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <title>QUAN LI TAI NGHE</title>
    <script>
        function validate() {
            var ma = document.getElementById("ma");
            var ten = document.getElementById("ten");

            var valid = true;
            if (ma.value.length <= 0 || ten.value.length <= 0) {
                alert("không được để trống!");
                valid = false;
            }
            return valid;
        };
    </script>
</head>
<body class="container">
<table>
    <h2 align="center">UPDATE Tai Nghe</h2><br/>
<div style="height: auto;
    width: 90%;
    padding: 10px;max-width: 500px;">
    <form action="/ASM/tai-nghe/update/${Detail.taiNgheId}" method="post" >
        <div class="form-group">
            <label for="tenTaiNghe">Ten:</label>
            <input required="true" type="text" class="form-control"
                   id="tenTaiNghe" name="tenTaiNghe" value="${Detail.tenTaiNghe}">
        </div>
        <div class="form-group">
            <label for="slt">So luong ton:</label>
            <input required="true" type="text" class="form-control"
                   id="slt" name="soLuongTon"  value="${Detail.soLuongTon}">
        </div>
        <div class="form-group">
            <label for="tanSo">Tan So:</label>
            <input type="text" class="form-control"
                   id="tanSo" name="tanSo"  value="${Detail.tanSo}">
        </div>
        <div class="form-group">
            <label for="congKetNoi">Cong Ket Noi:</label>
            <select class="form-select" aria-label="Default select example" name="congKetNoi"
                    id="congKetNoi">
                <option value="3.5" ${Detail.congKetNoi == "3.5"?"selected":""}>3.5</option>
                <option value="Type-C" ${Detail.congKetNoi == "Type-C"?"selected":""}>Type-C</option>
                <option value="Bluetooth" ${Detail.congKetNoi == "Bluetooth"?"selected":""}>Bluetooth</option>
                <option value="Lightning" ${Detail.congKetNoi == "Lightning"?"selected":""}>Lightning</option>
            </select>
        </div>
        <div class="form-group">
            <label for="donGia">Don Gia:</label>
            <input required="true" type="text" class="form-control"
                   id="donGia" name="donGia"  value="${Detail.donGia}">
        </div>
        <div class="form-group">
            <label for="kichThuocMangLoa">Kich Thuoc Mang Loa:</label>
            <input type="text" class="form-control"
                   id="kichThuocMangLoa" name="kichThuocMangLoa"  value="${Detail.kichThuocMangLoa}">
        </div><br/>
        <button class="btn btn-success" type="submit" onclick="return confirmAction()">Update</button>
        <a href="/ASM/tai-nghe" class="btn btn-danger">Close</a>
    </form>
</div>

</table>
<script>
    function confirmAction() {
        return confirm("Bạn có chắc chắn muốn thực hiện thao tác này không?");
    }
</script>
</body>

</html>
