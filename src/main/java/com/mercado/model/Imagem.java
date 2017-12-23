package com.mercado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imagem")
public class Imagem {
	
	@Id
	@GeneratedValue
	@Column(name = "id_imagem")
	private Long idImagem;
	
	@Column(name = "nome_imagem")
	private String nomeImagem;
	
	@OneToOne(mappedBy = "imagem")
	private Produto produto;
	
	public Imagem(){}
	
	public Imagem(Long idImagem){
		this.idImagem = idImagem;
	}

	public Long getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(Long idImagem) {
		this.idImagem = idImagem;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
