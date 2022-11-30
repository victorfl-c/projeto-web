package com.apirest.demo;

public class DadosNotFoundException extends RuntimeException {

	DadosNotFoundException(Long id) {
		super("Aluno não encontrado " + id);
	}
}