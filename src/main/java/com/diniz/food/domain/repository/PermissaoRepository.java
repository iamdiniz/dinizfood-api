package com.diniz.food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diniz.food.domain.model.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
