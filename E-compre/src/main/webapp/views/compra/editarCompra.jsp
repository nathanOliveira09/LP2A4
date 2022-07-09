<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>
<%@ page import="model.Compra" %>
<%
Produto p = (Produto) request.getAttribute("produto");
Compra c = (Compra) request.getAttribute("compra");
%>
<form method="POST"
	  action="${pageContext.request.contextPath}/compra/editar">
	<input type="hidden" name="idVenda" value="<%c.getId()%>">
	
	<p>
		<label for="idProduto">Id produto:</label>
		<input type="text" name="idProduto" value="<%=c.getProdutos().getNome()%>">
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