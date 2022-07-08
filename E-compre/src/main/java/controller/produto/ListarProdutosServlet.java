 package controller.produto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;
import model.repositorio.ProdutoDAO;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ListarProdutosServlet
 */
public class ListarProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProdutosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Collection<Produto> produtos = produtoDAO.recuperarProdutos();
		
		request.setAttribute("produtosCadastrados", produtos);
		request.setAttribute("tituloPagina", "Cadastro de produtos");
		request.setAttribute("pathPagina", "/views/produto/listarProduto.jsp");
		request.setAttribute("produtosCadastrados", produtos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
