package huespedes;

import java.util.List;

import javax.persistence.EntityManager;

public class HuespedController {

	public void registrarHuesped(Huesped huesped, EntityManager em) {
		HuespedDAO huespedDAO = new HuespedDAO(em);	
		huespedDAO.guardarHuesped(huesped);
	}
	
	public List<HuespedConReserva> todasLasReservas(EntityManager em){
		HuespedDAO huespedDAO = new HuespedDAO(em);
		return huespedDAO.getHuespedes();
	}
	
}
