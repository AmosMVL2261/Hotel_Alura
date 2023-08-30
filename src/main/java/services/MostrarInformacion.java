package services;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import huespedes.Huesped;
import huespedes.HuespedConReserva;
import reservas.Reserva;

public class MostrarInformacion {
	
	public void agregarReservas(DefaultTableModel tabla, List<Reserva> lista) {
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
	}
	
	public void agregarHuespedesConReserva(DefaultTableModel tabla, List<HuespedConReserva> lista) {
		lista.forEach(row -> tabla.addRow(new Object[] {
			row.getId(),
			row.getNombre(),
			row.getApellido(),
			row.getFechaDeNacimiento(),
			row.getNacionalidad(),
			row.getTelefono(),
			row.getHuespedId(),
		}));
	}
	
	public void agregarHuespedes(DefaultTableModel tabla, List<Huesped> lista) {
		lista.forEach(row -> tabla.addRow(new Object[] {
			row.getId(),
			row.getNombre(),
			row.getApellido(),
			row.getFechaDeNacimiento(),
			row.getNacionalidad(),
			row.getTelefono(),
		}));
	}

}
