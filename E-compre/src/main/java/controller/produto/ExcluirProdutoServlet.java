package controller.produto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;
import model.repositorio.ProdutoDAO;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ExcluirProdutoServlet
 */
public class ExcluirProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirProdutoServlet() {
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
		request.setAttribute("pathPagina", "/views/produto/excluirProduto.jsp");
		request.setAttribute("produto", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto p = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		double precoInformado = Double.parseDouble(request.getParameter("txtPreco"));
		int quantidadeInformada = Integer.parseInt(request.getParameter("txtQuantidade"));
		
		p.setNome(request.getParameter("txtNome"));
		p.setDescricao(request.getParameter("txtDescricao"));
		p.setCategoria(request.getParameter("txtCategoria"));
		p.setPreco(precoInformado);
		p.setQtd(quantidadeInformada);
		System.out.println(request.getParameter("idproduto"));
		p.setId(Integer.parseInt(request.getParameter("idproduto")));
		
		produtoDAO.removerProduto(p.getId());
		
		Collection<Produto> produtos = produtoDAO.recuperarProdutos();
		
		request.setAttribute("produtosCadastrados", produtos);
		request.setAttribute("tituloPagina", "Produtos cadastrados");
		request.setAttribute("pathPagina", "/views/produto/listarProduto.jsp");
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

}
