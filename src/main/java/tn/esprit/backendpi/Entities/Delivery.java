package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.TypeStatus;

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
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDelivery;
    LocalDate deliveryDate;
    TypeStatus status;
    String destinationAdress;

    @ToString.Exclude
    @ManyToMany
    List<Command>commandsDelivery=new ArrayList<>();

    @ToString.Exclude
    @ManyToOne
    User userDelivey;

}