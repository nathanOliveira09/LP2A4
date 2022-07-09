package controller.compra;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Compra;
import model.Produto;
import model.repositorio.CompraDAO;
import model.repositorio.ProdutoDAO;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class EditarCompraServlet
 */
public class EditarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCompra=0;
		Compra c = null;
		String idInformado = request.getParameter("idcompra");
		
		if (idInformado != null) {
			try {
				idCompra = Integer.parseInt(idInformado);
			} catch (Exception e) {
				System.out.println("O ID da compra informado é inválido");
			}
		}
		CompraDAO compra = new CompraDAO();
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compra c = new Compra();
		CompraDAO compraDAO = new CompraDAO();
		
		Produto p = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		c.setNumeroNF(Long.parseLong(request.getParameter("numNF")));
		c.setProdutos(produtoDAO.recuperarProdutoPorId(Integer.parseInt(request.getParameter("idProduto"))));
		c.setQuantidade(Integer.parseInt(request.getParameter("quantidadeProduto")));
		
		compraDAO.atualizarCompra(c);
		
		Collection<Compra> compras = compraDAO.recuperarComprasEProdutos();
		
		request.setAttribute("comprasRegistradas", compras);
		request.setAttribute("tituloPagina", "Registrar compras");
		request.setAttribute("pathPagina", "/compra/listar.jsp");
	}

}
