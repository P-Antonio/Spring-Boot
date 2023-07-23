package com.hotel.jdbc.controler;

import java.sql.SQLException;
import java.util.List;
import com.hotel.jdbc.dao.ReservasDAO;
import com.hotel.jdbc.factory.connectionFactory;
import com.hotel.jdbc.modelo.Reserva;

public class ReservasController {
	
	private ReservasDAO reservasDAO;

	public ReservasController() {
		this.reservasDAO = new ReservasDAO(new connectionFactory().crearConexion());
	}


	public List<Reserva> guardar() throws SQLException {
		return reservasDAO.guardar();
	}
	
	
	public void guardarHuesped(Reserva reserva) throws SQLException{
		reservasDAO.guardarHuesped(reserva);
	}
}
