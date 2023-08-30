package huespedes;

import java.util.List;

import javax.persistence.EntityManager;

import utils.JPAUtils;

public class HuespedController {
	/*
	public static void main(String[] args) {
		String searchingTerm = "apellido";
		EntityManager em = JPAUtils.getEntityManager();
		HuespedDAO huespedDAO = new HuespedDAO(em);
		List<HuespedConReserva> result = huespedDAO.getHuespedesFiltradosPorApellido(searchingTerm);
		result.forEach(r -> System.out.println(r));
	}
	 */
	public void registrarHuesped(Huesped huesped, EntityManager em) {
		HuespedDAO huespedDAO = new HuespedDAO(em);	
		huespedDAO.guardarHuesped(huesped);
	}
	
	public List<Huesped> todasLasReservas(EntityManager em){
		HuespedDAO huespedDAO = new HuespedDAO(em);
		return huespedDAO.getHuespedes();
	}
	
	public List<Huesped> filtrarHuespedesPorApellido(EntityManager em, String searchingTerm) {
		HuespedDAO huespedDAO = new HuespedDAO(em);
		return huespedDAO.getHuespedesFiltradosPorApellido(searchingTerm);
	}

	public Huesped encontrarHuesped(EntityManager em, int huespedId) {
		HuespedDAO huespedDAO = new HuespedDAO(em);
		return huespedDAO.findHuesped(huespedId);
	}

	public void modificarHuesped(EntityManager em, HuespedDTO huespedModificado) {
		HuespedDAO huespedDAO = new HuespedDAO(em);
		huespedDAO.modificarHuespedPorId(huespedModificado);
	}
	
	public List<HuespedConReserva> todasLasReservasConHuesped(EntityManager em){
		HuespedDAO huespedDAO = new HuespedDAO(em);
		return huespedDAO.getHuespedesConReserva();
	}
	
	public List<HuespedConReserva> filtrarHuespedesConReservaPorApellido(EntityManager em, String searchingTerm) {
		HuespedDAO huespedDAO = new HuespedDAO(em);
		return huespedDAO.getHuespedesConReservaFiltradosPorApellido(searchingTerm);
	}
	
}
