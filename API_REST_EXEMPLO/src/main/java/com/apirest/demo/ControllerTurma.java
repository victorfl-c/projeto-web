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
public class ControllerTurma {
	private final RepositorioTurma repository;

	ControllerTurma(RepositorioTurma repository) {
		this.repository = repository;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/listarturma")
	List<Turma> listar() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/cadastrarturma")
	Turma cadastrar(@RequestBody Turma turma) {
		return repository.save(turma);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getturma/{id}")
	Turma get(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new TurmaNotFoundException(id));
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
	@PutMapping("/atualizarturma/{id}")
	Turma atualizar(@RequestBody Turma turmaNovo, @PathVariable Long id) {
		return repository.findById(id).map(turma -> {
			turma.setNome(turmaNovo.getNome());
			return repository.save(turma);
		}).orElseGet(() -> {
			turmaNovo.setId(id);
			return repository.save(turmaNovo);
		});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/removerturma/{id}")
	void remover(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
