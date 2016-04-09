package br.com.etzero.dao.crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public Connection geraConexao() {
		Connection conexao = null;
		String url = "jdbc:sqlite:./database/etzerodata.sdb";

		try {
			conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexao;

	}

	
}
