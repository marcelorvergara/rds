package edu.infnet;

import edu.infnet.repository.PersonRepository;
import edu.infnet.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository) {
        return args -> {
            log.info("Teste User 3" + personRepository.save(new Person("aluno 3", "sobrenome 3", "rua 7 beco 8", "rio de janeiro")));

        };
    }
}
