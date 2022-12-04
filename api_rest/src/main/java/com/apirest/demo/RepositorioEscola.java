package com.apirest.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEscola extends JpaRepository<Escola, Long> {
	Escola findByNome(String nome);
}
