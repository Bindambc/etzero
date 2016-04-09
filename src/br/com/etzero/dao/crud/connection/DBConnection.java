package br.com.etzero.dao.crud.connection;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {

	public Connection geraConexao() {
		Connection conexao = null;
		String dir = null;
		
		//use essa para o arquivo jar
		
		
	//	JOptionPane.showMessageDialog(null, "jdbc:sqlite:"+System.getProperty("user.dir")+"/database/etzerodata.sdb");;
		String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"/database/etzerodata.sdb";
	
		//use essa para executar dentro do eclipse
		//String url = "jdbc:sqlite:./database/etzerodata.sdb";

		try {
			conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexao;

	}

	
}
