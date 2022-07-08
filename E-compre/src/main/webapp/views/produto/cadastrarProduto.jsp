<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="POST"
	  action="${pageContext.request.contextPath}/produto/cadastrar">
	
	<p>
		<label for="nome">Nome:</label>
		<input type="text" name="nome">
	</p>
	
	<p>
		<label for="descricao">Descrição:</label>
		<input type="text" name="descricao">
	</p>
	
	<p>
		<label for="categoria">Categoria:</label>
		<input type="text" name="categoria">
	</p>
	 
	
	<p>
		<label for="txtPreco">Preço:</label>
		<input type="text" name="txtPreco">
	</p>
	
	<p>
		<label for="qtd">Quantidade:</label>
		<input type="number" name="qtd">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>