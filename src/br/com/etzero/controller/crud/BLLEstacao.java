package br.com.etzero.controller.crud;

import java.util.*;

import br.com.etzero.dao.crud.DAOEstacao;
import br.com.etzero.entity.crud.Estacao;

public class BLLEstacao implements IBLLCrud<Estacao> {

	public int salvar(Estacao entidade) {
		return new DAOEstacao().salvar(entidade);
	}

	public boolean excluir(Estacao entidade) {
		return new DAOEstacao().excluir(entidade);
	}

	public List<Estacao> listar() {
		return new DAOEstacao().listar();
	}

	public Estacao buscarPorCodigo(int codigo) {
		return new DAOEstacao().buscarPorCodigo(codigo);
	}
}