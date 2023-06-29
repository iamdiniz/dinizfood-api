package com.diniz.food.domain.repository;

import java.util.List;

import com.diniz.food.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Long id);
	
}
