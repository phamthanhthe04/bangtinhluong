<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Quản Lí Lương</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Tính Lương </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">TinhLuong</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Danh sách lương</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newLuong" class="btn btn-success">Thêm nhân viên</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã bảng lương</th>
						<th>Mã nhân viên</th>
						<th>Tháng năm</th>
						<th>Tổng số giờ làm</th>
						<th>Hệ số lương</th>
						<th>Lương theo giờ</th>
						<th>Phụ cấp</th>
						<th>Tổng lương</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="tinhluong" items="${listLuong}">

						<tr>
							<td><c:out value="${tinhluong.maBangLuong}" /></td>
							<td><c:out value="${tinhluong.maNV}" /></td>
							<td><c:out value="${tinhluong.thangNam}" /></td>
							<td><c:out value="${tinhluong.tongSoGioLam}" /></td>
							<td><c:out value="${tinhluong.heSoLuong}" /></td>
							<td><c:out value="${tinhluong.luongTheoGio}" /></td>
							<td><c:out value="${tinhluong.phuCap}" /></td>
							<td><c:out value="${tinhluong.tongLuong}" /></td>
							<td>
                    <a href="editLuong?maBangLuong=<c:out value='${tinhluong.maBangLuong}'/>" class="btn btn-warning">Sửa</a>
                    <a href="deleteLuong?maBangLuong=<c:out value='${tinhluong.maBangLuong}'/>" class="btn btn-danger"
                       onclick="return confirm('Bạn có chắc chắn muốn xóa nhân viên này?');">Xóa</a>
                </td>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>