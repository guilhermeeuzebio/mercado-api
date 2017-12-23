package com.mercado.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.io.Serializable;
//import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrinho")
public class Carrinho{ //implements Serializable {

	//private static final long serialVersionUID = 1L;

	@Column(name = "carrinho_id")
	@Id
	@GeneratedValue
	private Long idCarrinho;
		
	@Column(name = "quantidade_unidades")
	private Integer quantidadeUnidade; // x unidades igual uma caixa
	
	//private Integer quantidadeCaixa;
	
	//private String comercioMaisBarato;

	@Column(name = "valor_total")
	private Integer valorTotal;

	//@Column(name = "data_carrinho")
	//private LocalDateTime dataCarrinho;
	
	@ManyToOne
	@JoinColumn(name="usuario", nullable=false)
	//@ForeignKey(name="usuario_fk")
	private Usuario carrinho = new Usuario();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carrinho_produto", joinColumns = @JoinColumn(name = "carrinho_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produto = new ArrayList<Produto>();
	
	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	
	public Integer getQuantidadeUnidade() {
		return quantidadeUnidade;
	}

	public void setQuantidadeUnidade(Integer quantidadeUnidade) {
		this.quantidadeUnidade = quantidadeUnidade;
	}
	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Usuario getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Usuario carrinho) {
		this.carrinho = carrinho;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
/*
	public Integer getQuantidadeCaixa() {
		return quantidadeCaixa;
	}

	public void setQuantidadeCaixa(Integer quantidadeCaixa) {
		this.quantidadeCaixa = quantidadeCaixa;
	}

	public String getComercioMaisBarato() {
		return comercioMaisBarato;
	}

	public void setComercioMaisBarato(String comercioMaisBarato) {
		this.comercioMaisBarato = comercioMaisBarato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public LocalDateTime getDataCarrinho() {
		return dataCarrinho;
	}

	public void setDataCarrinho(LocalDateTime dataCarrinho) {
		this.dataCarrinho = dataCarrinho;
	}
*/
}
