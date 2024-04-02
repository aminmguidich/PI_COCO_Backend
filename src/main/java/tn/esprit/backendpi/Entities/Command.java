package tn.esprit.backendpi.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommand;
    String description;
    Float budget;
    LocalDate dateCommand;

    @ManyToOne
    User userCommand;
    @OneToMany(mappedBy = "commandProduct")
    List<Product>productsCommand;
}
