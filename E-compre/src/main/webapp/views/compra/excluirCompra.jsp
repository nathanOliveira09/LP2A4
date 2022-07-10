<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Produto" %>
<%@ page import="model.Compra" %>
<%
Produto p = (Produto) request.getAttribute("produto");
Compra c = (Compra) request.getAttribute("compra");
%>
<form method="POST"
	  action="${pageContext.request.contextPath}/compra/excluir">
	<input type="hidden" name="idCompra" value="<%=c.getId()%>">
	
	<p>
		<label for="idCompra">Id compra:</label>
		<input type="text" name="idCompra" value="<%=c.getId()%>">
	</p>
	
	<p>
		<label for="idProduto">Id produto:</label>
		<input type="text" name="idProduto" value="<%=p.getId()%>">
	</p>
	
	<p>
		<label for="nomeProduto">Nome produto:</label>
		<input type="text" name="nomeProduto" value="<%=p.getNome()%>">
	</p>
	
	<p>
		<label for="quantidadeProduto">Quantidade:</label>
		<input type="number" name="quantidadeProduto" value="<%=c.getQuantidade()%>">
	</p>
	
	<p>
		<label for="numNF">Número NF:</label>
		<input type="text" name="numNF" value="<%=c.getNumeroNF()%>">
	</p>
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>