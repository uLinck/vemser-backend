package br.com.dbc.vemser.pessoaapilog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PessoaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApiApplication.class, args);
	}

}
