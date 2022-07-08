package controller.produto;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import model.Pessoa;
import model.Produto;
import model.repositorio.PessoaDAO;
import model.repositorio.ProdutoDAO;

/**
 * Servlet implementation class CadastrarProdutoServlet
 */
public class CadastrarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastrarProdutoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("tituloPagina", "Cadastrar Produto");
		request.setAttribute("pathPagina", "/views/produto/cadastrarProduto.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produto p = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		String precoInformado = request.getParameter("txtPreco");
//		String quantidadeInformada = request.getParameter("qtd");
		
		p.setNome(request.getParameter("nome"));
		p.setPreco(Double.parseDouble(precoInformado));
//		p.setQtd(Integer.parseInt(quantidadeInformada));
		p.setQtd(Integer.parseInt(request.getParameter("qtd")));
		p.setCategoria(request.getParameter("categoria"));
		p.setDescricao(request.getParameter("descricao"));
		
		
		produtoDAO.criarProduto(p);
		
		Collection<Produto> produtos = produtoDAO.recuperarProdutos();
		
		request.setAttribute("produtosCadastrados", produtos);
		request.setAttribute("tituloPagina", "Cadastrar Produto");
		request.setAttribute("pathPagina", "/views/produto/listarProduto.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

}
