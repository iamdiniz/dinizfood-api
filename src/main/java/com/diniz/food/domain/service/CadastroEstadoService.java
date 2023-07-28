package com.diniz.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diniz.food.domain.exception.EntidadeEmUsoException;
import com.diniz.food.domain.exception.EntidadeNaoEncontradaException;
import com.diniz.food.domain.model.Estado;
import com.diniz.food.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	private static final String MSG_ESTADO_EM_USO
		= "Estado de código %d não pode ser removida, pois está em uso";

	private static final String MSG_ESTADO_NAO_ENCONTRADO
		= "Não existe um cadastro de estado com código %d";
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			Estado estado = buscarOuFalhar(estadoId);
			estadoRepository.deleteById(estado.getId());
		  
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_ESTADO_EM_USO, estadoId));
	   }
	}
	
	public Estado buscarOuFalhar(Long cozinhaId) {
		return estadoRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_ESTADO_NAO_ENCONTRADO, cozinhaId)));
	}
	
}
