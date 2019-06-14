<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron my-5">
			<h1 class="display-4">DASHBOARD</h1>
			<hr class="my-4">
			
			<jsp:include page="feedback.jsp"></jsp:include>
			
			<a class="btn btn-success btn-lg" href="ClientesController?action=list">Listar Clientes</a>
			<a class="btn btn-primary btn-lg" href="ProdutosController?action=list">Listar Produtos</a>
			<a class="btn btn-danger btn-lg" href="index.jsp">Logout</a>
		</div>
	</div>
</body>
</html>