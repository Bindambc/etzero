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

import java.awt.Component;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.jdesktop.swingx.JXDatePicker;

import br.com.etzero.controller.crud.BLLEstacao;
import br.com.etzero.controller.crud.BLLRegistroeto;
import br.com.etzero.controller.views.BLLLisRegistroEto;
import br.com.etzero.entity.crud.Estacao;
import br.com.etzero.entity.crud.RegistroEto;
import br.com.etzero.entity.crud.RegistroImport;
import br.com.etzero.entity.views.LisRegistroEto;
import br.com.etzero.gui.framemodels.CadModel;
import br.com.etzero.gui.models.tablemodels.ModelLisRegistroEto;
import br.com.etzero.util.CalculoPM;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;

public class CadETO extends CadModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ///////////////////////////////////////////////////
	private JTextField tfLatitudeGraus;
	private JTextField tfLatitudeMinutos;
	private JTextField tfAltitude;
	private JTextField tfHemisferio;
	private JTextField tfTempMax;
	private JTextField tfTempMin;
	private JTextField tfUmidade;
	private JTextField tfVeloVento;
	private JTextField textField;
	private JTextField tfETO;
	// //////////////////////////////////////////////////
	private JComboBox<Estacao> cbEstacao;
	// //////////////////////////////////////////////////
	private JXDatePicker dpData;
	// //////////////////////////////////////////////////
	private JButton btnCalcular;
	// ///////////////////////////////////////////////////
	private LisRegistroEto object = new LisRegistroEto();
	private RegistroEto registro;
	private ModelLisRegistroEto modeloTabela = new ModelLisRegistroEto();
	// ///////////////////////////////////////////////////
	private BLLLisRegistroEto registroView = new BLLLisRegistroEto();
	private BLLRegistroeto registroCrud = new BLLRegistroeto();
	private BLLEstacao estacaoCrud = new BLLEstacao();

	// ///////////////////////////////////////////////////

	public CadETO() {
		setFrameIcon(new ImageIcon(CadETO.class.getResource("/images/doc-math-icon32.png")));
		panelTabela.setBounds(6, 282, 826, 181);
		scrollPane.setBounds(0, 0, 820, 181);
		panelCampos.setBounds(6, 73, 826, 181);
		setTitle("C\u00E1lculo da Eto - Penman-Monteith");

		cbEstacao = new JComboBox<Estacao>();
		cbEstacao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbEstacao.getSelectedIndex() > -1) {
					tfLatitudeGraus.setText("" + ((Estacao) cbEstacao.getSelectedItem()).getLatitudeGrau());
					tfLatitudeMinutos.setText("" + ((Estacao) cbEstacao.getSelectedItem()).getLatitudeMinuto());
					tfAltitude.setText("" + ((Estacao) cbEstacao.getSelectedItem()).getAltitude());
					if (((Estacao) cbEstacao.getSelectedItem()).getHemisferio().equalsIgnoreCase("n")) {
						tfHemisferio.setText("Norte");

					} else {
						tfHemisferio.setText("Sul");
					}

				}

			}
		});

		cbEstacao.setBounds(12, 30, 263, 26);
		panelCampos.add(cbEstacao);

		tfLatitudeGraus = new JTextField();
		tfLatitudeGraus.setEditable(false);
		tfLatitudeGraus.setBounds(287, 29, 122, 28);
		panelCampos.add(tfLatitudeGraus);
		tfLatitudeGraus.setColumns(10);

		JLabel lblEstao = new JLabel("Esta\u00E7\u00E3o");
		lblEstao.setBounds(12, 13, 55, 16);
		panelCampos.add(lblEstao);

		JLabel lblGraus = new JLabel("Graus");
		lblGraus.setBounds(287, 13, 55, 16);
		panelCampos.add(lblGraus);

		tfLatitudeMinutos = new JTextField();
		tfLatitudeMinutos.setEditable(false);
		tfLatitudeMinutos.setBounds(421, 29, 122, 28);
		panelCampos.add(tfLatitudeMinutos);
		tfLatitudeMinutos.setColumns(10);

		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setBounds(421, 13, 55, 16);
		panelCampos.add(lblMinutos);

		tfAltitude = new JTextField();
		tfAltitude.setEditable(false);
		tfAltitude.setBounds(555, 29, 122, 28);
		panelCampos.add(tfAltitude);
		tfAltitude.setColumns(10);

		JLabel lblAltitude = new JLabel("Altitude");
		lblAltitude.setBounds(555, 13, 55, 16);
		panelCampos.add(lblAltitude);

		tfHemisferio = new JTextField();
		tfHemisferio.setEditable(false);
		tfHemisferio.setBounds(689, 29, 122, 28);
		panelCampos.add(tfHemisferio);
		tfHemisferio.setColumns(10);

		JLabel lblHemisfrio = new JLabel("Hemisf\u00E9rio");
		lblHemisfrio.setBounds(689, 13, 93, 16);
		panelCampos.add(lblHemisfrio);

		dpData = new JXDatePicker();
		dpData.setBounds(12, 82, 152, 28);
		panelCampos.add(dpData);

		JLabel lblData = new JLabel("Data (dd/mm/aaaa)");
		lblData.setBounds(12, 65, 152, 16);
		panelCampos.add(lblData);

		tfTempMax = new JTextField();
		tfTempMax.setBounds(176, 82, 122, 28);
		panelCampos.add(tfTempMax);
		tfTempMax.setColumns(10);

		JLabel lblTemperaturaMax = new JLabel("Temperatura Max (C\u00BA)");
		lblTemperaturaMax.setBounds(176, 65, 122, 16);
		panelCampos.add(lblTemperaturaMax);

		tfTempMin = new JTextField();
		tfTempMin.setBounds(310, 82, 122, 28);
		panelCampos.add(tfTempMin);
		tfTempMin.setColumns(10);

		JLabel lblTemperaturaMin = new JLabel("Temperatura Min (C\u00BA)");
		lblTemperaturaMin.setBounds(310, 65, 122, 16);
		panelCampos.add(lblTemperaturaMin);

		tfUmidade = new JTextField();
		tfUmidade.setBounds(444, 82, 122, 28);
		panelCampos.add(tfUmidade);
		tfUmidade.setColumns(10);

		JLabel lblUmidadeRelativa = new JLabel("Umidade Relativa (%)");
		lblUmidadeRelativa.setBounds(444, 65, 122, 16);
		panelCampos.add(lblUmidadeRelativa);

		tfVeloVento = new JTextField();
		tfVeloVento.setBounds(578, 82, 122, 28);
		panelCampos.add(tfVeloVento);
		tfVeloVento.setColumns(10);

		JLabel lblVelocVento = new JLabel("Veloc. Vento (m/s)");
		lblVelocVento.setBounds(578, 65, 122, 16);
		panelCampos.add(lblVelocVento);

		textField = new JTextField();
		textField.setBounds(12, 133, 122, 28);
		panelCampos.add(textField);
		textField.setColumns(10);

		JLabel lblRadiaoSolar = new JLabel("Radia\u00E7\u00E3o Solar (W/m\u00B2)");
		lblRadiaoSolar.setBounds(12, 115, 138, 16);
		panelCampos.add(lblRadiaoSolar);

		tfETO = new JTextField();
		tfETO.setEditable(false);
		tfETO.setBounds(146, 133, 122, 28);
		panelCampos.add(tfETO);
		tfETO.setColumns(10);

		JLabel lblEto = new JLabel("ETO");
		lblEto.setBounds(151, 115, 55, 16);
		panelCampos.add(lblEto);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!calcular()) {
					Mensagens.mensagemAviso("Não foi possível calcular! Verifique o preenchimento correto dos campos.");
				}
			}
		});
		btnCalcular.setToolTipText("Clique para calcular (N\u00E3o ser\u00E1 salvo no banco)");
		btnCalcular.setBounds(280, 133, 90, 28);
		panelCampos.add(btnCalcular);
		// /////////////////////////////////////////////////////////
		controleComponentes(false);
		carregarModelos();
		// /////////////////////////////////////////////////////////

	}

	public CadETO(RegistroImport ri) {
		setFrameIcon(new ImageIcon(CadETO.class.getResource("/images/doc-math-icon32.png")));
		panelTabela.setBounds(6, 282, 826, 181);
		scrollPane.setBounds(0, 0, 820, 181);
		panelCampos.setBounds(6, 73, 826, 181);
		setTitle("C\u00E1lculo da Eto - Penman-Monteith");

		cbEstacao = new JComboBox<Estacao>();
		cbEstacao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbEstacao.getSelectedIndex() > -1) {
					tfLatitudeGraus.setText("" + ((Estacao) cbEstacao.getSelectedItem()).getLatitudeGrau());
					tfLatitudeMinutos.setText("" + ((Estacao) cbEstacao.getSelectedItem()).getLatitudeMinuto());
					tfAltitude.setText("" + ((Estacao) cbEstacao.getSelectedItem()).getAltitude());
					if (((Estacao) cbEstacao.getSelectedItem()).getHemisferio().equalsIgnoreCase("n")) {
						tfHemisferio.setText("Norte");

					} else {
						tfHemisferio.setText("Sul");
					}

				}

			}
		});

		cbEstacao.setBounds(12, 30, 263, 26);
		panelCampos.add(cbEstacao);

		tfLatitudeGraus = new JTextField();
		tfLatitudeGraus.setEditable(false);
		tfLatitudeGraus.setBounds(287, 29, 122, 28);
		panelCampos.add(tfLatitudeGraus);
		tfLatitudeGraus.setColumns(10);

		JLabel lblEstao = new JLabel("Esta\u00E7\u00E3o");
		lblEstao.setBounds(12, 13, 55, 16);
		panelCampos.add(lblEstao);

		JLabel lblGraus = new JLabel("Graus");
		lblGraus.setBounds(287, 13, 55, 16);
		panelCampos.add(lblGraus);

		tfLatitudeMinutos = new JTextField();
		tfLatitudeMinutos.setEditable(false);
		tfLatitudeMinutos.setBounds(421, 29, 122, 28);
		panelCampos.add(tfLatitudeMinutos);
		tfLatitudeMinutos.setColumns(10);

		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setBounds(421, 13, 55, 16);
		panelCampos.add(lblMinutos);

		tfAltitude = new JTextField();
		tfAltitude.setEditable(false);
		tfAltitude.setBounds(555, 29, 122, 28);
		panelCampos.add(tfAltitude);
		tfAltitude.setColumns(10);

		JLabel lblAltitude = new JLabel("Altitude");
		lblAltitude.setBounds(555, 13, 55, 16);
		panelCampos.add(lblAltitude);

		tfHemisferio = new JTextField();
		tfHemisferio.setEditable(false);
		tfHemisferio.setBounds(689, 29, 122, 28);
		panelCampos.add(tfHemisferio);
		tfHemisferio.setColumns(10);

		JLabel lblHemisfrio = new JLabel("Hemisf\u00E9rio");
		lblHemisfrio.setBounds(689, 13, 93, 16);
		panelCampos.add(lblHemisfrio);

		dpData = new JXDatePicker();
		dpData.setBounds(12, 82, 152, 28);
		panelCampos.add(dpData);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(12, 65, 55, 16);
		panelCampos.add(lblData);

		tfTempMax = new JTextField();
		tfTempMax.setBounds(176, 82, 122, 28);
		panelCampos.add(tfTempMax);
		tfTempMax.setColumns(10);

		JLabel lblTemperaturaMax = new JLabel("Temperatura Max");
		lblTemperaturaMax.setBounds(176, 65, 122, 16);
		panelCampos.add(lblTemperaturaMax);

		tfTempMin = new JTextField();
		tfTempMin.setBounds(310, 82, 122, 28);
		panelCampos.add(tfTempMin);
		tfTempMin.setColumns(10);

		JLabel lblTemperaturaMin = new JLabel("Temperatura Min");
		lblTemperaturaMin.setBounds(310, 65, 122, 16);
		panelCampos.add(lblTemperaturaMin);

		tfUmidade = new JTextField();
		tfUmidade.setBounds(444, 82, 122, 28);
		panelCampos.add(tfUmidade);
		tfUmidade.setColumns(10);

		JLabel lblUmidadeRelativa = new JLabel("Umidade Relativa");
		lblUmidadeRelativa.setBounds(444, 65, 122, 16);
		panelCampos.add(lblUmidadeRelativa);

		tfVeloVento = new JTextField();
		tfVeloVento.setBounds(578, 82, 122, 28);
		panelCampos.add(tfVeloVento);
		tfVeloVento.setColumns(10);

		JLabel lblVelocVento = new JLabel("Veloc. Vento");
		lblVelocVento.setBounds(578, 65, 122, 16);
		panelCampos.add(lblVelocVento);

		textField = new JTextField();
		textField.setBounds(12, 133, 122, 28);
		panelCampos.add(textField);
		textField.setColumns(10);

		JLabel lblRadiaoSolar = new JLabel("Radia\u00E7\u00E3o Solar");
		lblRadiaoSolar.setBounds(12, 115, 122, 16);
		panelCampos.add(lblRadiaoSolar);

		tfETO = new JTextField();
		tfETO.setEditable(false);
		tfETO.setBounds(146, 133, 122, 28);
		panelCampos.add(tfETO);
		tfETO.setColumns(10);

		JLabel lblEto = new JLabel("ETO");
		lblEto.setBounds(146, 115, 55, 16);
		panelCampos.add(lblEto);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!calcular()) {
					Mensagens.mensagemAviso("Não foi possível calcular! Verifique o preenchimento correto dos campos.");
				}
			}
		});
		btnCalcular.setToolTipText("Clique para calcular (N\u00E3o ser\u00E1 salvo no banco)");
		btnCalcular.setBounds(280, 133, 90, 28);
		panelCampos.add(btnCalcular);
		// /////////////////////////////////////////////////////////

		status = statusCadastro.scInserindo;
		controleComponentes(true);
		carregarModelos();
		controleBotoes();
		preencheCampos(ri);
		// /////////////////////////////////////////////////////////

	}

	@Override
	protected void carregarModelos() {
		busyControle(true);
		modeloTabela.Recarregar(registroView.listar());
		tableView.setModel(modeloTabela);
		cbEstacao.setModel(new DefaultComboBoxModel<Estacao>(new Vector<Estacao>(estacaoCrud.listar())));

		busyControle(false);
	}

	@Override
	protected void preencherComponentes() {
		busyControle(true);
		object = modeloTabela.getEntidade(tableView.getSelectedRow());
		tfTempMax.setText("" + object.getTempMax());
		tfTempMin.setText("" + object.getTempMin());
		tfUmidade.setText("" + object.getUmidRelativa());
		tfVeloVento.setText("" + object.getveloVento());
		textField.setText("" + object.getradSolar());
		tfETO.setText("" + object.getETO());
		// ///////////////////////////////////////////////////////////////////////
		Estacao temp = new Estacao();
		temp = estacaoCrud.buscarPorCodigo(object.getCodEstacao());
		// ///////////////////////////////////////////////////////////////////////
		cbEstacao.setSelectedItem(temp);
		// cbEstacao.setSelectedIndex(cbEstacao.getModel().setSelectedItem(arg0););
		cbEstacao.getModel().setSelectedItem(temp);

		dpData.setDate(object.getDataRegistro());
		// cbEstacao.setSelectedIndex(modeloCombo.getIndexOf(estacaoCrud
		// .buscarPorCodigo(object.getCodEstacao())));
		tfLatitudeGraus.setText("" + temp
				.getLatitudeGrau() /*
									 * ((Estacao) cbEstacao .getSelectedItem ()
									 * ).getLatitudeGrau ()
									 */);
		tfLatitudeMinutos.setText("" + temp
				.getLatitudeMinuto()/*
									 * ((Estacao) cbEstacao .getSelectedItem
									 * ()). getLatitudeMinuto ()
									 */);
		tfAltitude.setText(
				"" + temp.getAltitude() /*
										 * ((Estacao) cbEstacao.getSelectedItem
										 * ()).getAltitude()
										 */);
		if (temp.getHemisferio().equalsIgnoreCase(
				"n")/*
					 * ((Estacao) cbEstacao.getSelectedItem ()).getHemisferio()
					 * .equalsIgnoreCase("n")
					 */) {
			tfHemisferio.setText("Norte");

		} else {
			tfHemisferio.setText("Sul");
		}

		registro = new RegistroEto();

		registro.setCodEstacao(object.getCodEstacao());
		registro.setCodRegistro(object.getCodRegistro());
		registro.setDataRegistro(object.getDataRegistro());
		registro.setETO(object.getETO());
		registro.setradSolar(object.getradSolar());
		registro.setTempMax(object.getTempMax());
		registro.setTempMin(object.getTempMin());
		registro.setUmidRelativa(object.getUmidRelativa());
		registro.setveloVento(object.getveloVento());

		busyControle(false);

	}

	@Override
	protected boolean btnSalvar() {
		for (Component comp : panelCampos.getComponents()) {

			if ((comp.getClass().getSimpleName().equals("JTextField"))) {

				if (((JTextField) comp).getText().equals(null)) {
					return false;
				}
			}
		}
		if (!status.equals(statusCadastro.scEditando)) {
			object = new LisRegistroEto();
		}

		try {
			object.setCodEstacao(((Estacao) cbEstacao.getSelectedItem()).getCodEstacao());
			object.setDataRegistro(dpData.getDate());
			object.setETO(parse(tfETO.getText()));
			object.setradSolar(parse(textField.getText()));
			object.setTempMax(parse(tfTempMax.getText()));
			object.setTempMin(parse(tfTempMin.getText()));
			object.setUmidRelativa(parse(tfUmidade.getText()));
			object.setveloVento(parse(tfVeloVento.getText()));

			registro = new RegistroEto();

			registro.setCodEstacao(object.getCodEstacao());
			registro.setCodRegistro(object.getCodRegistro());
			registro.setDataRegistro(object.getDataRegistro());
			registro.setradSolar(object.getradSolar());
			registro.setTempMax(object.getTempMax());
			registro.setTempMin(object.getTempMin());
			registro.setUmidRelativa(object.getUmidRelativa());
			registro.setveloVento(object.getveloVento());

			new CalculoPM(((Estacao) cbEstacao.getSelectedItem()), registro);

			// verifica se foi gravado
			if (registroCrud.salvar(registro) == 0) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	protected boolean btnExcluir() {
		try {
			if (registroCrud.excluir(registro) == false) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean calcular() {
		try {
			registro = new RegistroEto();
			registro.setCodEstacao(((Estacao) cbEstacao.getSelectedItem()).getCodEstacao());
			registro.setDataRegistro(dpData.getDate());
			registro.setETO(parse(tfETO.getText()));
			registro.setradSolar(parse(textField.getText()));
			registro.setTempMax(parse(tfTempMax.getText()));
			registro.setTempMin(parse(tfTempMin.getText()));
			registro.setUmidRelativa(parse(tfUmidade.getText()));
			registro.setveloVento(parse(tfVeloVento.getText()));

			new CalculoPM(((Estacao) cbEstacao.getSelectedItem()), registro);

			tfETO.setText("" + registro.getETO());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void preencheCampos(RegistroImport ri) {
		tfTempMax.setText("" + ri.getTempArMax());
		tfTempMin.setText("" + ri.getTempArMin());
		tfUmidade.setText("" + ri.getUmidMed());
		tfVeloVento.setText("" + ri.getVelMedHora());
		textField.setText("" + ri.getRadSolMed());
		dpData.setDate(ri.getData());

	}
}
