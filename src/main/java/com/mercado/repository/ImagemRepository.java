package com.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercado.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}
