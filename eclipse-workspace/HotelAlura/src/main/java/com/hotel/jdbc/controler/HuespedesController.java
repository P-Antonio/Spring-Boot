package com.hotel.jdbc.controler;

import java.sql.SQLException;
import java.util.List;

import com.hotel.jdbc.dao.HuespedesDAO;
import com.hotel.jdbc.factory.connectionFactory;
import com.hotel.jdbc.modelo.Huespedes;

public class HuespedesController {
	
	private HuespedesDAO huespedesDAO;
	
	public HuespedesController() {
		this.huespedesDAO = new HuespedesDAO(new connectionFactory().crearConexion());
	}
	
	public List<Huespedes> guardar() throws SQLException{
		return huespedesDAO.guardar();
	}
	
	public void guardarHuesped(Huespedes huespedes) throws SQLException {
		huespedesDAO.guardarHuesped(huespedes);
	}
}
