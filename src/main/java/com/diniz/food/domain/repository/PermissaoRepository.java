package com.diniz.food.domain.repository;

import java.util.List;

import com.diniz.food.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();
	Permissao porId(Long id);
	Permissao adicionar(Permissao permissao);
	void remover(Permissao permissao);
	
}
