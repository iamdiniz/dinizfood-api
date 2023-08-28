package com.diniz.food.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.diniz.food.api.model.RestauranteModel;
import com.diniz.food.domain.model.Restaurante;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
		modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
			.addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);
		
		return modelMapper;
	}

}
