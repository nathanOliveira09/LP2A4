package controller.pessoa;
import model.repositorio.*;
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
import java.util.List;
import java.util.Set;

/**
 * Servlet implementation class ListarPessoasServlet
 */
@WebServlet({"/pessoa/listar","/pessoa/visualizar","/admin/visualizar","/user/view"})
public class ListarPessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPessoasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Collection<Pessoa> pessoas = pessoaDAO.recuperarPessoas();
		
		request.setAttribute("tituloPagina", "Cadastro de usuários");
		request.setAttribute("pathPagina", "../../../webapp/views/pessoa/listar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

}
