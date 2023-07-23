package com.hotel.jdbc.modelo;

import java.sql.Date;

public class Huespedes {
	private int id;
	private String nombre;
	private String apellido; 
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private String idReserva;
	
	public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
			String idReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}
	
	
	
	public Huespedes(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
			String idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String id) {
		this.idReserva = id;
	}
	
	@Override
	public String toString() {
		return String.format(
				"{id: %s, nombre: %s, apellido %s, fecha nacimiento: %s, nacionalidad: %s, telefono: %s, id Reserva: %s}",
				this.id,
				this.nombre,
				this.apellido,
				this.fechaNacimiento,
				this.nacionalidad,
				this.telefono,
				this.idReserva);
				
	}
	
}
