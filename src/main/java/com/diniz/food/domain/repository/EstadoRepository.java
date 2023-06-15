package com.diniz.food.domain.repository;

import java.util.List;

import com.diniz.food.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();
	Estado porId(Long id);
	Estado adicionar(Estado estado);
	void remover(Estado estado);
	
}
