package huespedes;

import java.time.LocalDate;

public class HuespedConReserva {
	private int id;
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String nacionalidad;
	private String telefono;
	private int huespedId;
	
	@Override
	public String toString() {
		return "HuespedConReserva [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", huespedId="
				+ huespedId + "]";
	}

	public HuespedConReserva() {
		
	}
	
	public HuespedConReserva(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad,
			String telefono, int huespedId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.huespedId = huespedId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getHuespedId() {
		return huespedId;
	}
	public void setHuespedId(int huespedId) {
		this.huespedId = huespedId;
	}
	
	
}
