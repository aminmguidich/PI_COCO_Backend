package tn.esprit.backendpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories("tn.esprit.backendpi.Repository")
@EntityScan(basePackages = {"tn.esprit.backendpi.Entities"})
@EnableWebMvc
public class BackendPiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendPiApplication.class, args);
    }

}
