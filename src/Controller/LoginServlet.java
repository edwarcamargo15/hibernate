package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Usuario;

import Dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		Usuario usuario= new Usuario();
		usuario.setUsuario(usuarioTxt);
		usuario.setClave(claveTxt);
		
		LoginDao loginDao=new LoginDao();
		
		String userValidate = loginDao.authenticateUser(usuario);
		System.out.println(userValidate);
		if(userValidate.contentEquals("SUCESS")) {
			request.setAttribute("userName", usuarioTxt);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}else {
			request.setAttribute("errMessage",userValidate);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}
