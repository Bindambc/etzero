package br.com.etzero.gui.framemodels;

import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyVetoException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jdesktop.swingx.JXBusyLabel;

import br.com.etzero.gui.frames.Mensagens;

import javax.swing.UIManager;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Binda > mauriciobc.mbc@hotmail.com
 * @since 09/11/2013
 */
public abstract class CadModel extends JInternalFrame {

	// ////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;
	protected JTable tableView;
	// ////////////////////////////////////////////////////

	// ///////////////////////////////////////////////////
	protected JPanel panelBotoes;
	protected JPanel panelCampos;
	protected JPanel panelTabela;
	// ///////////////////////////////////////////////////

	// ///////////////////////////////////////////////////
	protected JButton btnNovo;
	protected JButton btnSalvar;
	protected JButton btnEditar;
	protected JButton btnCancelar;
	protected JButton btnExcluir;

	// ///////////////////////////////////////////////////

	// //////////////////////////////////////////////////////
	protected enum statusCadastro {
		scInserindo, scNavegando, scEditando, scVisualizando
	}

	protected statusCadastro status;

	// //////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////
	JXBusyLabel busy;
	protected JScrollPane scrollPane;

	private final JTextField textField = new JTextField();

	// //////////////////////////////////////////////////////

	// ///////////////////////////////////////////////////////

	// ///////////////////////////////////////////////////////

	public CadModel() {
		textField.setColumns(10);

		// //////////////////////////////////////////////////////
		setIconifiable(true);
		try {
			setSelected(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setRootPaneCheckingEnabled(false);
		setClosable(true);
		// //////////////////////////////////////////////////////

		setBounds(0, 0, 850, 500);
		// setMaximumSize(new Dimension(850, 500));

		getContentPane().setLayout(null);

		panelBotoes = new JPanel();
		panelBotoes.setBorder(null);
		panelBotoes.setBounds(6, 6, 826, 55);
		getContentPane().add(panelBotoes);
		panelBotoes.setLayout(null);

		btnNovo = new JButton("");
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				busyControle(true);
				controleComponentes(false);
				status = statusCadastro.scInserindo;
				controleBotoes();
				controleComponentes(true);

				busyControle(false);
			}
		});
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnNovo.setToolTipText("Novo");
		btnNovo.setIcon(new ImageIcon(CadModel.class.getResource("/resources/document-new.png")));
		btnNovo.setBounds(6, 6, 60, 46);
		panelBotoes.add(btnNovo);

		btnSalvar = new JButton("");
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				busyControle(true);
				if (Mensagens.pergunta("Tem certeza que deseja salvar as modificações?") == 0) {
					controleBotoes();
					if (btnSalvar()) {
						Mensagens.mensagemInformacao("Salvo com sucesso!");
					} else {
						Mensagens.mensagemAviso("Não foi possível salvar!");
					}
					status = statusCadastro.scNavegando;
					controleBotoes();
					controleComponentes(false);
					carregarModelos();
				}
				busyControle(false);

			}
		});
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnSalvar.setIcon(new ImageIcon(CadModel.class.getResource("/resources/media-floppy.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBounds(78, 6, 60, 46);
		panelBotoes.add(btnSalvar);

		btnEditar = new JButton("");
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busyControle(true);

				status = statusCadastro.scEditando;
				controleBotoes();
				controleComponentes(true);

				busyControle(false);
			}
		});
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnEditar.setIcon(new ImageIcon(CadModel.class.getResource("/resources/edit-find-replace.png")));
		btnEditar.setToolTipText("Editar");
		btnEditar.setBounds(150, 6, 60, 46);
		panelBotoes.add(btnEditar);

		btnCancelar = new JButton("");
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busyControle(true);
				status = statusCadastro.scNavegando;
				controleBotoes();
				controleComponentes(false);

				busyControle(false);
			}
		});
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnCancelar.setIcon(new ImageIcon(CadModel.class.getResource("/resources/process-stop.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setBounds(222, 6, 60, 46);
		panelBotoes.add(btnCancelar);

		btnExcluir = new JButton("");
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busyControle(true);
				if (Mensagens.pergunta("Tem certeza que deseja excluir o registro selecionado?") == 0) {
					status = statusCadastro.scVisualizando;
					controleBotoes();
					controleComponentes(false);
					if (btnExcluir()) {
						Mensagens.mensagemInformacao("Registro excluido com sucesso!");
					} else {
						Mensagens.mensagemAviso("Não foi possível excluir!");
					}
					carregarModelos();
				}
				busyControle(false);
			}
		});
		// ///////////////////////////////////////////////////////////////////////////////////////
		btnExcluir.setIcon(new ImageIcon(CadModel.class.getResource("/resources/edit-delete.png")));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setBounds(294, 6, 60, 46);
		panelBotoes.add(btnExcluir);

		panelCampos = new JPanel();
		panelCampos.setBorder(UIManager.getBorder("TitledBorder.border"));
		panelCampos.setBounds(6, 73, 826, 254);
		getContentPane().add(panelCampos);
		panelCampos.setLayout(null);

		busy = new JXBusyLabel(new Dimension(35, 35));
		busy.setBounds(298, 71, 169, 61);
		panelCampos.add(busy);
		busy.setText("Processando...");

		panelTabela = new JPanel();
		panelTabela.setBorder(null);
		panelTabela.setBounds(6, 339, 826, 124);
		getContentPane().add(panelTabela);
		panelTabela.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 820, 120);
		scrollPane.setAutoscrolls(true);
		panelTabela.add(scrollPane);

		tableView = new JTable();

		tableView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleComponentes(false);
				preencherComponentes();

				status = statusCadastro.scVisualizando;
				controleBotoes();

			}
		});
		scrollPane.setViewportView(tableView);
		tableView.setBorder(null);

		status = statusCadastro.scNavegando;
		controleBotoes();

		busyControle(false);
		controleComponentes(false);

		// carregarModelos();
	}

	protected void controleBotoes() {

		btnNovo.setEnabled(status == statusCadastro.scNavegando || status == statusCadastro.scVisualizando);

		btnSalvar.setEnabled(status == statusCadastro.scEditando || status == statusCadastro.scInserindo);

		btnEditar.setEnabled(status == statusCadastro.scVisualizando);

		btnCancelar.setEnabled(status == statusCadastro.scEditando || status == statusCadastro.scInserindo);

		btnExcluir.setEnabled(status == statusCadastro.scVisualizando);

	}

	@SuppressWarnings("rawtypes")
	protected void controleComponentes(boolean condicao) {
		for (Component comp : panelCampos.getComponents()) {

			comp.setEnabled(condicao);

			if ((comp.getClass().getSimpleName().equals("JTextField")) && (!condicao)) {
				((JTextField) comp).setText(null);
				((JTextField) comp).cut();
			}
			if ((comp.getClass().getSimpleName().equals("JFormattedTextField")) && (!condicao)) {
				((JFormattedTextField) comp).setText(null);
			}
			if ((comp.getClass().getSimpleName().equals("JComboBox"))) {

				((JComboBox) comp).setSelectedIndex(-1);
			}
			if ((comp.getClass().getSimpleName().equals("JScrollPane"))) {

				((JScrollPane) comp).setVisible(condicao);

			}
		}
	}

	protected void busyControle(boolean enable) {
		busy.setVisible(enable);
		busy.setBusy(enable);

	}

	/**
	 * Converte uma String para um double, corrigindo virgula e ponto
	 * 
	 * @param val
	 *            String : valor que se deseja converter
	 * @return double : valor convertido da String
	 */
	protected double parse(String val) {
		double value = 0;
		try {
			String cr = val.replace(",", ".");
			value = Double.parseDouble(cr);

		} catch (Exception e) {
			return 0;
		}
		return value;
	}

	protected abstract void carregarModelos();

	protected abstract void preencherComponentes();

	protected abstract boolean btnSalvar();

	protected abstract boolean btnExcluir();

}
