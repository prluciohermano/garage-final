package com.garagecontrolsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.garagecontrolsystem.entity.Usuario;
import com.garagecontrolsystem.service.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	private final  UsuarioService usuarioService;
	private final PasswordEncoder encoder;
	
	public UsuarioController(UsuarioService service, PasswordEncoder encoder) {
		this.usuarioService = service;
		this.encoder = encoder;
	}
	

	@GetMapping /* ************************************************ Busca todos os usuários */
    public List<Usuario> findAll(){
	return usuarioService.findAll();
		}
	
	@GetMapping("/validarsenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
												@RequestParam String senha) {
		
		Optional<Usuario> optUsuario = usuarioService.findByLogin(login);
			if(optUsuario.isEmpty()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		Usuario usuario = optUsuario.get();
		boolean valid = encoder.matches(senha, usuario.getSenha());
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);
		
	}
	
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar( @RequestBody @Valid Usuario usuario ){
       usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioService.save(usuario);
    }
}
