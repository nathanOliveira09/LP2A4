<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="model.Compra" %>
    <%@page import="java.util.Set" %>
    <%@page import="java.util.Collection"%>
    <%@page import="java.util.ArrayList"%>

<%
Collection<Compra> compras = new ArrayList<Compra>();
if(request.getAttribute("comprasRegistradas") != null)
	compras =
		(Collection<Compra>) request.getAttribute("comprasRegistradas");
%>
    
<div class="container">
	<div class="row">
		<div class="col-xl-12 d-flex flex-row">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/produto/cadastrar" role="button">
			Registrar novo produto
			</a>
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/compra/registrar" role="button">
			Registrar nova compra
			</a>
		</div>
	</div>
</div>

<div class="row mt-3">
	<div class="col-xl-12">
		<table id="dtProdutos" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th class="th-sm">Id compra</th>
					<th class="th-sm">Produto</th>
					<th class="th-sm">Categoria</th>
					<th class="th-sm">Quantidade</th>
					<th class="th-sm">Número NF:</th>
					<th class="th-sm"></th>
				</tr>
			</thead>
			<tbody>
				<%
					
					for(Compra c : compras)
					{
						out.println("<tr>");
						
						out.println("<td>" + c.getId() + "</td>");
						out.println("<td>" + c.getProdutos().getNome() + "</td>");
						out.println("<td>" + c.getProdutos().getCategoria() + "</td>");
						out.println("<td>" + c.getQuantidade() + "</td>");
						out.println("<td>" + c.getNumeroNF() + "</td>");
						
						out.println("<td>");
						out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
						out.println("href=\"");
						out.println(request.getContextPath());
						out.println("/compra/editar?idcompra=");
						out.println(c.getId());
						out.println("\"> Editar compra </a>");
						out.println("</td>");
						
						out.println("<td>");
						out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
						out.println("href=\"");
						out.println(request.getContextPath());
						out.println("/compra/excluir?idcompra=");
						out.println(c.getId());
						out.println("\"> Excluir compra </a>");
						out.println("</td>");
						out.println("</tr>");
					}
				%>
			</tbody>
		</table>
	
	</div>

</div>