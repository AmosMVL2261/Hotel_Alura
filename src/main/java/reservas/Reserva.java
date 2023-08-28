package reservas;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import huespedes.Huesped;

@Entity
@Table(name = "reservas")
public class Reserva {
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaDeEntrada=" + fechaDeEntrada + ", fechaDeSalida=" + fechaDeSalida
				+ ", valor=" + valor + ", formaDePago=" + formaDePago + ", huesped=" + huesped + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate fechaDeEntrada;
	private LocalDate fechaDeSalida;
	private BigDecimal valor;
	private String formaDePago;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idHuesped", nullable=false)
	private Huesped huesped;

	public Reserva() {

	}
	
	public Reserva(LocalDate fechaDeEntrada, LocalDate fechaDeSalida, BigDecimal valor, String formaDePago) {
		this.fechaDeEntrada = fechaDeEntrada;
		this.fechaDeSalida = fechaDeSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
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
	
	
	public Huesped getHuesped() {
		return huesped;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	
}
