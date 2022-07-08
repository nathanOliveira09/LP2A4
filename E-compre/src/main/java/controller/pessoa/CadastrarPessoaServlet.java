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
 * Servlet implementation class CadastrarPessoaServlet
 */
@WebServlet({"/pessoa/cadastrar","/pessoa/cadastro","/admin/cadastrar"})
public class CadastrarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("tituloPagina", "Cadastrar Pessoa");
		request.setAttribute("pathPagina", "/views/pessoa/cadastrar.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pessoa p = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		p.setNome(request.getParameter("txtNome"));
		p.setCpf(request.getParameter("numCpf"));
		p.setSexo(request.getParameter("sexo"));
		p.setTelefone(request.getParameter("txtTelefone"));
		p.setRua(request.getParameter("txtRua"));
		p.setBairro(request.getParameter("txtBairro"));
		p.setCidade(request.getParameter("txtCidade"));
		p.setEstado(request.getParameter("UF"));
		p.setEmail(request.getParameter("txtEmail"));
		p.setSenha(request.getParameter("txtSenha"));
		p.setRole("admin");
		
		
		pessoaDAO.criarPessoa(p);

		Collection<Pessoa> pessoas = pessoaDAO.recuperarPessoas();
		
		request.setAttribute("pessoasCadastradas", pessoas);
		request.setAttribute("tituloPagina", "Cadastrar Pessoa");
		request.setAttribute("pathPagina", "/views/pessoa/listar.jsp");
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
		
		
		//doGet(request, response);
	}

}
