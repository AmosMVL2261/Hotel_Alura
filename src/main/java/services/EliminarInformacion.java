package services;

import javax.persistence.EntityManager;

import huespedes.HuespedController;
import reservas.ReservaController;
import utils.JPAUtils;

public class EliminarInformacion {
	public void eliminarReserva(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		ReservaController rc = new ReservaController();
		rc.eliminarReservaPorID(em, id);
		em.close();
	}
	
	public void eliminarHuesped(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		HuespedController hc = new HuespedController();
		hc.eliminarHuespedPorId(em, id);
		em.close();
	}
}
