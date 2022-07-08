package controller.pessoa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.repositorio.PessoaDAO;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ExcluirPessoaServlet
 */

@WebServlet({"/pessoa/excluir","/admin/excluir","/user/excluir"})
public class ExcluirPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idPessoa=0;
		Pessoa p = null;
		String idInformado = request.getParameter("idpessoa");
		
		if (idInformado != null) {
			try {
				idPessoa = Integer.parseInt(idInformado);
			} catch (Exception e) {
				System.out.println("O ID informado é inválido.");
			}
		}
		
		PessoaDAO pessoa = new PessoaDAO();
		
		p = pessoa.recuperarPessoa(idPessoa);
		
		request.setAttribute("tituloPagina", "Excluir Pessoa");
		request.setAttribute("pathPagina", "/views/pessoa/excluir.jsp");
		request.setAttribute("pessoa", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idPessoa=0;
		String idInformado = request.getParameter("idpessoa");
		
		if (idInformado != null) {
			try {
				idPessoa = Integer.parseInt(idInformado);
			} catch (Exception e) {
				System.out.println("O ID informado é inválido.");
			}
		}
		
		PessoaDAO pessoa = new PessoaDAO();
		
		pessoa.removerPessoa(idPessoa);
		Collection<Pessoa> pessoas = pessoa.recuperarPessoas();
		
		request.setAttribute("pessoasCadastradas", pessoas);
		request.setAttribute("tituloPagina", "Excluir Pessoa");
		request.setAttribute("pathPagina", "/views/pessoa/listar.jsp");
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
		
		
	}

}
