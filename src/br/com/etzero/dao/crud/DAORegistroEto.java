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
import java.sql.Date;
import java.util.*;

import br.com.etzero.dao.crud.connection.DBConnection;
import br.com.etzero.entity.crud.RegistroEto;
import br.com.etzero.gui.frames.Mensagens;

public class DAORegistroEto implements IDAOCrud<RegistroEto> {

	@SuppressWarnings("resource")
	public int salvar(RegistroEto entidade) {

		Connection conexao = new DBConnection().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {

			if (entidade.getCodRegistro() == 0) {
				sql = "insert into registroeto(DataRegistro, TempMax, TempMin, UmidRelativa, veloVento, radSolar, ETO, CodEstacao) values(?, ?, ?, ?, ?, ?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				// sqlParametro.setDate(1, (Date) entidade.getDataRegistro());
				sqlParametro.setDate(1, new Date(entidade.getDataRegistro().getTime()));
				sqlParametro.setDouble(2, entidade.getTempMax());
				sqlParametro.setDouble(3, entidade.getTempMin());
				sqlParametro.setDouble(4, entidade.getUmidRelativa());
				sqlParametro.setDouble(5, entidade.getveloVento());
				sqlParametro.setDouble(6, entidade.getradSolar());
				sqlParametro.setDouble(7, entidade.getETO());
				sqlParametro.setInt(8, entidade.getCodEstacao());
				sqlParametro.executeUpdate();
				sql = "select last_insert_rowid() as Codigo";
				sqlParametro = conexao.prepareStatement(sql);
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("Codigo");
				}
			} else {
				sql = "update registroeto set DataRegistro = ?, TempMax = ?, TempMin = ?, UmidRelativa = ?, veloVento = ?, radSolar = ?, ETO = ?, CodEstacao = ? where CodRegistro = ?;";
				sqlParametro = conexao.prepareStatement(sql);
				// sqlParametro.setDate(1, (Date) entidade.getDataRegistro());
				sqlParametro.setDate(1, new Date(entidade.getDataRegistro().getTime()));
				sqlParametro.setDouble(2, entidade.getTempMax());
				sqlParametro.setDouble(3, entidade.getTempMin());
				sqlParametro.setDouble(4, entidade.getUmidRelativa());
				sqlParametro.setDouble(5, entidade.getveloVento());
				sqlParametro.setDouble(6, entidade.getradSolar());
				sqlParametro.setDouble(7, entidade.getETO());
				sqlParametro.setInt(8, entidade.getCodEstacao());
				sqlParametro.setInt(9, entidade.getCodRegistro());
				sqlParametro.executeUpdate();
				codigo = entidade.getCodRegistro();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Mensagens.mensagemDeErro(
					"O aplicativo está em uma pasta somente leitura que não permite gravações no banco de dados,\n mova-o para outra pasta e tente novamente.",
					e);
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

	public boolean excluir(RegistroEto entidade) {

		Connection conexao = new DBConnection().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		// boolean teste = false;
		try {
			sql = "delete from registroeto where CodRegistro = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, entidade.getCodRegistro());
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

	public List<RegistroEto> listar() {

		Connection conexao = new DBConnection().geraConexao();
		List<RegistroEto> lista = new ArrayList<RegistroEto>();
		Statement consulta = null;
		ResultSet resultado = null;
		RegistroEto entidade = null;
		String sql;
		try {
			sql = "select * from registroeto order by CodRegistro, DataRegistro, TempMax, TempMin, UmidRelativa, veloVento, radSolar, ETO, CodEstacao;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new RegistroEto();
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

	public RegistroEto buscarPorCodigo(int codigo) {

		Connection conexao = new DBConnection().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		RegistroEto entidade = null;
		String sql;
		try {
			sql = "select * from registroeto where CodRegistro = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				entidade = new RegistroEto();
				entidade.setCodRegistro(resultado.getInt("CodRegistro"));
				entidade.setDataRegistro(resultado.getDate("DataRegistro"));
				entidade.setTempMax(resultado.getDouble("TempMax"));
				entidade.setTempMin(resultado.getDouble("TempMin"));
				entidade.setUmidRelativa(resultado.getDouble("UmidRelativa"));
				entidade.setveloVento(resultado.getDouble("veloVento"));
				entidade.setradSolar(resultado.getDouble("radSolar"));
				entidade.setETO(resultado.getDouble("ETO"));
				entidade.setCodEstacao(resultado.getInt("CodEstacao"));
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