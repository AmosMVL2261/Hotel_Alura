package reservas;

import javax.persistence.EntityManager;

public class ReservaDAO {
	
	private EntityManager em;
	
	public ReservaDAO() {
		
	}
	
	public ReservaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardarReserva(Reserva reserva) {
		em.persist(reserva);
	}
	
	public int buscarUltimoIndex() {
		String jpql = "SELECT MAX(r.id) FROM Reserva as r";
		int index = (Integer) em.createQuery(jpql).getSingleResult(); 
		System.out.println(index);
		return index;
	}
	
}
