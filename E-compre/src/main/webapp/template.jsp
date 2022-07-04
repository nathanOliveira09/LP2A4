<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String tituloPagina = "Index";
String pathView = "/index";
if(request.getAttribute("tituloPagina") != null)
	tituloPagina = (String) request.getAttribute("tituloPagina");
if(request.getAttribute("pathView") != null)
	pathView = (String) request.getAttribute("pathView");
%>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%=tituloPagina%></title>
    
    
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
	<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/custom.css" /> --%>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbars/">
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	
	<!-- DataTables -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"/>
	
    <!-- Custom styles for this template -->
    <link href="navbar.css" rel="stylesheet">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light" aria-label="Fifth navbar example">
		    <div class="container-fluid">
		      <a class="navbar-brand" href="#">E-compre</a>
		      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample05" aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="navbar-toggler-icon"></span>
		      </button>
		
		      <div class="collapse navbar-collapse" id="navbarsExample05">
		        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="#">Home</a>
		          </li>
		          <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-bs-toggle="dropdown" aria-expanded="false">Comprar</a>
		            <ul class="dropdown-menu" aria-labelledby="dropdown05">
		              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/produtos">Ver produtos</a></li>
		              <li><a class="dropdown-item" href="#">Buscar produto por ID</a></li>
		              <li><a class="dropdown-item" href="#">Buscar produto por categoria</a></li>
		            </ul>
		          </li>
		          <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-bs-toggle="dropdown" aria-expanded="false">Administrador</a>
		            <ul class="dropdown-menu" aria-labelledby="dropdown05">
		              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/pessoa/listar">Ver pessoas</a></li>
		              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/produto/listar">Ver produtos</a></li>
		              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/compra/listar">Ver compras</a></li>
		            </ul>
		          </li>
		        </ul>
		        
		      </div>
		    </div>
		  </nav>
	</header>
    
	<div class="container">
		<h1><%=tituloPagina%></h1>
		<main>
			<% String pathPagina = (String) request.getAttribute("pathpagina"); %>
			<jsp:include page="${pathPagina}"/>
		</main>
	</div>
	


    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/script.js"></script>
    <script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

      
  </body>
</html>
<%-- <!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title><%=(String) request.getAttribute("tituloPagina") %></title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/starter-template/">
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icon.css">
    <link rel="stylesheet" type="text/css" href="./css/custom.css">
    
    
	<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/css/custom.css />

    <!-- Bootstrap core CSS -->
	<link href="./css/bootstrap.min.css" rel="stylesheet" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">


	<!-- DataTables -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.css"/>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js"></script>

    <!-- Favicons -->
	<link rel="apple-touch-icon" href="/docs/4.6/./img/favicons/apple-touch-icon.png" sizes="180x180">
	<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
	<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
	<link rel="manifest" href="/docs/4.6/assets/img/favicons/manifest.json">
	<link rel="mask-icon" href="/docs/4.6/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
	<link rel="icon" href="/docs/4.6/assets/img/favicons/favicon.ico">
	<meta name="msapplication-config" content="/docs/4.6/assets/img/favicons/browserconfig.xml">
	<meta name="theme-color" content="#563d7c">

    <!-- Custom styles for this template -->
    <link href="./css/starter-template.css" rel="stylesheet">
  </head>
  <body>
    
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">E-compre</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
    
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/index">Início</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">Produtos</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/produtos">Ver produtos</a>
          <a class="dropdown-item" href="#">Buscar produtos por id</a>
          <a class="dropdown-item" href="#">Buscar produtos por categoria</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Minhas compras</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled">Disabled</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">Pessoas</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/pessoa/visualizar">Ver pessoas</a>
          <a class="dropdown-item" href="#">Buscar pessoa por id</a>
          <a class="dropdown-item" href="#">Editar pessoa</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<main role="main" class="container">

  <div class="starter-template">
    <h1><%=(String) request.getAttribute("tituloPagina")%></h1>
    <%
    	if((String) request.getAttribute("subtituloPagina") != null)
    	{
    		out.print("<p class=\"lead\">");
    		out.print((String) request.getAttribute("subtituloPagina"));
    		out.println("</p>");
    	}
    %>
  </div>
  <%
  String pathPagina = (String)request.getAttribute("pathPagina");
  %>
  
  <jsp:include page="${pathPagina}" />

</main><!-- /.container -->


	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.6/./js/vendor/jquery.slim.min.js"><\/script>')</script>
      <script src="./js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

      
  </body>
</html> --%>