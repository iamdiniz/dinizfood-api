package com.diniz.food.domain.repository;

import java.util.List;

import com.diniz.food.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	List<FormaPagamento> listar();
	FormaPagamento porId(Long id);
	FormaPagamento adicionar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);
	
}
