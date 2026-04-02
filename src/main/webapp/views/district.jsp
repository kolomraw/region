<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.District"%>
<%@ page import="dao.DistrictDAO"%>

<%
DistrictDAO dao = new DistrictDAO();
List<District> districts = dao.findAll();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Районы</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<style>
.card-box {
    background: #ffffff;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}
.table thead { background-color: #f1f3f5; }
body { background-color: #f8f9fa; }
</style>
</head>

<body>
<div class="container-fluid">

<jsp:include page="/views/header.jsp" />

<div class="container mt-4">
<div class="row g-4">

<div class="col-lg-8">
<div class="card-box">

<h4 class="mb-3">Список районов</h4>

<table class="table table-hover align-middle">
<thead>
<tr>
<th>ID</th>
<th>Название</th>
<th>Площадь</th>
<th>Адм. центр</th>
<th>Глава</th>
</tr>
</thead>

<tbody>
<%
for (District d : districts) {
%>
<tr>
<td><%= d.getId() %></td>
<td><strong><%= d.getName() %></strong></td>
<td><%= d.getArea() %></td>
<td><%= d.getAdminCenter() %></td>
<td><%= d.getHead() %></td>
</tr>
<%
}
%>
</tbody>
</table>

</div>
</div>

<div class="col-lg-4">
<div class="card-box">

<h4 class="mb-3">Новый район</h4>

<form method="POST">
<input type="text" name="name" class="form-control mb-2" placeholder="Название">
<input type="text" name="area" class="form-control mb-2" placeholder="Площадь">
<input type="text" name="adminCenter" class="form-control mb-2" placeholder="Адм. центр">
<input type="text" name="head" class="form-control mb-3" placeholder="Глава">

<button type="submit" class="btn btn-primary w-100">Добавить</button>
</form>

</div>
</div>

</div>
</div>

<jsp:include page="/views/footer.jsp" />

</div>
</body>
</html>