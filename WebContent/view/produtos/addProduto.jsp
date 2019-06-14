<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Adicionar Produtos</title>
</head>
<body>
	<div class="container">
		<div class="col-lg-6 mx-auto">
			<h1 class="display-4 my-5">Adicionar Produtos</h1>
			<hr>
			<form action="ProdutosController">
				<label for="txtNome">NOME:</label>
				<input class="form-control mb-3" type="text" name="txtNome" min="5" max="50" required>
				<label for="txtPreco">PREÇO:</label>
				<input class="form-control mb-3" type="number" name="txtPreco" required>
				
				<input class="btn btn-primary btn-lg" type="submit" name="action" value="Adicionar">
				<a class="btn btn-dark btn-lg" href="ProdutosController?action=list">Voltar</a>
			</form>
		</div>
	</div>
</body>
</html>