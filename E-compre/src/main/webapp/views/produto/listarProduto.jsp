<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="model.Produto" %>
    <%@page import="java.util.Set" %>
    <%@page import="java.util.Collection"%>
    <%@page import="java.util.ArrayList"%>

<%
Collection<Produto> produtos = new ArrayList<Produto>();
if(request.getAttribute("produtosCadastrados") != null)
	produtos =
		(Collection<Produto>) request.getAttribute("produtosCadastrados");
%>
    
<div class="container">
	<div class="row">
		<div class="col-xl-12 d-flex flex-row">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/produto/cadastrar" role="button">
			Cadastrar novo produto
			</a>
		</div>
	</div>
</div>

<div class="row mt-3">
	<div class="col-xl-12">
		<table id="dtProdutos" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th class="th-sm">Id</th>
					<th class="th-sm">Nome</th>
					<th class="th-sm">Descrição</th>
					<th class="th-sm">Categoria</th>
					<th class="th-sm">Preço</th>
					<th class="th-sm">Quantidade</th>
					<th class="th-sm"></th>
				</tr>
			</thead>
			<tbody>
				<%
					
					for(Produto p : produtos)
					{
						out.println("<tr>");
						
						out.println("<td>" + p.getId() + "</td>");
						out.println("<td>" + p.getNome() + "</td>");
						out.println("<td>" + p.getDescricao() + "</td>");
						out.println("<td>" + p.getCategoria() + "</td>");
						out.println("<td>" + p.getPreco() + "</td>");
						
						out.println("<td>");
						out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
						out.println("href=\"");
						out.println(request.getContextPath());
						out.println("/pessoa/editar?idproduto=");
						out.println(p.getId());
						out.println("\"> Editar produto </a>");
						out.println("</td>");
						
						out.println("<td>");
						out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
						out.println("href=\"");
						out.println(request.getContextPath());
						out.println("/pessoa/excluir?idproduto=");
						out.println(p.getId());
						out.println("\"> Excluir produto </a>");
						out.println("</td>");
						out.println("</tr>");
					}
				%>
			</tbody>
		</table>
	
	</div>

</div>