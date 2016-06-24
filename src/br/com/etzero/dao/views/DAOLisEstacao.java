/*The MIT License (MIT)

Copyright (c) 2016 Mauricio Binda da Costa - mauriciobc.mbc@hotmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/
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