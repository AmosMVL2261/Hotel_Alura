package reservas;

import java.math.BigDecimal;
import java.time.LocalDate;

import huespedes.Huesped;

public class ReservaDTO {
	private int id;
	private LocalDate fechaDeEntrada;
	private LocalDate fechaDeSalida;
	private BigDecimal valor;
	private String formaDePago;
	private int huesped;
	
	public ReservaDTO() {
		
	}
	
	public ReservaDTO(int id, LocalDate fechaDeEntrada, LocalDate fechaDeSalida, BigDecimal valor, String formaDePago,
			int huesped) {
		this.id = id;
		this.fechaDeEntrada = fechaDeEntrada;
		this.fechaDeSalida = fechaDeSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
		this.huesped = huesped;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFechaDeEntrada() {
		return fechaDeEntrada;
	}
	public void setFechaDeEntrada(LocalDate fechaDeEntrada) {
		this.fechaDeEntrada = fechaDeEntrada;
	}
	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}
	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	public int getHuesped() {
		return huesped;
	}
	public void setHuesped(int huesped) {
		this.huesped = huesped;
	}

}
