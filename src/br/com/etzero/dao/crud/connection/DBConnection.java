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
package br.com.etzero.dao.crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.etzero.gui.frames.Mensagens;

public class DBConnection {

	public Connection geraConexao() {
		Connection conexao = null;

		/*
		 * Para testar o aplicativo dentro do eclipse utilize o código abaixo:
		 */
		// String url = "jdbc:sqlite:" + System.getProperty("user.dir") +
		// "/database/etzerodata.sdb";

		/*
		 * Para trabalhar com linux e windows utilize o código abaixo:
		 * 
		 */
		String url = "jdbc:sqlite:" + this.getClass().getResource("../../../../../../") + "/database/etzerodata.sdb";

		try {
			conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			Mensagens.mensagemDeErro(
					"O arqvivo de banco de dados não foi encontrado. Cheque a pasta \"database\" e procure o arquivo \"etzerodata.sdb\"",
					e);
			e.printStackTrace();
		}

		return conexao;

	}

}
