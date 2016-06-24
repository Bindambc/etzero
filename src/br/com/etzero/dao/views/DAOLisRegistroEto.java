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