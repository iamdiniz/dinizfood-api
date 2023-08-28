package com.diniz.food.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diniz.food.api.model.input.RestauranteInput;
import com.diniz.food.domain.model.Cozinha;
import com.diniz.food.domain.model.Restaurante;

@Component
public class RestauranteInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Restaurante toDomainObject(RestauranteInput restauranteInput) {
		return modelMapper.map(restauranteInput, Restaurante.class);
	}
	
	public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {
		// Para evitar : Caused by: org.hibernate.HibernateException: identifier of an instance
		// of com.diniz.food.domain.model.Cozinha was altered from 2 to 1. Essa exception.
		restaurante.setCozinha(new Cozinha());
		
		modelMapper.map(restauranteInput, restaurante);
	}
	
}
