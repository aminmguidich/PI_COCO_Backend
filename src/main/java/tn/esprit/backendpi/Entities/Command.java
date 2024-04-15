package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idCommand")

public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommand;
    String description;
    Float price;
    LocalDate dateCommand;

    @ToString.Exclude
    @ManyToOne
    User userCommand;
    @OneToMany(mappedBy = "commandProduct")
    @JsonIgnore
    List<Product>productsCommand=new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "commandsDelivery")
     @JsonIgnore
    List<Delivery>deliveriesCommand=new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "command")
    private List<CommandItem> commandItems;

}
