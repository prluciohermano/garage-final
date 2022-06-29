package com.garagecontrolsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, name = "username", length = 20)
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String login;
    
    @Column(name = "password", length = 180)
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    
    @Column
    private boolean admin;

    
    public Usuario() {}
    
    
	public Usuario(Long id, String login, 
			String senha, boolean admin) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.admin = admin;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
