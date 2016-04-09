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
