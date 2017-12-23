package com.mercado.resource;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.model.Usuario;
import com.mercado.repository.PermissaoRepository;
import com.mercado.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class ComercioResource {
	
	@Autowired
	UsuarioRepository usuarioRepository;
		
	@Autowired
	PermissaoRepository permissaoRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/comercio")
	public Usuario criarContaComercio(@RequestBody Usuario usuario) {
        usuario.setPermissoes(Arrays.asList(permissaoRepository.findByDescricao("ROLE_COMERCIO")));
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);	
	}
	
}
