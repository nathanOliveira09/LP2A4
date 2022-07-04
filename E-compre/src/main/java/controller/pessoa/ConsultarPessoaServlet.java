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
 * Servlet implementation class ConsultarPessoaServlet
 */
@WebServlet({"/pessoa/consultar","/admin/consultar","/user/consultar"})
public class ConsultarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPessoa=0;
		String idInformado = request.getParameter("idpessoa");
		
		if (idInformado != null) {
			try {
				idPessoa = Integer.parseInt(idInformado);
			} catch (Exception e) {
				System.out.println("O ID informado é inválido.");
			}
		}
		
		Pessoa p1 = new Pessoa();
		PessoaDAO pessoa = new PessoaDAO();
		p1 = pessoa.recuperarPessoa(Integer.parseInt(idInformado));
		Collection<Pessoa> pessoas = (Collection<Pessoa>) p1 ;
		
		pessoas.add(p1);
		
		request.setAttribute("pessoasCadastradas", pessoas);
		request.setAttribute("tituloPagina", "Editar Pessoa");
		request.setAttribute("pathPagina", "/pessoa/listar.jsp");
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
		
		
		
	}

}
