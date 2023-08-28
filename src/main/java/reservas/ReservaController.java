package reservas;

import javax.persistence.EntityManager;

public class ReservaController {
	
	public static void main(String[] args) {

	}
	
	public void registrarReserva(Reserva reserva, EntityManager em) {
		ReservaDAO reservaDAO = new ReservaDAO(em);
		reservaDAO.guardarReserva(reserva);
	}
	
	public int ultimoIndex(EntityManager em) {
		ReservaDAO reservaDAO = new ReservaDAO(em);
		return reservaDAO.buscarUltimoIndex();
	}
	
}
