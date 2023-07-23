package com.hotel.jdbc.modelo;

public class CuentaHuepedes {
	
	private int id;
	private String nombre;
	private String Contraseña;
	
	
	
	public CuentaHuepedes() {
	}



	public CuentaHuepedes(String nombre, String contraseña) {
		this.nombre = nombre;
		this.Contraseña = contraseña;
	}
	
	

	public CuentaHuepedes(int id, String nombre, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		Contraseña = contraseña;
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


	public String getContraseña() {
		return Contraseña;
	}


	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	
}
