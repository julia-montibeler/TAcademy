package com.tacademy.livro;

import org.springframework.boot.SpringApplication;

public class TestLivroApplication {

	public static void main(String[] args) {
		SpringApplication.from(LivroApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
