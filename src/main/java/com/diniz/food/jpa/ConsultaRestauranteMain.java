package com.diniz.food.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.diniz.food.DinizfoodApiApplication;
import com.diniz.food.domain.model.Restaurante;
import com.diniz.food.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(DinizfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		List<Restaurante> todosRestaurantes = restaurantes.todas();
		
		for(Restaurante restaurante : todosRestaurantes) {
			System.out.println(restaurante.getNome());
		}
		
	}
}