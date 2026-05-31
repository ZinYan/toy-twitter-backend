package me.zinwaiyan.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ToyTwitterBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyTwitterBackendApplication.class, args);
    }

}
