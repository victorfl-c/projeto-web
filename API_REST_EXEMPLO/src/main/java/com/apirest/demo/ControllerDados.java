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
public class ControllerDados {
	private final RepositorioDados repository;

	ControllerDados(RepositorioDados repository) {
		this.repository = repository;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/listar")
	List<Dados> listar() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/cadastrar")
	Dados cadastrar(@RequestBody Dados dados) {
		return repository.save(dados);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/get/{id}")
	Dados get(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new DadosNotFoundException(id));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/login")
	DadosLogin login(@RequestBody DadosLogar dados) {
		Dados d = repository.findByNomeAndCpf(dados.getLogin(), dados.getSenha());
		DadosLogin d2 = new DadosLogin();
		d2.setCpf(d.getCpf());
		return d2; 
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/atualizar/{id}")
	Dados atualizar(@RequestBody Dados dadosNovo, @PathVariable Long id) {
		return repository.findById(id).map(dados -> {
			dados.setNome(dadosNovo.getNome());
			dados.setCpf(dadosNovo.getCpf());
			return repository.save(dados);
		}).orElseGet(() -> {
			dadosNovo.setId(id);
			return repository.save(dadosNovo);
		});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/remover/{id}")
	void remover(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
