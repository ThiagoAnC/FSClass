package br.ufg.inf.fullstack.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.ufg.inf.fullstack")
@EnableJpaRepositories("br.ufg.inf.fullstack")
@EntityScan("br.ufg.inf.fullstack.model.entities")
public class EscolaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaSpringApplication.class, args);
	}

}
