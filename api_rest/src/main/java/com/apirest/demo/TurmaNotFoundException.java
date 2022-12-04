package com.apirest.demo;

public class TurmaNotFoundException extends RuntimeException {

	TurmaNotFoundException(Long id) {
		super("Turma não encontrada " + id);
	}
}