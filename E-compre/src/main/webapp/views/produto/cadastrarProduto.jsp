<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../template.jsp"/>

<form method="POST"
	  action="${pageContext.request.contextPath}/produto/cadastrar">
	
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome">
	</p>
	
	<p>
		<label for="txtDescricao">Descrição:</label>
		<input type="text" name="txtDescricao">
	</p>
	
	<p>
		<label for="txtCategoria">Categoria:</label>
		<input type="text" name="txtCategoria">
	</p>
	 
	
	<p>
		<label for="txtPreco">Preço:</label>
		<input type="text" name="txtPreco">
	</p>
	
	<p>
		<label for="txtQuantidade">Quantidade:</label>
		<input type="text" name="txtQuantidade">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>