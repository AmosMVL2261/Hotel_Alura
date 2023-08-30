package security.usuarios;

import javax.persistence.EntityManager;

import utils.JPAUtils;

public class UsuarioController {
	
	public Boolean checkLogin(String user, String password) {
		if(user.trim().length() == 0 || user == null || password.trim().length() == 0 || password == null) {
			return false;
		}
		EntityManager em = JPAUtils.getEntityManager();
		UsuarioDAO userDAO = new UsuarioDAO(em);
		
		try {
			Usuario userFinded = userDAO.consultarPorNombre(user);
			if(user.equals(userFinded.getUser()) && password.equals(userFinded.getPassword())) {
				em.close();
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		em.close();
		return false;
	}
}