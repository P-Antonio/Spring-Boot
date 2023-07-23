package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hotel.jdbc.modelo.CuentaHuepedes;

public class CuentaHuespedesDAO {
	
	private Connection connection;
	
	public CuentaHuespedesDAO(Connection connection){
		this.connection = connection;
	}
	
	
	public List<CuentaHuepedes> lista(){
		List<CuentaHuepedes> resultado = new ArrayList<>();
		
		try{
			System.out.println("conexion estable");
			PreparedStatement statement = connection.prepareStatement("SELECT ID, USUARIO, CONTRASEÑA FROM SINGUP");
				try(statement){
					statement.execute();
					final ResultSet resultSet = statement.getResultSet();
					try(resultSet){
						while(resultSet.next()) {
							resultado.add(new CuentaHuepedes(resultSet.getString("USUARIO"),
									resultSet.getString("CONTRASEÑA")));
						}
						return resultado;
					}
				}
			}catch(SQLException e) {
				throw new RuntimeException(e);
		} 
	}
	
	
	public void guardar(CuentaHuepedes crearCuenta) throws SQLException{
		try{
			final PreparedStatement statement = connection.prepareStatement("INSERT INTO SINGUP (Usuario, Contraseña)"
					+ "VALUES(?,?)",
					Statement.RETURN_GENERATED_KEYS );
			try(statement){
				statement.setString(1, crearCuenta.getNombre());
				statement.setString(2, crearCuenta.getContraseña());
				
				statement.execute();
				final ResultSet resultSet = statement.getGeneratedKeys();
				try(resultSet){
					while(resultSet.next()) {
						System.out.println("fue insertado el producto");
						resultSet.getInt(1);
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
