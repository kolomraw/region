<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="domain.District"%>

<%
District d1 = new District(1L, "Минский район", "3000", "Минск", "Сидоров", 1L);
District d2 = new District(2L, "Гродненский район", "2000", "Гродно", "Кузнецов", 2L);
District[] districts = new District[]{d1, d2};
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

.table thead {
    background-color: #f1f3f5;
}

body {
    background-color: #f8f9fa;
}
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

<input type="text" name="name" placeholder="Название" class="form-control mb-2">
<input type="text" name="area" placeholder="Площадь" class="form-control mb-2">
<input type="text" name="adminCenter" placeholder="Адм. центр" class="form-control mb-2">
<input type="text" name="head" placeholder="Глава" class="form-control mb-3">

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