package tn.esprit.backendpi.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.TypeCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduct;
    String image;
    String description;
    String title;
    @Enumerated(EnumType.STRING)
    TypeCategory category;
    Boolean status;
    @ToString.Exclude
    @ManyToOne
    Command commandProduct;
    @ToString.Exclude
    @ManyToMany
    List<User>usersProducts=new ArrayList<>();
}
