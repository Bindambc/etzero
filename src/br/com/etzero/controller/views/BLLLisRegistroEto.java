package br.com.etzero.controller.views;

import java.util.*;

import br.com.etzero.dao.views.DAOLisRegistroEto;
import br.com.etzero.entity.views.LisRegistroEto;

public class BLLLisRegistroEto implements IBLLView<LisRegistroEto> {

	public List<LisRegistroEto> listar() {
		return new DAOLisRegistroEto().listar();
	}

	public List<LisRegistroEto> filtrar(String condicao) {
		return new DAOLisRegistroEto().filtrar(condicao);
	}
}