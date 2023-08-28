package services;

import javax.persistence.EntityManager;

import huespedes.Huesped;
import huespedes.HuespedController;
import reservas.Reserva;
import reservas.ReservaController;
import utils.JPAUtils;

public class RealizarReserva {
	
	public void reserva(Huesped huesped, Reserva reserva) {

		ReservaController reservaController = new ReservaController();
		HuespedController huespedController = new HuespedController();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		huespedController.registrarHuesped(huesped, em);
		reserva.setHuesped(huesped);
		reservaController.registrarReserva(reserva, em);
		
		em.getTransaction().commit();
		
		em.close();
	}

	public int ultimoIndex() {
		EntityManager em = JPAUtils.getEntityManager();
		ReservaController rc = new ReservaController();
		int index = rc.ultimoIndex(em);
		em.close();
		return index;
	}
}
