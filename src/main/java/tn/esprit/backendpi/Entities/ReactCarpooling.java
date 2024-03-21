package tn.esprit.backendpi.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.TypeReact;

import java.io.Serializable;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReactCarpooling implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReactCarpooling;
    @Enumerated(EnumType.STRING)
    TypeReact typeReact;



}