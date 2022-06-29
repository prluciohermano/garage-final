package com.garagecontrolsystem.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.garagecontrolsystem.entity.Pessoa;
import com.garagecontrolsystem.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	/* Métodos de CRUD */
	
/* Método de buscar todas as pessoas******************************/	
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}

	
/* Método de salvar uma pessoa ***********************************/	
	
	public Pessoa save(@Valid Pessoa pessoa) {
		return pessoaRepository.saveAndFlush(pessoa);
	}

/* Método de buscar por ID ***************************************/	
	
	public ResponseEntity<Pessoa> findById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
/* Método de deletar um ID ****************************************/	
	
	public ResponseEntity<Pessoa> deleteById(Long id) {
		if(pessoaRepository.existsById(id)) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
/* Método de update ************************************************/

	public ResponseEntity<Pessoa> updateById(Long id, Pessoa pessoa) {
		
		if (pessoaRepository.existsById(id)) {
			pessoa.setId(id);
			return ResponseEntity.ok(pessoaRepository.save(pessoa));
		}
		return ResponseEntity.notFound().build();	
	}
	
	
/* Método de buscar por nome *****************************************/	
	
	public List<Pessoa> buscarPorNome(String nomePessoa) {
		List<Pessoa> pessoa = pessoaRepository.buscarPorNome(nomePessoa);
		return pessoa;
	}
	
}
