<%@page import="model.Produtos"%>
<%@page import="modelDAO.ProdutosDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Editar Produto</title>
</head>
<body>
	<div class="container">
		<div class="col-lg-6 mx-auto">
			<%
			ProdutosDAO dao = new ProdutosDAO();
			int id = Integer.parseInt((String)request.getAttribute("idprod"));
			Produtos p1 = (Produtos)dao.list(id);
			%>
			
			<h1 class="display-4 my-5">Editar Produto</h1>
			<hr>
			
			<form action="ProdutosController">
				<label for="txtDni">NOME:</label>
				<input class="form-control mb-3" type="text" name="txtNome" value="<%= p1.getNome()%>" required>
				<label for="txtNome">PREÇO:</label>
				<input class="form-control mb-3" type="text" name="txtPreco" value="<%= p1.getPreco()%>" required>
				
				<input type="hidden" name="txtId" value="<%= p1.getId()%>">
				<input class="btn btn-primary btn-lg" type="submit" name="action" value="Editar">
				<a class="btn btn-dark btn-lg" href="ProdutosController?action=list">Voltar</a>
			</form>
		</div>
	</div>
</body>
</html>