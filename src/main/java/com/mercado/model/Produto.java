package com.mercado.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue
	@Column(name = "produto_id")
	private Long idProduto;
	
	@Column(name = "produto_nome")
	private String produtoNome;

	@Column(name = "preco")
	private BigDecimal preco;

	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "lote_produto")
	private Long loteProduto;
	
	@Column(name = "codogo_barras")
	private Long codigoBarras;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Imagem imagem;	
	
	public Produto(){
		
	}
	
	public Produto(Long idProduto){
		this.idProduto = idProduto;
	}
	
	public Produto(Long idProduto, Imagem imagem){
		this.idProduto = idProduto;
		this.imagem = imagem;
	}
	
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getLoteProduto() {
		return loteProduto;
	}

	public void setLoteProduto(Long loteProduto) {
		this.loteProduto = loteProduto;
	}

	public Long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	
}
