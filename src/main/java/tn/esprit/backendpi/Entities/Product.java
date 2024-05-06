package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


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
    private String img;
    String description;
    float  price;
    String title;
    // String path;
    @Enumerated(EnumType.STRING)
    TypeStatus status;

    @ManyToOne
    @JsonIgnore
    Command commandProduct;

    @OneToMany(mappedBy = "product")
            @JsonIgnore
    List<CommandItem> commandItems=new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    List<User>usersProducts=new ArrayList<>();
    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    private Categorie categorie;
}