package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommand;
    String description;
    Float budget;
    LocalDate dateCommand;

    @ToString.Exclude
    @ManyToOne
    User userCommand;
    @OneToMany(mappedBy = "commandProduct")
    List<Product>productsCommand=new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "commandsDelivery")
    List<Delivery>deliveriesCommand=new ArrayList<>();
}
