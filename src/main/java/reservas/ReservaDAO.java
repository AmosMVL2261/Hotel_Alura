package reservas;

import java.util.List;

import javax.persistence.EntityManager;

import huespedes.Huesped;
import huespedes.HuespedController;

public class ReservaDAO {
	
	private EntityManager em;
	
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

	public List<Reserva> getReservas() {
		String jpql = "SELECT r FROM Reserva AS r";
		return em.createQuery(jpql, Reserva.class).getResultList();
	}
	
	public Reserva getReserva(Integer id) {
		String jpql = "SELECT r FROM Reserva AS r WHERE r.id = :id";
		return em.createQuery(jpql, Reserva.class).setParameter("id", id).getSingleResult();
	}

	public List<Reserva> getReservasFiltradasPorId(String idBuscado) {
		Integer idBuscadoNumerico = Integer.valueOf(idBuscado);
		String jpql = "SELECT r FROM Reserva AS r WHERE r.id = :idBuscado";
		return em.createQuery(jpql, Reserva.class).setParameter("idBuscado", idBuscadoNumerico).getResultList();
	}

	public void modificarReservaPorId(ReservaDTO reservaModificada) {
		HuespedController huespedController = new HuespedController(); 
		Reserva reservaPorModificar = getReserva(reservaModificada.getId());
		Huesped posibleNuevoHuesped = huespedController.encontrarHuesped(em ,reservaModificada.getHuesped());
		em.getTransaction().begin();
		reservaPorModificar.setFechaDeEntrada(reservaModificada.getFechaDeEntrada());
		reservaPorModificar.setFechaDeSalida(reservaModificada.getFechaDeSalida());
		reservaPorModificar.setValor(reservaModificada.getValor());
		reservaPorModificar.setFormaDePago(reservaModificada.getFormaDePago());
		reservaPorModificar.setHuesped(posibleNuevoHuesped);
		em.getTransaction().commit();
	}

	public void deleteReservaById(int id) {
		em.getTransaction().begin();
		Reserva r = getReserva(id);
		em.remove(r);
		em.getTransaction().commit();
	}
	
}
