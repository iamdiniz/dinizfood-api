package com.diniz.food.core.jackson;

import org.springframework.stereotype.Component;

import com.diniz.food.api.model.mixin.CidadeMixin;
import com.diniz.food.api.model.mixin.CozinhaMixin;
import com.diniz.food.api.model.mixin.RestauranteMixin;
import com.diniz.food.domain.model.Cidade;
import com.diniz.food.domain.model.Cozinha;
import com.diniz.food.domain.model.Restaurante;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixinModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public JacksonMixinModule() {
		setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
	}
	
}
