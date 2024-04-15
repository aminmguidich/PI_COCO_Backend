package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    Float latitude ;
    Float longitude;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "adressUser")
    User userAdress;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "adressAnnoCollocation", cascade = CascadeType.ALL)
    AnnouncementCollocation announcementCollocationAdress;

}
