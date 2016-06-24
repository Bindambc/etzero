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
package br.com.etzero.gui.frames;

import javax.swing.JOptionPane;

/**
 * 
 * @author Binda > mauriciobc.mbc@hotmail.com
 * @since 09/11/2013
 */
public class Mensagens {

	public static void mensagemDeErro(String texto, Exception e) {

		JOptionPane.showMessageDialog(null,
				"Sr(a) Usuário(a),\n\t" + texto + "\n" + "---------------------------------------\n\n" + e, "ERRO!",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void mensagemDeErro(String texto, Throwable t) {

		JOptionPane.showMessageDialog(null,
				"Sr(a) Usuário(a),\n\t" + texto + "\n" + "---------------------------------------\n\n" + t, "ERRO!",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void mensagemInformacao(String texto) {

		JOptionPane.showMessageDialog(null,
				"Sr(a) Usuário(a),\n\t" + texto + "\n" + "---------------------------------------\n", "INFORMAÇÃO!",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void mensagemAviso(String texto) {
		JOptionPane.showMessageDialog(null,
				"Sr(a) Usuário(a),\n\t" + texto + "\n" + "---------------------------------------\n", "AVISO!",
				JOptionPane.WARNING_MESSAGE);

	}

	public static int pergunta(String texto) {
		return JOptionPane.showConfirmDialog(null, texto, "ATENÇÃO!", JOptionPane.YES_NO_OPTION);
	}

	public static void defaultMensagemDBError(Exception e) {
		JOptionPane.showMessageDialog(null,
				"Sr(a) Usuário(a),\n\tParece que o banco de dados não"
						+ " está respondendo.\nIsso pode ter sido causado porque o serviço de SGBD foi "
						+ "interrompido ou não foi iniciado.\nPor favor, cheque suas configurações e reinicie o aplicativo\n"
						+ "---------------------------------------\n\n" + e,
				"ERRO!", JOptionPane.ERROR_MESSAGE);
	}

	public static void defaultMensagemDBError(Throwable t) {
		JOptionPane.showMessageDialog(null,
				"Sr(a) Usuário(a),\n\tParece que o banco de dados não"
						+ " está respondendo.\nIsso pode ter sido causado porque o serviço de SGBD foi "
						+ "interrompido ou não foi iniciado.\nPor favor, cheque suas configurações e reinicie o aplicativo\n"
						+ "---------------------------------------\n\n" + t,
				"ERRO!", JOptionPane.ERROR_MESSAGE);
	}

}
