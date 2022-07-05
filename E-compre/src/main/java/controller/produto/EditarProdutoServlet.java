package controller.produto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.Produto;
import model.repositorio.PessoaDAO;
import model.repositorio.ProdutoDAO;

import java.io.IOException;

/**
 * Servlet implementation class EditarProdutoServlet
 */
public class EditarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idProduto=0;
		Produto p = null;
		String idInformado = request.getParameter("idproduto");
		
		if (idInformado != null) {
			try {
				idProduto = Integer.parseInt(idInformado);
			} catch (Exception e) {
				System.out.println("O ID informado é inválido.");
			} 
		}
		
		ProdutoDAO produto = new ProdutoDAO();
		
		p = produto.recuperarProdutoPorId(idProduto);
		
		request.setAttribute("tituloPagina", "Editar Produto");
		request.setAttribute("pathPagina", "/produto/editar.jsp");
		request.setAttribute("produtos", p);
		
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
