package security.usuarios;

//import java.util.List;

import javax.persistence.EntityManager;

public class UsuarioDAO {
	private EntityManager em;

	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}
	/*
	public void guardar(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void actualizar(Usuario usuario) {
		this.em.merge(usuario);
	}
	
	public void remover(Usuario usuario) {
		this.em.remove(usuario);
	}
	
	public Usuario consultaPorId(int id) {
		return em.find(Usuario.class, id);
	}
	*/
	public Usuario consultarPorNombre(String nombreUsuario) {
		String jpql = "SELECT u FROM Usuario AS u WHERE u.user=:nombre";
		return em.createQuery(jpql, Usuario.class).setParameter("nombre", nombreUsuario).getSingleResult();
	}
	
	/*
	public List<Usuario> consultarTodos(){
		String jpql = "SELECT u FROM Usuario AS u";
		return em.createQuery(jpql, Usuario.class).getResultList();
	}
	
	public List<Usuario> consultaFiltro(String nombre){
		if(nombre.trim().length() == 0 || nombre == null) {
			return null;
		}
		String jpql = "SELECT u FROM Usuario AS u WHERE u.user=:nombre";
		return em.createQuery(jpql).setParameter("nombre", nombre).getResultList();
	}
	*/
}
