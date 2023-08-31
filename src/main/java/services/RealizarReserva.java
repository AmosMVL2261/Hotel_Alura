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
		try {
			em.getTransaction().begin();
			
			huespedController.registrarHuesped(huesped, em);
			reserva.setHuesped(huesped);
			reservaController.registrarReserva(reserva, em);
			
			em.getTransaction().commit();
		
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}

	public int ultimoIndex() {
		ReservaController rc = new ReservaController();
		EntityManager em = JPAUtils.getEntityManager();
		int index;
		try {
			index = rc.ultimoIndex(em);
		} catch (Exception e) {
			index = -1;
		} finally {
			em.close();
		}
		return index;
	}
}
