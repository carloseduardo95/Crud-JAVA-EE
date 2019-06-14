<%@page import="java.util.Iterator"%>
<%@page import="model.Clientes"%>
<%@page import="java.util.List"%>
<%@page import="modelDAO.ClientesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Listagem de Clientes</title>
</head>
<body>
	<div class="container">
		<h1 class="display-4 my-5">Clientes</h1>
		<hr>
		<a class="btn btn-dark" href="dashboard.jsp">Inicio</a>
		<a class="btn btn-success" href="ClientesController?action=add">Adicionar novo</a>
		
		<jsp:include page="/feedback.jsp"></jsp:include>
		
		<table class="table table-hover table-bordered mt-5" border="1">
			<thead class="thead-dark">
				<tr class="text-center">
					<th>ID</th>
					<th>NOME</th>
					<th>TELEFONE</th>
					<th>EMPRESA</th>
					<th>EMAIL</th>
					<th>SENHA</th>
					<th>AÇÕES</th>
				</tr>
			</thead>
			<%
				ClientesDAO dao = new ClientesDAO();
				List<Clientes>list = dao.list();
				Iterator<Clientes>iter = list.iterator();
				Clientes cli = null;
				while(iter.hasNext()){
					cli = iter.next();
				
			%>
			<tbody>
				<tr class="text-center">
					<td><%= cli.getId()%></td>
					<td><%= cli.getNome()%></td>
					<td><%= cli.getTelefone()%></td>
					<td><%= cli.getEmpresa()%></td>
					<td><%= cli.getEmail()%></td>
					<td><%= cli.getSenha()%></td>
					<td>
						<a class="btn btn-primary" href="ClientesController?action=edit&id=<%= cli.getId()%>">Editar</a>
						<a class="btn btn-danger text-white" onclick="confirmarExcluir(<%= cli.getId()%>)">Excluir</a>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript">

	function confirmarExcluir(id) {
		
		var desejaRealmenteExcluir = confirm("Deseja realmente excluir o cliente com id: "+id+" ?")
		
		if (desejaRealmenteExcluir) {
			window.location = "ClientesController?action=deletar&id="+id; 	
		}
	}
	
	</script>
</body>
</html>