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
 * Servlet implementation class RegistrarCompraServlet
 */
public class RegistrarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrarCompraServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compra c = new Compra();
		CompraDAO compraDAO = new CompraDAO();
		
		Produto p = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		c.setNumeroNF(Long.parseLong(request.getParameter("numNF")));
		c.setProdutos(produtoDAO.recuperarProdutoPorId(Integer.parseInt(request.getParameter("idProduto"))));
		c.setQuantidade(Integer.parseInt(request.getParameter("quantidadeProduto")));
		
		compraDAO.registrarCompra(c);
		
		Collection<Compra> compras = compraDAO.recuperarComprasEProdutos();
		
		request.setAttribute("comprasRegistradas", compras);
		request.setAttribute("tituloPagina", "Registrar compras");
		request.setAttribute("pathPagina", "/compra/listar.jsp");
		

	}

}
