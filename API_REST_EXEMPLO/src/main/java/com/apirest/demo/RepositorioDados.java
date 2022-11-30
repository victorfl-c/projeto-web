package com.apirest.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDados extends JpaRepository<Dados, Long> {
	Dados findByNomeAndCpf(String nome, String cpf);
}
