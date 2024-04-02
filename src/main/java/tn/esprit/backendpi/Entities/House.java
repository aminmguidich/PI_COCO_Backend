package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idHouse;
    String image;
    @Enumerated(EnumType.STRING)
    HouseType houseType;
    Long places;

    @OneToMany(mappedBy = "houseAnnoCollocation")
    List<AnnouncementCollocation>announcementCollocationsHouse;
    @OneToOne
    Contract contractHouse;


}
