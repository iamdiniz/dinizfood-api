package com.diniz.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diniz.food.api.assembler.RestauranteInputDisassembler;
import com.diniz.food.api.assembler.RestauranteModelAssembler;
import com.diniz.food.api.model.RestauranteModel;
import com.diniz.food.api.model.input.RestauranteInput;
import com.diniz.food.domain.exception.CozinhaNaoEncontradaException;
import com.diniz.food.domain.exception.NegocioException;
import com.diniz.food.domain.model.Restaurante;
import com.diniz.food.domain.repository.RestauranteRepository;
import com.diniz.food.domain.service.CadastroRestauranteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private RestauranteModelAssembler restauranteModelAssembler;
	
	@Autowired
	private RestauranteInputDisassembler restauranteInputDisassembler;
	
	@GetMapping
	public List<RestauranteModel> listar() {
		return restauranteModelAssembler.toCollectionModel(restauranteRepository.findAll());
	}
		
	@GetMapping("/{restauranteId}")
	public RestauranteModel buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
		
		return restauranteModelAssembler.toModel(restaurante);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RestauranteModel adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {
		try {
			Restaurante restaurante = restauranteInputDisassembler.toDomainObject(restauranteInput);
			
			return restauranteModelAssembler.toModel(restaurante = cadastroRestaurante.salvar(restaurante));
		} catch (CozinhaNaoEncontradaException  e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@PutMapping("/{restauranteId}")
	public RestauranteModel atualizar(@PathVariable Long restauranteId,
			@RequestBody RestauranteInput restauranteInput) {
		try {
//			Restaurante restaurante = restauranteInputDisassembler.toDomainObject(restauranteInput);
			
			Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);
			
			restauranteInputDisassembler.copyToDomainObject(restauranteInput, restauranteAtual);
			
//			BeanUtils.copyProperties(restaurante, restauranteAtual, "id",
//					"formasPagamento", "endereco", "dataCadastro", "produtos");
					
			
			return restauranteModelAssembler.toModel(cadastroRestaurante.salvar(restauranteAtual));
			} catch (CozinhaNaoEncontradaException  e) {
				throw new NegocioException(e.getMessage());
			}
	}
	
	// Removi o método patch porque nessa altura do campeonato não estava sendo necessário!, muito esforço
	
}
