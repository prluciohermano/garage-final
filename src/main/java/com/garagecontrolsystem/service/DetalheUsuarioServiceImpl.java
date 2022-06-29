package com.garagecontrolsystem.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.garagecontrolsystem.data.DetalheUsuarioData;
import com.garagecontrolsystem.entity.Usuario;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService{
	
	private final UsuarioService usuarioService;
	
	public DetalheUsuarioServiceImpl(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = usuarioService.findByLogin(username);
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado!");
		}
		
		return new DetalheUsuarioData(usuario);
	}

}
