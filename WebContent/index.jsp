<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logar no sistema</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">

	<div class="jumbotron mt-5">
	 	<h1 class="display-4" align="left">Login</h1>
	 	
	 	<jsp:include page="feedback.jsp"></jsp:include>
		<jsp:include page="feedback_erro.jsp"></jsp:include>
		
		<form action="LoginController" method="post">
			<div class="form-group">
		    	<label for="email">Email</label>
		    	<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Entre com o seu email" required>
		    	<small id="emailHelp" class="form-text text-muted">Este é um campo de dica do email.</small>
		  	</div>
		
			<div class="form-group">
		    	<label for="senha">Senha</label>
		    	<input type="password" class="form-control" id="senha" name="senha" aria-describedby="senhaHelp" placeholder="Entre com a sua senha" required>
		    	<small id="senhaHelp" class="form-text text-muted">Nunca compartilhe a sua senha com estranhos.</small>
		  	</div>
		  	
			<button class="btn btn-dark" type="submit">Entrar</button>
		</form>
	</div>
</div>

</body>
</html>