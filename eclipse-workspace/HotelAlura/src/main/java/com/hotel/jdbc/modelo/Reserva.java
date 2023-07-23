package com.hotel.jdbc.modelo;

import java.sql.Date;

public class Reserva {
	private int id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String valor;
	private String formaDePago;
	
	public Reserva(Date fechaEntrada, Date fechaSalida, String valor, String formaDePago) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public Reserva(Integer id, Date fechaEntrada, Date fechaSalida, String valor, String formaDePago) {
		super();
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
}
