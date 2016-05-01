package br.com.etzero.dao.crud.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public Connection geraConexao() {
		Connection conexao = null;
		
		/*
		 * Para testar o aplicativo dentro do eclipse utilize o código abaixo:
		 */
		// String url =
		// "jdbc:sqlite:"+System.getProperty("user.dir")+"/database/etzerodata.sdb";
		

		/*
		 * Para trabalhar com linux utilize o código abaixo:
		 * 
		 */
		String url = "jdbc:sqlite:" + this.getClass().getResource("../../../../../../") + "/database/etzerodata.sdb";
		
		try {
			conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexao;

	}

}
