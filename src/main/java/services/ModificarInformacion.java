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
		rc.modificarReserva(em, reservaModificada);
		em.close();
	}
	
	public void modificarHuesped(HuespedDTO huespedModificado) {
		EntityManager em = JPAUtils.getEntityManager();
		HuespedController hc = new HuespedController();
		hc.modificarHuesped(em, huespedModificado);
		em.close();
	}

}
