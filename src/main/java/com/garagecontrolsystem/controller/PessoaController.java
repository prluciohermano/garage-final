package com.garagecontrolsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.garagecontrolsystem.entity.Pessoa;
import com.garagecontrolsystem.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/pessoas")
@Api("Api Pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
			
	@GetMapping("/{id}")  /* ***************************************** Buscar pessoa por ID */
	@ApiOperation("Obter detalhes de um cliente puxando pelo ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Pessoa encontrada"),
		@ApiResponse(code = 404, message = "Pessoa não encontrado para o ID informado")
	})
	public ResponseEntity<Pessoa> findById ( 
			@PathVariable @ApiParam("id") Long id) {
		return pessoaService.findById(id);
	}
		
	
	@PostMapping  /* *****************************************************  Salvar pessoa */
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation("Cria um novo pessoa")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Pessoa salvo com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public Pessoa save( @RequestBody @Valid Pessoa pessoa ) {
		return pessoaService.save(pessoa);
	}
	
	
	@DeleteMapping("{id}")  /* ********************************************* Deletar Pessoa */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Deleta uma Pessoa")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Pessoa deletadao com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public ResponseEntity<Pessoa> deleteById( @PathVariable Long id) {
		return pessoaService.deleteById(id);
	}
	
	
	@PutMapping("/{id}")  /* ********************** Atualizar um Pessoa */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation("Altera os dados de um Pessoa")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Pessoa alterado com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	public ResponseEntity<Pessoa> update( @PathVariable Long id,
			@RequestBody @Valid Pessoa pessoa){
			return pessoaService.updateById(id, pessoa);
	}
	
	 /* ******************************* Busca pessoa por nome */
	
	@GetMapping(value = "/buscarPorNome") /* mapeia a url */
	@ApiOperation("Busca uma Pessoa por nome")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Pessoa encontrado com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	
	public ResponseEntity<List<Pessoa>> buscarPorNome(@RequestParam(name = "nome") String nome) { /* Recebe os dados para consultar */

		List<Pessoa> pessoa = pessoaService.buscarPorNome(nome.trim().toUpperCase());

		return new ResponseEntity<List<Pessoa>>(pessoa, HttpStatus.OK);

	}
	
	@GetMapping /* ************************************************ Busca todos as Pessoas */
	@ApiOperation("Busca todos as Pessoas")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Pessoas encontradas com sucesso"),
		@ApiResponse(code = 400, message = "Erro de validação")
	})
	    public List<Pessoa> findAll(){
			return pessoaService.findAll();
		}
	
//	@GetMapping("/pessoas/{id}")
//	public ModelAndView getPessoas(@PathVariable(name = "id") Long id) {
//		
//		ResponseEntity<Pessoa> pessoa = pessoaService.findById(id);
//		ModelAndView mv = new ModelAndView("pessoas");
//		mv.addObject("pessoa", pessoa);		
//		return mv;
//		
//	}

}
