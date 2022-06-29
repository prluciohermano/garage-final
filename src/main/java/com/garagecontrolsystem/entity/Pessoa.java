package com.garagecontrolsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;




@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	 
		private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", length = 100)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column(name = "cpf", length = 11)
	@NotEmpty(message = "{campo.cpf.obrigatorio}")
	//@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	@Column(name = "rg", length = 100)
	@NotEmpty(message = "{campo.rg.obrigatorio}")
	private String rg;
	
	@Column(name = "sexo", length = 100)
	@NotEmpty(message = "{campo.sexo.obrigatorio}")
	private String sexo;
	
	@Column(name = "cep", length = 100)
	@NotEmpty(message = "{campo.cep.obrigatorio}")
	private String cep;
	
	@Column(name = "rua", length = 100)
	@NotEmpty(message = "{campo.rua.obrigatorio}")
	private String rua;
	
	@Column(name = "numero", length = 100)
	@NotEmpty(message = "{campo.numero.obrigatorio}")
	private String numero;
	
	@Column(name = "bairro", length = 100)
	@NotEmpty(message = "{campo.bairro.obrigatorio}")
	private String bairro;
	
	@Column(name = "comp", length = 100)
	private String comp;
	
	@Column(name = "cidade", length = 100)
	@NotEmpty(message = "{campo.cidade.obrigatorio}")
	private String cidade;
	
	@Column(name = "uf", length = 100)
	@NotEmpty(message = "{campo.uf.obrigatorio}")
	private String uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
		
	
}
