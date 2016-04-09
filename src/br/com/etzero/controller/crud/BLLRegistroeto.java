package br.com.etzero.controller.crud;

import java.util.*;

import br.com.etzero.dao.crud.DAORegistroEto;
import br.com.etzero.entity.crud.RegistroEto;

public class BLLRegistroeto implements IBLLCrud<RegistroEto> {

	public int salvar(RegistroEto entidade) {
		return new DAORegistroEto().salvar(entidade);
	}

	public boolean excluir(RegistroEto entidade) {
		return new DAORegistroEto().excluir(entidade);
	}

	public List<RegistroEto> listar() {
		return new DAORegistroEto().listar();
	}

	public RegistroEto buscarPorCodigo(int codigo) {
		return new DAORegistroEto().buscarPorCodigo(codigo);
	}
}