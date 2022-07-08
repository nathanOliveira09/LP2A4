package controller.compra;

import java.io.IOException;
import java.util.Collection;

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
import java.util.Collection;

import model.Compra;
import model.repositorio.CompraDAO;

/**
 * Servlet implementation class ListarComprasServlet
 */
public class ListarComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListarComprasServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompraDAO compraDAO = new CompraDAO();
		Collection<Compra> compras = compraDAO.recuperarComprasEProdutos();
		
		request.setAttribute("comprasRegistradas", compras);
		request.setAttribute("tituloPagina", "Registro de compras");
<<<<<<< HEAD
		request.setAttribute("pathPagina", "/views/compra/listarCompras.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
=======
		request.setAttribute("pathPagina", "../../../webapp/views/compras/listar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("../../../webapp/template.jsp");
>>>>>>> a944c0512718310266e59e6831ed26a1fcc80aca
		
		rd.forward(request, response);
	}

}
