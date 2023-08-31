package services;

import javax.persistence.EntityManager;

import huespedes.HuespedController;
import reservas.ReservaController;
import utils.JPAUtils;

public class EliminarInformacion {
	public void eliminarReserva(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		ReservaController rc = new ReservaController();
		try {
			rc.eliminarReservaPorID(em, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	public void eliminarHuesped(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		HuespedController hc = new HuespedController();
		try {
			hc.eliminarHuespedPorId(em, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
}
