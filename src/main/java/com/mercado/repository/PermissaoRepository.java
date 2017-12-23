package com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercado.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    Permissao findByDescricao(String descricao);
}