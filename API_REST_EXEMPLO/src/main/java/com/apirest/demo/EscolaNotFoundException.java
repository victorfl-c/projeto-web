package com.apirest.demo;

public class EscolaNotFoundException extends RuntimeException {

	EscolaNotFoundException(Long id) {
		super("Escola não encontrada " + id);
	}
}