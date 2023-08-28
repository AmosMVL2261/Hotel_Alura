package huespedes;

import javax.persistence.EntityManager;

public class HuespedDAO {
	
	private EntityManager em;
	
	public HuespedDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardarHuesped(Huesped huesped) {
		this.em.persist(huesped);
	}
}
