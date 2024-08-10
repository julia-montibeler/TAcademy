package com.app.viagens;

import org.springframework.boot.SpringApplication;

public class TestViagensApplication {

	public static void main(String[] args) {
		SpringApplication.from(ViagensApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
