package tn.esprit.backendpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BackendPiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendPiApplication.class, args);
    }

}
