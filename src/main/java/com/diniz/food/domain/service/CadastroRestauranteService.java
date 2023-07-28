package com.diniz.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diniz.food.domain.exception.EntidadeNaoEncontradaException;
import com.diniz.food.domain.model.Cozinha;
import com.diniz.food.domain.model.Restaurante;
import com.diniz.food.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	private static final String MSG_RESTAURANTE_NAO_ENCONTRADO 
		= "Não existe um cadastro de restaurante com código %d";
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
	
	public Restaurante buscarOuFalhar(Long cozinhaId) {
		return restauranteRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, cozinhaId)));
	}
	
}
