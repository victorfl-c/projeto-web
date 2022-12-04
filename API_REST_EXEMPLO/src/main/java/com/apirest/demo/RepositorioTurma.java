package com.apirest.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTurma extends JpaRepository<Turma, Long> {
	Turma findByNomeAndDisciplina(String nome, String disciplina);
}

