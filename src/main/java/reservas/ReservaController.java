package reservas;

import java.util.List;

import javax.persistence.EntityManager;

public class ReservaController {
	
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

	public void eliminarReservaPorID(EntityManager em, int id) {
		ReservaDAO reservaDAO = new ReservaDAO(em);
		reservaDAO.deleteReservaById(id);
	}


	
}
