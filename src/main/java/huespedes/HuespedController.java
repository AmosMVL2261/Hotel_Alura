package huespedes;

import javax.persistence.EntityManager;

public class HuespedController {
	
	public void registrarHuesped(Huesped huesped, EntityManager em) {
		HuespedDAO huespedDAO = new HuespedDAO(em);	
		huespedDAO.guardarHuesped(huesped);
	}
	
}
