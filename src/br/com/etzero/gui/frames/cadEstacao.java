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

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

import br.com.etzero.controller.crud.BLLEstacao;
import br.com.etzero.controller.views.BLLLisEstacao;
import br.com.etzero.entity.crud.Estacao;
import br.com.etzero.entity.views.LisEstacao;
import br.com.etzero.gui.framemodels.CadModel;
import br.com.etzero.gui.models.tablemodels.ModelLisEstacao;

import javax.swing.ImageIcon;

public class cadEstacao extends CadModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// /////////////////////////////////////////////////////////
	private JTextField tfDescricao;
	private JTextField tfLatitudeGrau;
	private JTextField tfLatitudeMinuto;
	private JTextField tfAltitude;
	// /////////////////////////////////////////////////////////
	private JComboBox<String> cbHemisferio;
	// /////////////////////////////////////////////////////////

	private BLLLisEstacao estacaoView = new BLLLisEstacao();
	private BLLEstacao estacaoCrud = new BLLEstacao();
	private ModelLisEstacao modeloTabela= new ModelLisEstacao(estacaoView.listar());
	// //////////////////////////////////////////////////////////
	private LisEstacao object = new LisEstacao();
	private Estacao estacao;

	// //////////////////////////////////////////////////////////

	public cadEstacao() {
		setFrameIcon(new ImageIcon(cadEstacao.class.getResource("/images/broadcast-station-icon32.png")));
		scrollPane.setBounds(0, 0, 820, 206);
		panelTabela.setBounds(6, 251, 826, 212);
		tableView.setBounds(9, 342, 814, -67);
		panelCampos.setBounds(6, 73, 826, 166);
		setTitle("Cadastro de Esta\u00E7\u00E3o");

		tfDescricao = new JTextField();
		tfDescricao.setBounds(12, 30, 537, 28);
		panelCampos.add(tfDescricao);
		tfDescricao.setColumns(10);

		cbHemisferio = new JComboBox<String>();
		cbHemisferio.setModel(new DefaultComboBoxModel<String>(new String[] { "Norte", "Sul" }));
		cbHemisferio.setBounds(561, 31, 253, 26);
		panelCampos.add(cbHemisferio);

		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o");
		lblDesc.setBounds(12, 13, 79, 16);
		panelCampos.add(lblDesc);

		JLabel lblHem = new JLabel("Hemisf\u00E9rio");
		lblHem.setBounds(561, 13, 97, 16);
		panelCampos.add(lblHem);

		tfLatitudeGrau = new JTextField();
		tfLatitudeGrau.setBounds(12, 103, 122, 28);
		panelCampos.add(tfLatitudeGrau);
		tfLatitudeGrau.setColumns(10);

		tfLatitudeMinuto = new JTextField();
		tfLatitudeMinuto.setBounds(146, 103, 122, 28);
		panelCampos.add(tfLatitudeMinuto);
		tfLatitudeMinuto.setColumns(10);

		JLabel lblLatitudeGraus = new JLabel("Latitude : Graus");
		lblLatitudeGraus.setBounds(12, 82, 122, 16);
		panelCampos.add(lblLatitudeGraus);

		JLabel lblLatitudeMinutos = new JLabel("Latitude : Minutos");
		lblLatitudeMinutos.setBounds(146, 82, 122, 16);
		panelCampos.add(lblLatitudeMinutos);

		tfAltitude = new JTextField();
		tfAltitude.setBounds(280, 103, 122, 28);
		panelCampos.add(tfAltitude);
		tfAltitude.setColumns(10);

		JLabel lblAltitudem = new JLabel("Altitude (m)");
		lblAltitudem.setBounds(280, 82, 122, 16);
		panelCampos.add(lblAltitudem);
		// /////////////////////////////////////////////////////////
		controleComponentes(false);
		carregarModelos();
		// /////////////////////////////////////////////////////////
	}

	@Override
	protected void carregarModelos() {
		// preenche e atualiza os componentes manipuladores de entidades
		busyControle(true);
		modeloTabela.Recarregar(estacaoView.listar());
		tableView.setModel(modeloTabela);
		busyControle(false);

	}

	@Override
	protected void preencherComponentes() {
		// quando a tabela é acionada:
		busyControle(true);
		object = modeloTabela.getEntidade(tableView.getSelectedRow());
		tfDescricao.setText(object.getDescricao());
		tfLatitudeGrau.setText("" + object.getLatitudeGrau());
		tfLatitudeMinuto.setText("" + object.getLatitudeMinuto());
		tfAltitude.setText("" + object.getAltitude());
		if (object.getHemisferio().equalsIgnoreCase("N")) {
			cbHemisferio.setSelectedIndex(0);
		} else {
			cbHemisferio.setSelectedIndex(1);
		}

		estacao = new Estacao();

		estacao.setAltitude(object.getAltitude());
		estacao.setCodEstacao(object.getCodEstacao());
		estacao.setDescricao(object.getDescricao());
		estacao.setHemisferio(object.getHemisferio());
		estacao.setLatitudeGrau(object.getLatitudeGrau());
		estacao.setLatitudeMinuto(object.getLatitudeMinuto());

		busyControle(false);

	}

	@Override
	protected boolean btnSalvar() {
		for (Component comp : panelCampos.getComponents()) {
			if ((comp.getClass().getSimpleName().equals("JTextField"))) {
				if (((JTextField) comp).getText().equals("")) {
					return false;
				}
			}
		}
		if (!status.equals(statusCadastro.scEditando)) {
			object = new LisEstacao();
		}

		try {
			object.setAltitude(Integer.parseInt(tfAltitude.getText()));
			object.setDescricao(tfDescricao.getText());
			object.setHemisferio((cbHemisferio.getSelectedItem().toString()).substring(0, 1));
			object.setLatitudeGrau(Integer.parseInt(tfLatitudeGrau.getText()));
			object.setLatitudeMinuto(Integer.parseInt(tfLatitudeMinuto.getText()));

			estacao = new Estacao();

			estacao.setAltitude(object.getAltitude());
			estacao.setCodEstacao(object.getCodEstacao());
			estacao.setDescricao(object.getDescricao());
			estacao.setHemisferio(object.getHemisferio());
			estacao.setLatitudeGrau(object.getLatitudeGrau());
			estacao.setLatitudeMinuto(object.getLatitudeMinuto());

			if (estacaoCrud.salvar(estacao) == 0) {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean btnExcluir() {
		try {
			if (estacaoCrud.excluir(estacao) == false) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
