package com.example.demo;

import java.util.logging.Level;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ExemploH2Application {
	private final RepositorioAluno repository;

    public ExemploH2Application(RepositorioAluno repository) {
        this.repository = repository;
    }
	public static void main(String[] args) {
		SpringApplication.run(ExemploH2Application.class, args);
	}

	@Primary
	@Bean
	public CommandLineRunner cadastrarAluno() {
		return (args) -> {
			Aluno obj = new Aluno();
	        obj.setCpf("123");
	        obj.setNome("Melo");
	        System.out.println("Cadastrando aluno");
//	        repository.save(obj);
	        System.out.println(obj.toString());
		};
	}
	
	@Bean
	public CommandLineRunner listarAlunos() {
		return (args) -> {
			System.out.println("Listando os alunos");
	        repository.findAll().forEach(it -> System.out.println(it.toString()));
		};
	}
}
