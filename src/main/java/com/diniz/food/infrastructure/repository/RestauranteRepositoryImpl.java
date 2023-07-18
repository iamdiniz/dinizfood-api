package com.diniz.food.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.diniz.food.domain.model.Restaurante;
import com.diniz.food.domain.repository.RestauranteRepositoryQueries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome,
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		criteria.from(Restaurante.class); // from Restaurante
		
		
		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
}
