package com.example.apitabelafip;

import com.example.apitabelafip.model.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeuAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MeuAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();

	}
}
