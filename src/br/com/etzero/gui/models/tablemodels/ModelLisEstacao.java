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
package br.com.etzero.gui.models.tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import br.com.etzero.entity.views.LisEstacao;

public class ModelLisEstacao extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<LisEstacao> objetos;

	private String[] colunasJTable = new String[] { "CodEstacao", "Descricao", "LatitudeGrau", "LatitudeMinuto",
			"Hemisferio", "Altitude" };

	private String[] colunasTabela = new String[] { "CodEstacao", "Descricao", "LatitudeGrau", "LatitudeMinuto",
			"Hemisferio", "Altitude" };

	public ModelLisEstacao() {
		objetos = new ArrayList<LisEstacao>();
	}

	public ModelLisEstacao(List<LisEstacao> objetos1) {
		objetos = new ArrayList<LisEstacao>(objetos1);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return int.class;
		case 1:
			return String.class;
		case 2:
			return int.class;
		case 3:
			return int.class;
		case 4:
			return String.class;
		case 5:
			return int.class;
		default:
			throw new IndexOutOfBoundsException("Índice fora do limite");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		LisEstacao objeto = objetos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return objeto.getCodEstacao();
		case 1:
			return objeto.getDescricao();
		case 2:
			return objeto.getLatitudeGrau();
		case 3:
			return objeto.getLatitudeMinuto();
		case 4:
			return objeto.getHemisferio();
		case 5:
			return objeto.getAltitude();
		default:
			throw new IndexOutOfBoundsException("Índice fora do limite");
		}
	}

	@Override
	public int getColumnCount() {
		return colunasJTable.length;
	}

	@Override
	public int getRowCount() {
		return objetos.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunasJTable[columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	};

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	// Métodos implementados

	public void Recarregar(List<LisEstacao> objetos1) {
		objetos.clear();
		objetos.addAll(objetos1);
		fireTableDataChanged();
	}

	public LisEstacao getEntidade(int rowIndex) {
		LisEstacao objeto = objetos.get(rowIndex);
		return objeto;
	}

	public String getColunaTabela(int columnIndex) {
		return colunasTabela[columnIndex];
	};

}