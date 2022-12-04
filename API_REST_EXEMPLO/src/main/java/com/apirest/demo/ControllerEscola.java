package com.apirest.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscola {
	private final RepositorioEscola repository;

	ControllerEscola(RepositorioEscola repository) {
		this.repository = repository;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/listarEscola")
	List<Escola> listar() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/cadastrarEscola")
	Escola cadastrar(@RequestBody Escola escola) {
		return repository.save(escola);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getEscola/{id}")
	Escola get(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new EscolaNotFoundException(id));
	}
    
	/*
	@CrossOrigin(origins = "*")
	@GetMapping("/login")
	DadosLogin login(@RequestBody DadosLogar dados) {
		Dados d = repository.findByNomeAndCpf(dados.getLogin(), dados.getSenha());
		DadosLogin d2 = new DadosLogin();
		d2.setCpf(d.getCpf());
		return d2; 
	}
    */

	@CrossOrigin(origins = "*")
	@PutMapping("/atualizarEscola/{id}")
	Escola atualizar(@RequestBody Escola escolaNovo, @PathVariable Long id) {
		return repository.findById(id).map(escola -> {
			escola.setNome(escolaNovo.getNome());
			return repository.save(escola);
		}).orElseGet(() -> {
			escolaNovo.setId(id);
			return repository.save(escolaNovo);
		});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/removerEscola/{id}")
	void remover(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
