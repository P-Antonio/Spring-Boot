package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hotel.jdbc.modelo.Reserva;

public class ReservasDAO {
	
	private Connection connection;
	
	public ReservasDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Reserva> guardar() throws SQLException {
		List<Reserva> resultado = new ArrayList<>();
		try{
			System.out.println("conexion estable");
			final PreparedStatement statement = connection.prepareStatement("SELECT ID, FECHA_ENTRADA,"
					+ "FECHA_SALIDA,VALOR,FORMA_DE_PAGO FROM RESERVAS");
			try(statement){
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while (resultSet.next()) {
						Reserva fila = new Reserva(resultSet.getInt("ID"),
								resultSet.getDate("FECHA_ENTRADA"),
								resultSet.getDate("FECHA_SALIDA"),
								resultSet.getString("VALOR"),
								resultSet.getString("FORMA_DE_PAGO"));
						
						resultado.add(fila);
					}
				}
				return resultado;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void guardarHuesped(Reserva reserva) throws SQLException{
		try{
			final PreparedStatement statement = connection.prepareStatement("INSERT INTO RESERVAS "
					+ "(FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_DE_PAGO)"
					+ "VALUES(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS );
			try(statement){
				statement.setDate(1, reserva.getFechaEntrada());
				statement.setDate(2, reserva.getFechaSalida());
				statement.setString(3, reserva.getValor());
				statement.setString(4, reserva.getFormaDePago());
				
				statement.execute();
				final ResultSet resultSet = statement.getGeneratedKeys();
				try(resultSet){
					while(resultSet.next()) {
						reserva.setId(resultSet.getInt(1));
						System.out.println("fue insertado el producto");
					}
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
