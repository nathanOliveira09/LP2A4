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
 * Servlet implementation class EditarPessoaServlet
 */
@WebServlet({"/pessoa/editar","/admin/editar","/user/editar"})
public class EditarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
		
		request.setAttribute("tituloPagina", "Editar Pessoa");
		request.setAttribute("pathPagina", "/views/pessoa/editar.jsp");
		request.setAttribute("pessoa", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);  
		
		
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa p = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		System.out.println(request.getParameter("idpessoa"));
		String idInformado = request.getParameter("idpessoa");
		System.out.println(idInformado);
		
		p.setId(Integer.parseInt(idInformado));
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
		
		
		pessoaDAO.editarPessoa(p);

		Collection<Pessoa> pessoas = pessoaDAO.recuperarPessoas();
		
		request.setAttribute("pessoasCadastradas", pessoas);
		request.setAttribute("tituloPagina", "Cadastrar Pessoa");
		request.setAttribute("pathPagina", "/views/pessoa/listar.jsp");
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

}
