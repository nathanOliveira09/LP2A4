<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="POST"
	  action="${pageContext.request.contextPath}/compra/registrar">
	
	<p>
		<label for="idProduto">Id produto:</label>
		<input type="text" name="idProduto">
	</p>
	
	<p>
		<label for="quantidadeProduto">Quantidade:</label>
		<input type="number" name="quantidadeProduto">
	</p>
	
	<p>
		<label for="numNF">Número NF:</label>
		<input type="text" name="numNF">
	</p>
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>