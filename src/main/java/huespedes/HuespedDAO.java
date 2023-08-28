package huespedes;

import java.util.List;

import javax.persistence.EntityManager;

public class HuespedDAO {
	
	private EntityManager em;
	
	public HuespedDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardarHuesped(Huesped huesped) {
		this.em.persist(huesped);
	}

	public List<HuespedConReserva> getHuespedes() {
		String jpql = "SELECT new huespedes.HuespedConReserva(h.id , h.nombre , h.apellido , h.fechaDeNacimiento , h.nacionalidad , h.telefono , r.id) "
				+ "From Reserva r JOIN r.huesped h";
		return em.createQuery(jpql, HuespedConReserva.class).getResultList();
	}
}
