<%@page import="java.util.Iterator"%>
<%@page import="model.Produtos"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.ProdutosDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Listagem de Produtos</title>
</head>
<body>
	<div class="container">
		<h1 class="display-4 my-5">Produtos</h1>
		<hr>
		<a class="btn btn-dark" href="dashboard.jsp">Inicio</a>
		<a class="btn btn-success" href="ProdutosController?action=add">Adicionar novo</a>
		
		<jsp:include page="/feedback.jsp"></jsp:include>
		
		<table class="table table-hover table-bordered mt-5" border="1">
			<thead class="thead-dark">
				<tr class="text-center">
					<th>ID</th>
					<th>NOMES</th>
					<th>PREÇOS</th>
					<th>AÇÕES</th>
				</tr>
			</thead>
			<%
				ProdutosDAO prodao = new ProdutosDAO();
				List<Produtos>list = prodao.list();
				Iterator<Produtos>iter = list.iterator();
				Produtos prod = null;
				while(iter.hasNext()){
					prod = iter.next();
				
			%>
			<tbody>
				<tr class="text-center">
					<td><%= prod.getId()%></td>
					<td><%= prod.getNome()%></td>
					<td><%= prod.getPreco()%></td>
					<td>
						<a class="btn btn-primary" href="ProdutosController?action=edit&id=<%= prod.getId()%>">Editar</a>
						<a class="btn btn-danger text-white" onclick="confirmarExcluir(<%= prod.getId()%>)">Excluir</a>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript">

	function confirmarExcluir(id) {
		
		var desejaRealmenteExcluir = confirm("Deseja realmente excluir o produto com id: "+id+" ?")
		
		if (desejaRealmenteExcluir) {
			window.location = "ProdutosController?action=deletar&id="+id; 	
		}
	}
	
	</script>
</body>
</html>