<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Pessoa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Pessoa p = (Pessoa) request.getAttribute("pessoa");
%>
<form method="POST"
	  action="${pageContext.request.contextPath}/pessoa/excluir">
	
	
	<input name="idpessoa" type="hidden" value="<%=p.getId()%>" readonly>
	
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome" value="<%=p.getNome()%>" readonly>
	</p>
	
	<p>
		<label for="numCpf">CPF:</label>
		<input type="text" name="numCpf" value="<%=p.getCpf()%>" readonly>
	</p>
	
	<label for="sexo">Sexo</label>

	<select name="sexo" id="sexo" value="<%=p.getSexo()%>" readonly>
	  <option value="Masculino">Masculino</option>
	  <option value="Feminino">Feminino</option>
	  <option value="Diadico">Diádico</option>
	  <option value="Intersexo">Intersexo</option>
	  <option value="Altersexo">Altersexo</option>
	</select>
	
	<p>
		<label for="txtTelefone">Telefone:</label>
		<input type="text" name="txtTelefone" value="<%=p.getTelefone()%>" readonly>
	</p>
	
	<p>
		<label for="txtRua">Rua:</label>
		<input type="text" name="txtRua" value="<%=p.getRua()%>" readonly>
	</p>
	
	<p>
		<label for="txtBairro">Bairro:</label>
		<input type="text" name="txtBairro" value="<%=p.getBairro()%>" readonly>
	</p>
	
	<p>
		<label for="txtCidade">Cidade:</label>
		<input type="text" name="txtCidade" value="<%=p.getCidade()%>" readonly>
	</p>
	
	
	<label for="UF">Estado:</label>
	<select id="UF" name="UF" value="<%=p.getEstado()%>" readonly>
	    <option value="">Selecione</option>
	    <option value="AC">AC</option>
	    <option value="AL">AL</option>
	    <option value="AP">AP</option>
	    <option value="AM">AM</option>
	    <option value="BA">BA</option>
	    <option value="CE">CE</option>
	    <option value="DF">DF</option>
	    <option value="ES">ES</option>
	    <option value="GO">GO</option>
	    <option value="MA">MA</option>
	    <option value="MS">MS</option>
	    <option value="MT">MT</option>
	    <option value="MG">MG</option>
	    <option value="PA">PA</option>
	    <option value="PB">PB</option>
	    <option value="PR">PR</option>
	    <option value="PE">PE</option>
	    <option value="PI">PI</option>
	    <option value="RJ">RJ</option>
	    <option value="RN">RN</option>
	    <option value="RS">RS</option>
	    <option value="RO">RO</option>
	    <option value="RR">RR</option>
	    <option value="SC">SC</option>
	    <option value="SP">SP</option>
	    <option value="SE">SE</option>
	    <option value="TO">TO</option>
	</select>
	
	
	<p>
		<label for="txtEmail">Email:</label>
		<input type="text" name="txtEmail" value="<%=p.getEmail()%>" readonly>
	</p>
	
	<p>
		<label for="txtSenha">Senha:</label>
		<input type="text" name="txtSenha" value="<%=p.getSenha()%>" readonly>
	</p>
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>
</body>
</html>