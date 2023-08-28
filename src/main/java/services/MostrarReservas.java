package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;

import huespedes.HuespedConReserva;
import huespedes.HuespedController;
import reservas.Reserva;
import reservas.ReservaController;
import utils.JPAUtils;

public class MostrarReservas {
	
	public void agregarReservas(DefaultTableModel tabla) {
		ReservaController rc = new ReservaController();
		EntityManager em = JPAUtils.getEntityManager();
		List<Reserva> lista = rc.todasLasReservas(em);
		lista.forEach(row -> tabla.addRow(
			new Object[] {
				row.getId(),
				row.getFechaDeEntrada(),
				row.getFechaDeSalida(),
				row.getValor(),
				row.getFormaDePago(),
				row.getHuesped().getId()
			}
		));
		em.close();
	}
	
	public void agregarHuespedes(DefaultTableModel tabla) {
		HuespedController hc = new HuespedController();
		EntityManager em = JPAUtils.getEntityManager();
		List<HuespedConReserva> lista = hc.todasLasReservas(em);
		lista.forEach(row -> tabla.addRow(new Object[] {
			row.getId(),
			row.getNombre(),
			row.getApellido(),
			row.getFechaDeNacimiento(),
			row.getNacionalidad(),
			row.getTelefono(),
			row.getHuespedId(),
		}));
		em.close();
	}
}
