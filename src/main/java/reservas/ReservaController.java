package reservas;

import java.util.List;

import javax.persistence.EntityManager;

import huespedes.HuespedConReserva;
import huespedes.HuespedDAO;
import utils.JPAUtils;

public class ReservaController {
	
	public static void main(String[] args) {
		/*
		EntityManager em = JPAUtils.getEntityManager();
		ReservaDAO reservaDAO = new ReservaDAO(em);
		List<Reserva> r = reservaDAO.getReservas();
		r.forEach(row -> System.out.println(row));
		*/
		/*
		String idBuscado = "1";
		EntityManager em = JPAUtils.getEntityManager();
		ReservaDAO reservaDAO = new ReservaDAO(em);
		List<Reserva> r = reservaDAO.getReservasFiltradasPorId(idBuscado);
		r.forEach(row -> System.out.println(row));
		*/
		/*
		int idBuscado = 1;
		EntityManager em = JPAUtils.getEntityManager();
		ReservaDAO reservaDAO = new ReservaDAO(em);
		System.out.println(reservaDAO.getReserva(idBuscado));
		*/
	}
	
	public ReservaController() {
		
	}
	
	public void registrarReserva(Reserva reserva, EntityManager em) {
		ReservaDAO reservaDAO = new ReservaDAO(em);
		reservaDAO.guardarReserva(reserva);
	}
	
	public int ultimoIndex(EntityManager em) {
		ReservaDAO reservaDAO = new ReservaDAO(em);
		return reservaDAO.buscarUltimoIndex();
	}
	
	public List<Reserva> todasLasReservas(EntityManager em){
		ReservaDAO reservaDAO = new ReservaDAO(em);
		return reservaDAO.getReservas();
	}
	
	public List<Reserva> filtrarReservasPorID(EntityManager em, String idBuscado){
		ReservaDAO reservaDAO = new ReservaDAO(em);
		return reservaDAO.getReservasFiltradasPorId(idBuscado);
	}

	public void modificarReserva(EntityManager em, ReservaDTO reservaModificada) {
		ReservaDAO reservaDAO = new ReservaDAO(em); 
		reservaDAO.modificarReservaPorId(reservaModificada);
	}
	
}
