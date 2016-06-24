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
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.etzero.entity.views.LisRegistroEto;

public class ModelLisRegistroEto extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<LisRegistroEto> objetos;

	private String[] colunasJTable = new String[] { "CodRegistro", "DataRegistro", "TempMax", "TempMin", "UmidRelativa",
			"veloVento", "radSolar", "ETO", "CodEstacao" };

	private String[] colunasTabela = new String[] { "CodRegistro", "DataRegistro", "TempMax", "TempMin", "UmidRelativa",
			"veloVento", "radSolar", "ETO", "CodEstacao" };

	public ModelLisRegistroEto() {
		objetos = new ArrayList<LisRegistroEto>();
	}

	public ModelLisRegistroEto(List<LisRegistroEto> objetos1) {
		objetos = new ArrayList<LisRegistroEto>(objetos1);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return int.class;
		case 1:
			return Date.class;
		case 2:
			return double.class;
		case 3:
			return double.class;
		case 4:
			return double.class;
		case 5:
			return double.class;
		case 6:
			return double.class;
		case 7:
			return double.class;
		case 8:
			return int.class;
		default:
			throw new IndexOutOfBoundsException("Índice fora do limite");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		LisRegistroEto objeto = objetos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return objeto.getCodRegistro();
		case 1:
			return objeto.getDataRegistro();
		case 2:
			return objeto.getTempMax();
		case 3:
			return objeto.getTempMin();
		case 4:
			return objeto.getUmidRelativa();
		case 5:
			return objeto.getveloVento();
		case 6:
			return objeto.getradSolar();
		case 7:
			return objeto.getETO();
		case 8:
			return objeto.getCodEstacao();
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

	public void Recarregar(List<LisRegistroEto> objetos1) {
		objetos.clear();
		objetos.addAll(objetos1);
		fireTableDataChanged();
	}

	public LisRegistroEto getEntidade(int rowIndex) {
		LisRegistroEto objeto = objetos.get(rowIndex);
		return objeto;
	}

	public String getColunaTabela(int columnIndex) {
		return colunasTabela[columnIndex];
	};

}