<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD

<form method="POST"
	  action="${pageContext.request.contextPath}/compra/registrar">
=======
<jsp:include page="../../template.jsp"/>

<form method="POST"
	  action="${pageContext.request.contextPath}/compra/cadastrar">
>>>>>>> a944c0512718310266e59e6831ed26a1fcc80aca
	
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