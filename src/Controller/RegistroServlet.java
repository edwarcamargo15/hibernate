package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Usuario;

import Dao.HibernateUsuarioDao;
import Dao.UsuarioDao;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
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
		doGet(request, response);
		
		
		String usuarioTxt = request.getParameter("usuario");
		String claveTxt = request.getParameter("clave");
		String nombreTxt = request.getParameter("nombre");
		String dirTxt = request.getParameter("direccion");
		String telefonoTxt = request.getParameter("telefono");
		String correoTxt = request.getParameter("email");
		
		
		Usuario usuario = new Usuario();
		
		usuario.setUsuario(usuarioTxt);
		usuario.setClave(claveTxt);
		usuario.setCorreo(nombreTxt);
		usuario.setDireccion(dirTxt);
		usuario.setNombre(telefonoTxt);
		usuario.setTelefono(correoTxt);
		
		System.out.println("ACA PRUEBA");
		
		UsuarioDao usuarioDao= new HibernateUsuarioDao();
		usuarioDao.insert(usuario);
		
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}

}
