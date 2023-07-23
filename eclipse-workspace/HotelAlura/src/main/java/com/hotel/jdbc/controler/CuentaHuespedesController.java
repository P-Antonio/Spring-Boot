package com.hotel.jdbc.controler;

import java.sql.SQLException;
import java.util.List;
import com.hotel.jdbc.dao.CuentaHuespedesDAO;
import com.hotel.jdbc.factory.connectionFactory;
import com.hotel.jdbc.modelo.CuentaHuepedes;

public class CuentaHuespedesController {
	
	private CuentaHuespedesDAO cuentaHuespedesDAO;
	
	
	public CuentaHuespedesController(){
		this.cuentaHuespedesDAO = new CuentaHuespedesDAO(new connectionFactory().crearConexion());
	}
	

	public List<CuentaHuepedes> listaCuentaHuespedes() throws SQLException{
		return cuentaHuespedesDAO.lista();
	}
	
	public void guardarHuesped(CuentaHuepedes crearCuenta) throws SQLException{
		cuentaHuespedesDAO.guardar(crearCuenta);
	}
}
