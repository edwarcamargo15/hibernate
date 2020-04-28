package Dao;

import com.mvc.bean.Usuario;

public class LoginDao {

	public LoginDao() {
		// TODO Auto-generated constructor stub
	}
	
	public String authenticateUser(Usuario usuario) {
		UsuarioDao usuarioDao = new HibernateUsuarioDao();
		Usuario u = usuarioDao.selectById(usuario.getUsuario());
		if(u!=null) {
			if(u.getClave().contentEquals(usuario.getClave())) {
				return "SUCCESS";
			}
		}
		return "ERROR";
	}

}
