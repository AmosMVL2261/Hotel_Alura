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
	
	public List<Huesped> getHuespedes() {
		String jpql = "SELECT h FROM Huesped AS h";
		return em.createQuery(jpql, Huesped.class).getResultList();
	}
	
	public List<Huesped> getHuespedesFiltradosPorApellido(String apellido) {
		String jpql = "SELECT h FROM Huesped AS h WHERE h.apellido = :apellido";
		return em.createQuery(jpql, Huesped.class).setParameter("apellido", apellido).getResultList();
	}

	public Huesped findHuesped(int huespedId) {
		Huesped huesped = em.find(Huesped.class, huespedId);
		return huesped;
	}

	public void modificarHuespedPorId(HuespedDTO huespedModificado) {
		Huesped huespedPorModificar = findHuesped(huespedModificado.getId());
		em.getTransaction().begin();
		huespedPorModificar.setNombre(huespedModificado.getNombre());
		huespedPorModificar.setApellido(huespedModificado.getApellido());
		huespedPorModificar.setFechaDeNacimiento(huespedModificado.getFechaDeNacimiento());
		huespedPorModificar.setNacionalidad(huespedModificado.getNacionalidad());
		huespedPorModificar.setTelefono(huespedModificado.getTelefono());
		em.getTransaction().commit();
	}
	
	public List<HuespedConReserva> getHuespedesConReserva() {
		String jpql = "SELECT new huespedes.HuespedConReserva(h.id , h.nombre , h.apellido , h.fechaDeNacimiento , h.nacionalidad , h.telefono , r.id) "
				+ "FROM Reserva r JOIN r.huesped h";
		return em.createQuery(jpql, HuespedConReserva.class).getResultList();
	}
	
	public List<HuespedConReserva> getHuespedesConReservaFiltradosPorApellido(String apellido) {
		String jpql = "SELECT new huespedes.HuespedConReserva(h.id , h.nombre , h.apellido , h.fechaDeNacimiento , h.nacionalidad , h.telefono , r.id)"
				+ " FROM Reserva AS r JOIN r.huesped h WHERE h.apellido = :apellido";
		return em.createQuery(jpql, HuespedConReserva.class).setParameter("apellido", apellido).getResultList();
	}

	public void deleteHuespedById(int id) {
		em.getTransaction().begin();
		Huesped h = findHuesped(id);
		em.remove(h);
		em.getTransaction().commit();
	}
}
