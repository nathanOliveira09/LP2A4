package controller.compra;

import java.io.IOException;
import java.util.Collection;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import model.Compra;
import model.Produto;
import model.repositorio.CompraDAO;
import model.repositorio.ProdutoDAO;

/**
 * Servlet implementation class ExcluirPessoaServlet
 */
public class ExcluirPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ExcluirPessoaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCompra=0;
		Compra c = new Compra();
		
		Produto p = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		String idInformado = request.getParameter("idcompra");
		
		if (idInformado != null) {
			try {
				idCompra = Integer.parseInt(idInformado);
			} catch (Exception e) {
				System.out.println("O ID da compra informado é inválido");
			}
		}
		CompraDAO compra = new CompraDAO();
		c = compra.recuperarCompraPorId(idCompra);
		p = produtoDAO.recuperarProdutoPorId(c.getProdutos().getId());
		
		request.setAttribute("tituloPagina", "Editar Compra");
		request.setAttribute("pathPagina", "/views/compra/editarCompra.jsp");
		request.setAttribute("produto", p);
		request.setAttribute("compra", c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compra c = new Compra();
		CompraDAO compraDAO = new CompraDAO();
		
		Produto p = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		c.setId(Integer.parseInt(request.getParameter("idCompra")));
		c.setNumeroNF(Long.parseLong(request.getParameter("numNF")));
		c.setProdutos(produtoDAO.recuperarProdutoPorId(Integer.parseInt(request.getParameter("idProduto"))));
		c.setQuantidade(Integer.parseInt(request.getParameter("quantidadeProduto")));
		

		compraDAO.editarCompra(c);
		
		Collection<Compra> compras = compraDAO.recuperarComprasEProdutos();
		
		request.setAttribute("comprasRegistradas", compras);
		request.setAttribute("tituloPagina", "Registrar compras");
		request.setAttribute("pathPagina", "/views/compra/listarCompras.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

}
