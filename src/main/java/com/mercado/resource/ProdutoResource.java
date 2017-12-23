package com.mercado.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.model.Imagem;
import com.mercado.model.Produto;
import com.mercado.repository.ProdutoRepository;
import com.mercado.storage.StorageService;

@RestController
@RequestMapping("/api")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	StorageService storageService;
	
	@GetMapping("/produtos")
	@PreAuthorize("hasAuthority('ROLE_COMERCIO')")
	public List<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{idProduto}")
	@PreAuthorize("hasAuthority('ROLE_COMERCIO') and #oauth2.hasScope('read')")
	public Produto getProduto(@PathVariable Long idProduto) {
		return produtoRepository.findOne(idProduto);
	}
	
	@DeleteMapping("/produto/{idProduto}")
	@PreAuthorize("hasAuthority('ROLE_COMERCIO') and #oauth2.hasScope('write')")
	public boolean excluirProduto(@PathVariable Long idProduto) {
		produtoRepository.delete(idProduto);
		return true;
	}
	
	@PostMapping("/produto")
	@PreAuthorize("hasAuthority('ROLE_COMERCIO') and #oauth2.hasScope('write')")
	public Produto criarProduto(@RequestBody Produto produto, Imagem imagem){
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/produto")
	@PreAuthorize("hasAuthority('ROLE_COMERCIO') and #oauth2.hasScope('write')")
	public Produto editarProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
}