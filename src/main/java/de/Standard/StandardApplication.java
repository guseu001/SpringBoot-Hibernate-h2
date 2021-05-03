package de.Standard;

import de.Standard.Model.Kunde;
import de.Standard.Repository.KundeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StandardApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandardApplication.class, args);
	}

}
