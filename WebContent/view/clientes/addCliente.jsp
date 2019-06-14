<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Adicionar Cliente</title>
</head>
<body>
	<div class="container">
		<div class="col-lg-6 mx-auto">
			<h1 class="display-4 my-5">Adicionar Cliente</h1>
			<hr>
			<form action="ClientesController">
				<label for="nomeCli">NOME:</label>
				<input class="form-control mb-3" type="text" name="nomeCli" min="5" max="50" required>
				
				<label for="telefoneCli">TELEFONE:</label>
				<input class="form-control mb-3" type="text" name="telefoneCli" min="8" max="9" required>
				
				<label for="empresaCli">EMPRESA:</label>
				<input class="form-control mb-3" type="text" name="empresaCli" min="5" max="15" required>
				
				<label for="emailCli">EMAIL:</label>
				<input class="form-control mb-3" type="text" name="emailCli" min="5" max="30" required>
				
				<label for="senhaCli">SENHA:</label>
				<input class="form-control mb-3" type="text" name="senhaCli" min="5" max="10" required>
				
				<input class="btn btn-primary btn-lg" type="submit" name="action" value="Adicionar">
				<a class="btn btn-dark btn-lg" href="ClientesController?action=list">Voltar</a>
			</form>
		</div>
	</div>
</body>
</html>