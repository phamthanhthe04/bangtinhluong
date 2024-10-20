<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Bảng Tính Lương</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> Bảng lương </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Bảng lương</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${tinhluong != null}">
					<form action="updateLuong" method="post">
					 <input type="hidden" name="maBangLuong" value="<c:out value='${tinhluong.maBangLuong}' />"/>
				</c:if>
				<c:if test="${tinhluong == null}">
					<form action="insertLuong" method="post">
				</c:if>

					<h2>
						<c:if test="${tinhluong != null}">
            			Sửa bảng lương
            		</c:if>
						<c:if test="${tinhluong == null}">
            			Thêm lương
            		</c:if>
					</h2>

				<fieldset class="form-group">
					<label>Mã nhân viên</label> <input type="text"
						value="<c:out value='${tinhluong.maNV}' />" class="form-control"
						name="maNV" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Tháng năm</label> <input type="text"
						value="<c:out value='${tinhluong.thangNam}' />" class="form-control"
						name="thangNam">
				</fieldset>

				<fieldset class="form-group">
					<label>Tổng số giờ làm</label> <input type="number"
						value="<c:out value='${tinhluong.tongSoGioLam}' />" class="form-control"
						name="tongSoGioLam">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Hệ số lương</label> <input type="number"
						value="<c:out value='${tinhluong.heSoLuong}' />" class="form-control"
						name="heSoLuong">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Lương theo giờ</label> <input type="number"
						value="<c:out value='${tinhluong.luongTheoGio}' />" class="form-control"
						name="luongTheoGio">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Phụ cấp </label> <input type="number"
						value="<c:out value='${tinhluong.phuCap }' />" class="form-control"
						name="phuCap">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>