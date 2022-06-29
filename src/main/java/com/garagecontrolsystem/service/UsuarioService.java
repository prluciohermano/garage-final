package com.garagecontrolsystem.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.garagecontrolsystem.entity.Usuario;
import com.garagecontrolsystem.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/* Métodos de CRUD */
	
/* Método de buscar todas as pessoas******************************/	
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

	
/* Método de salvar um usuário ***********************************/	
	
	public Usuario save(@Valid Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

/* Método de buscar por ID ***************************************/	
	
	public ResponseEntity<Usuario> findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		return ResponseEntity.notFound().build();
	}
	
/* Método de buscar por ID ***************************************/	
	
	public Optional<Usuario> findByLogin(String login) {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
		if(usuario.isPresent()) {
			return Optional.of(usuario.get());
		}
		return Optional.empty();
	}
	
	
/* Método de deletar um ID ****************************************/	
	
	public ResponseEntity<Usuario> deleteById(Long id) {
		if(usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
/* Método de update ************************************************/

	public ResponseEntity<Usuario> updateById(Long id, Usuario usuario) {
		
		if (usuarioRepository.existsById(id)) {
			usuario.setId(id);
			return ResponseEntity.ok(usuarioRepository.save(usuario));
		}
		return ResponseEntity.notFound().build();	
	}	
}
