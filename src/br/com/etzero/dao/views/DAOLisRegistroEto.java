package br.com.etzero.dao.views;

import java.sql.*;
import java.util.*;

import br.com.etzero.dao.crud.connection.DBConnection;
import br.com.etzero.entity.views.LisRegistroEto;

public class DAOLisRegistroEto implements IDAOView<LisRegistroEto> {

	public List<LisRegistroEto> listar() {

		Connection conexao = new DBConnection().geraConexao();
		List<LisRegistroEto> lista = new ArrayList<LisRegistroEto>();
		Statement consulta = null;
		ResultSet resultado = null;
		LisRegistroEto entidade = null;
		String sql;
		try {
			sql = "select * from registroeto order by DataRegistro, codRegistro, TempMax, TempMin, UmidRelativa, veloVento, radSolar, ETO, CodEstacao;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new LisRegistroEto();
				entidade.setCodRegistro(resultado.getInt("CodRegistro"));
				entidade.setDataRegistro(resultado.getDate("DataRegistro"));
				entidade.setTempMax(resultado.getDouble("TempMax"));
				entidade.setTempMin(resultado.getDouble("TempMin"));
				entidade.setUmidRelativa(resultado.getDouble("UmidRelativa"));
				entidade.setveloVento(resultado.getDouble("veloVento"));
				entidade.setradSolar(resultado.getDouble("radSolar"));
				entidade.setETO(resultado.getDouble("ETO"));
				entidade.setCodEstacao(resultado.getInt("CodEstacao"));
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

	public List<LisRegistroEto> filtrar(String condicao) {

		Connection conexao = new DBConnection().geraConexao();
		List<LisRegistroEto> lista = new ArrayList<LisRegistroEto>();
		Statement consulta = null;
		ResultSet resultado = null;
		LisRegistroEto entidade = null;
		String sql;
		try {
			sql = "select * from Registroeto order by CodRegistro, DataRegistro, TempMax, TempMin, UmidRelativa, veloVento, radSolar, ETO, CodEstacao;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new LisRegistroEto();
				entidade.setCodRegistro(resultado.getInt("CodRegistro"));
				entidade.setDataRegistro(resultado.getDate("DataRegistro"));
				entidade.setTempMax(resultado.getDouble("TempMax"));
				entidade.setTempMin(resultado.getDouble("TempMin"));
				entidade.setUmidRelativa(resultado.getDouble("UmidRelativa"));
				entidade.setveloVento(resultado.getDouble("veloVento"));
				entidade.setradSolar(resultado.getDouble("radSolar"));
				entidade.setETO(resultado.getDouble("ETO"));
				entidade.setCodEstacao(resultado.getInt("CodEstacao"));
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