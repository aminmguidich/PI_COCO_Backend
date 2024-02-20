package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Adress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAdress;
    String streetName;
    Long postCode;

    @ToString.Exclude
    @OneToOne(mappedBy = "adressUser")
    User userAdress;

    @ToString.Exclude
    @OneToOne(mappedBy = "adressAnnoCollocation")
    AnnouncementCollocation announcementCollocationAdress;


}
