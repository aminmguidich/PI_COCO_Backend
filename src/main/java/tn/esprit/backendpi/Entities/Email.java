package tn.esprit.backendpi.Entities;

import jakarta.persistence.Entity;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Email {
    private String to;
    private String subject;
    private String body;
}
