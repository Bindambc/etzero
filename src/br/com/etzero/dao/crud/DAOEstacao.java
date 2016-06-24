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
package br.com.etzero.dao.crud;

import java.sql.*;
import java.util.*;

import br.com.etzero.dao.crud.connection.DBConnection;
import br.com.etzero.entity.crud.Estacao;
import br.com.etzero.gui.frames.Mensagens;

public class DAOEstacao implements IDAOCrud<Estacao> {

	@SuppressWarnings("resource")
	public int salvar(Estacao entidade) {

		Connection conexao = new DBConnection().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {

			if (entidade.getCodEstacao() == 0) {
				sql = "insert into estacao(Descricao, LatitudeGrau, LatitudeMinuto, Hemisferio, Altitude) values(?, ?, ?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setString(1, entidade.getDescricao());
				sqlParametro.setInt(2, entidade.getLatitudeGrau());
				sqlParametro.setInt(3, entidade.getLatitudeMinuto());
				sqlParametro.setString(4, entidade.getHemisferio());
				sqlParametro.setInt(5, entidade.getAltitude());
				sqlParametro.executeUpdate();
				sql = "select last_insert_rowid() as Codigo";
				sqlParametro = conexao.prepareStatement(sql);
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("Codigo");
				}
			} else {
				sql = "update estacao set Descricao = ?, LatitudeGrau = ?, LatitudeMinuto = ?, Hemisferio = ?, Altitude = ? where CodEstacao = ?;";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setString(1, entidade.getDescricao());
				sqlParametro.setInt(2, entidade.getLatitudeGrau());
				sqlParametro.setInt(3, entidade.getLatitudeMinuto());
				sqlParametro.setString(4, entidade.getHemisferio());
				sqlParametro.setInt(5, entidade.getAltitude());
				sqlParametro.setInt(6, entidade.getCodEstacao());
				sqlParametro.executeUpdate();
				codigo = entidade.getCodEstacao();
			}
		} catch (SQLException e) {
			Mensagens.mensagemDeErro(
					"O aplicativo está em uma pasta somente leitura que não permite gravações no banco de dados,\n mova-o para outra pasta e tente novamente.",
					e);
			e.printStackTrace();
		} finally {
			try {
				sqlParametro.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return codigo;
	}

	public boolean excluir(Estacao entidade) {

		Connection conexao = new DBConnection().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		// boolean teste = false;
		try {
			sql = "delete from estacao where CodEstacao = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, entidade.getCodEstacao());
			sqlParametro.executeUpdate();
		} catch (SQLException e) {
			// teste = false;
			e.printStackTrace();
			return false;
		} finally {
			try {
				sqlParametro.close();
				conexao.close();
				// teste = true;
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public List<Estacao> listar() {

		Connection conexao = new DBConnection().geraConexao();
		List<Estacao> lista = new ArrayList<Estacao>();
		Statement consulta = null;
		ResultSet resultado = null;
		Estacao entidade = null;
		String sql;
		try {
			sql = "select * from estacao order by CodEstacao, Descricao, LatitudeGrau, LatitudeMinuto, Hemisferio, Altitude;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new Estacao();
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

	public Estacao buscarPorCodigo(int codigo) {

		Connection conexao = new DBConnection().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Estacao entidade = null;
		String sql;
		try {
			sql = "select * from estacao where CodEstacao = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				entidade = new Estacao();
				entidade.setCodEstacao(resultado.getInt("CodEstacao"));
				entidade.setDescricao(resultado.getString("Descricao"));
				entidade.setLatitudeGrau(resultado.getInt("LatitudeGrau"));
				entidade.setLatitudeMinuto(resultado.getInt("LatitudeMinuto"));
				entidade.setHemisferio(resultado.getString("Hemisferio"));
				entidade.setAltitude(resultado.getInt("Altitude"));
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
		return entidade;
	}
}