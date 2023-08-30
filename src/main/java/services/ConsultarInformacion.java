package services;

import java.util.List;

import javax.persistence.EntityManager;

import huespedes.Huesped;
import huespedes.HuespedConReserva;
import huespedes.HuespedController;
import reservas.Reserva;
import reservas.ReservaController;
import utils.JPAUtils;

public class ConsultarInformacion {
	
	public List<Huesped> todosLosHuespedes(){
		HuespedController hc = new HuespedController();
		EntityManager em = JPAUtils.getEntityManager();
		List<Huesped> result = hc.todasLasReservas(em);
		em.close();
		return result;
	}
	
	public List<Reserva> todasLasReservas(){
		ReservaController rc = new ReservaController();
		EntityManager em = JPAUtils.getEntityManager();
		List<Reserva> result = rc.todasLasReservas(em);
		em.close();
		return result;
	}
	
	public List<Reserva> buscarReserva(String searchingTerm) {
		EntityManager em = JPAUtils.getEntityManager();
		ReservaController rc = new ReservaController();
		List<Reserva> result = rc.filtrarReservasPorID(em, searchingTerm);
		em.close();
		return result;
	}
	
	public List<Huesped> buscarHuesped(String searchingTerm) {
		EntityManager em = JPAUtils.getEntityManager();
		HuespedController hc = new HuespedController();
		List<Huesped> result = hc.filtrarHuespedesPorApellido(em, searchingTerm);
		em.close();
		return result;
	}
	
	public List<HuespedConReserva> buscarHuespedConReserva(String searchingTerm) {
		EntityManager em = JPAUtils.getEntityManager();
		HuespedController hc = new HuespedController();
		List<HuespedConReserva> result = hc.filtrarHuespedesConReservaPorApellido(em, searchingTerm);
		em.close();
		return result;
	}
	
	public List<HuespedConReserva> todosLosHuespedesConReserva(){
		HuespedController hc = new HuespedController();
		EntityManager em = JPAUtils.getEntityManager();
		List<HuespedConReserva> result = hc.todasLasReservasConHuesped(em);
		em.close();
		return result;
	}

}
