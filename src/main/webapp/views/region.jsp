<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Region"%>

<%
List<Region> regions = (List<Region>) request.getAttribute("regions");
Region edit = (Region) request.getAttribute("editRegion");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Области</title>
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

.btn-edit {
    background-color: #e9ecef;
    border: none;
}
.btn-delete {
    background-color: #adb5bd;
    border: none;
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

<h4 class="mb-3">Список областей</h4>

<table class="table table-hover align-middle">
<thead>
<tr>
<th>ID</th>
<th>Название</th>
<th>Площадь</th>
<th>Адм. центр</th>
<th>Глава</th>
<th></th>
<th></th>
</tr>
</thead>

<tbody>
<%
for (Region r : regions) {
%>
<tr>
<td><%= r.getId() %></td>
<td><strong><%= r.getName() %></strong></td>
<td><%= r.getArea() %></td>
<td><%= r.getAdminCenter() %></td>
<td><%= r.getHead() %></td>

<td>
<a href="region?editId=<%= r.getId() %>" class="btn btn-sm btn-edit">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor">
<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10L3 14l.146-2.854 10-10z"/>
</svg>
</a>
</td>

<td>
<a href="region?deleteId=<%= r.getId() %>" class="btn btn-sm btn-delete">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor">
<path d="M5.5 5.5A.5.5 0 0 1 6 5h4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0V6H7v6.5a.5.5 0 0 1-1 0v-7z"/>
</svg>
</a>
</td>

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

<h4 class="mb-3"><%= edit != null ? "Редактировать" : "Новая область" %></h4>

<form method="POST">

<input type="hidden" name="id" value="<%= edit != null ? edit.getId() : "" %>">

<input type="text" name="name" class="form-control mb-2"
value="<%= edit != null ? edit.getName() : "" %>" placeholder="Название">

<input type="text" name="area" class="form-control mb-2"
value="<%= edit != null ? edit.getArea() : "" %>" placeholder="Площадь">

<input type="text" name="adminCenter" class="form-control mb-2"
value="<%= edit != null ? edit.getAdminCenter() : "" %>" placeholder="Адм. центр">

<input type="text" name="head" class="form-control mb-3"
value="<%= edit != null ? edit.getHead() : "" %>" placeholder="Глава">

<button type="submit" class="btn btn-primary w-100">
<%= edit != null ? "Обновить" : "Добавить" %>
</button>

</form>

</div>
</div>

</div>
</div>

<jsp:include page="/views/footer.jsp" />

</div>
</body>
</html>