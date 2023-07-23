package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hotel.jdbc.modelo.Huespedes;

public class HuespedesDAO {
	
	private Connection connection;
	
	public HuespedesDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Huespedes> guardar(){
		List<Huespedes> resultado = new ArrayList<>();
		try {
			System.out.println("conexion estable");
			final PreparedStatement statement = connection.prepareStatement("SELECT ID, NOMBRE, APELLIDO,"
					+ " FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA "
					+ "FROM HUESPEDES");
			try(statement){
				statement.execute();
			
				final ResultSet resultSet = statement.getResultSet();
				System.out.println("todo bien hasta aqui");
				try(resultSet){
					while (resultSet.next()) {
						System.out.println("todo bien hasta aqui");
						Huespedes fila = new Huespedes(resultSet.getInt("ID"),
								resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"),
								resultSet.getDate("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),
								resultSet.getString("TELEFONO"),
								resultSet.getString("ID_RESERVA"));
						System.out.println("todo bien hasta aqui");
						resultado.add(fila);
						System.out.println("todo bien hasta aqui");
					}
				}
			
			}
				
				return resultado;
		}catch(SQLException e) {
				throw new RuntimeException(e);
		}
	}
	
	public void guardarHuesped(Huespedes huespedes) throws SQLException {
		try{
			final PreparedStatement statement = connection.prepareStatement("INSERT INTO HUESPEDES"
					+ "(NOMBRE, APELLIDO, FECHA_NACIMIENTO,NACIONALIDAD,TELEFONO,ID_RESERVA)"
					+ "VALUES(?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS );
			System.out.println("todo bien hasta aqui");
			try(statement){
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setDate(3, huespedes.getFechaNacimiento());
				statement.setString(4, huespedes.getNacionalidad());
				statement.setString(5, huespedes.getTelefono());
				statement.setString(6, huespedes.getIdReserva());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				try(resultSet){
					while(resultSet.next()) {
						System.out.println("fue insertado el huesped");
						resultSet.getInt(1);
					}
				}
				
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
