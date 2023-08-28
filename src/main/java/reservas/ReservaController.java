package reservas;

import java.util.List;

import javax.persistence.EntityManager;

public class ReservaController {
	
	public static void main(String[] args) {
		/*
		EntityManager em = JPAUtils.getEntityManager();
		ReservaDAO reservaDAO = new ReservaDAO(em);
		List<Reserva> r = reservaDAO.getReservas();
		r.forEach(row -> System.out.println(row));
		*/
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
	
}
