package services;

import javax.persistence.EntityManager;

import huespedes.HuespedController;
import huespedes.HuespedDTO;
import reservas.ReservaController;
import reservas.ReservaDTO;
import utils.JPAUtils;

public class ModificarInformacion {

	public void modificarReserva(ReservaDTO reservaModificada) {
		EntityManager em = JPAUtils.getEntityManager();
		ReservaController rc = new ReservaController();
		try {
			rc.modificarReserva(em, reservaModificada);
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	public void modificarHuesped(HuespedDTO huespedModificado) {
		EntityManager em = JPAUtils.getEntityManager();
		HuespedController hc = new HuespedController();
		try {
			hc.modificarHuesped(em, huespedModificado);
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}

}
