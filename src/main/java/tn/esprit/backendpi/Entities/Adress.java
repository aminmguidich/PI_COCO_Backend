package tn.esprit.backendpi.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAdress;
    String streetName;
    Long postCode;

    @OneToOne(mappedBy = "adressUser")
    User userAdress;
    @OneToOne(mappedBy = "adressAnnoCollocation")
    AnnouncementCollocation announcementCollocationAdress;


}
