package br.com.etzero.dao.views;

import java.sql.*;
import java.util.*;

import br.com.etzero.dao.crud.connection.DBConnection;
import br.com.etzero.entity.views.LisEstacao;

public class DAOLisEstacao implements IDAOView<LisEstacao> {

	public List<LisEstacao> listar() {

		Connection conexao = new DBConnection().geraConexao();
		List<LisEstacao> lista = new ArrayList<LisEstacao>();
		Statement consulta = null;
		ResultSet resultado = null;
		LisEstacao entidade = null;
		String sql;
		try {
			sql = "select * from estacao order by CodEstacao, Descricao, LatitudeGrau, LatitudeMinuto, Hemisferio, Altitude;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new LisEstacao();
				entidade.setCodEstacao(resultado.getInt("CodEstacao"));
				entidade.setDescricao(resultado.getString("Descricao"));
				entidade.setLatitudeGrau(resultado.getInt("LatitudeGrau"));
				entidade.setLatitudeMinuto(resultado.getInt("LatitudeMinuto"));
				entidade.setHemisferio(resultado.getString("Hemisferio"));
				entidade.setAltitude(resultado.getInt("Altitude"));
				lista.add(entidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public List<LisEstacao> filtrar(String condicao) {

		Connection conexao = new DBConnection().geraConexao();
		List<LisEstacao> lista = new ArrayList<LisEstacao>();
		Statement consulta = null;
		ResultSet resultado = null;
		LisEstacao entidade = null;
		String sql;
		try {
			sql = "select * from estacao order by CodEstacao, Descricao, LatitudeGrau, LatitudeMinuto, Hemisferio, Altitude;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new LisEstacao();
				entidade.setCodEstacao(resultado.getInt("CodEstacao"));
				entidade.setDescricao(resultado.getString("Descricao"));
				entidade.setLatitudeGrau(resultado.getInt("LatitudeGrau"));
				entidade.setLatitudeMinuto(resultado.getInt("LatitudeMinuto"));
				entidade.setHemisferio(resultado.getString("Hemisferio"));
				entidade.setAltitude(resultado.getInt("Altitude"));
				lista.add(entidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}