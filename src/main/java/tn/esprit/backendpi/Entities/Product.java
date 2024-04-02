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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduct;
    String image;
    String description;
    String title;
    @Enumerated(EnumType.STRING)
    TypeCategory category;
    Boolean status;

    @ManyToOne
    Command commandProduct;
    @ManyToMany
    List<User>usersProducts;
}
