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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		request.setAttribute("tituloPagina", "Editar Pessoa");
		request.setAttribute("pathPagina", "/pessoa/listar.jsp");
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
		
		
	}

}
