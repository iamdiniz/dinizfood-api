package com.diniz.food.domain.repository;

import java.util.List;

import com.diniz.food.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Long id);
	
}
