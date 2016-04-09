package br.com.etzero.controller.views;

import java.util.*;

import br.com.etzero.dao.views.DAOLisEstacao;
import br.com.etzero.entity.views.LisEstacao;

public class BLLLisEstacao implements IBLLView<LisEstacao> {

	public List<LisEstacao> listar() {
		return new DAOLisEstacao().listar();
	}

	public List<LisEstacao> filtrar(String condicao) {
		return new DAOLisEstacao().filtrar(condicao);
	}
}