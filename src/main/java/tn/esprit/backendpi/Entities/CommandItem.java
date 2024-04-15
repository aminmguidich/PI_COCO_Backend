package tn.esprit.backendpi.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageUrl;
    private Float unitPrice;
    private int quantite;
    @ToString.Exclude
    @ManyToOne
    private Product product;
    @ToString.Exclude
    @ManyToOne
    private Command command;

}
