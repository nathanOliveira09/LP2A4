<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>

<%
Produto p = (Produto) request.getAttribute("produto");
%>
<form method="POST"
	  action="${pageContext.request.contextPath}/produto/editar">
	
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome" value="<%=p.getNome()%>">
	</p>
	
	<p>
		<label for="txtDescricao">Descrição:</label>
		<input type="text" name="txtDescricao" value="<%=p.getDescricao()%>">
	</p>
	
	<p>
		<label for="txtCategoria">Categoria:</label>
		<input type="text" name="txtCategoria" value="<%=p.getCategoria()%>">
	</p>
	 
	
	<p>
		<label for="txtPreco">Preço:</label>
		<input type="text" name="txtPreco" value="<%=p.getPreco()%>">
	</p>
	
	<p>
		<label for="txtQuantidade">Quantidade:</label>
		<input type="text" name="txtQuantidade" value="<%=p.getQtd()%>">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>