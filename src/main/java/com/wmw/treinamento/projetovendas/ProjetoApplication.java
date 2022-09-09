package com.wmw.treinamento.projetovendas;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class ProjetoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
