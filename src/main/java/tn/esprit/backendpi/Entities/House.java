package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.HouseType;

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

public class House implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idHouse;
    String image;
    @Enumerated(EnumType.STRING)
    HouseType houseType;
    Long places;

    @ToString.Exclude
    @OneToMany(mappedBy = "houseAnnoCollocation")
    List<AnnouncementCollocation>announcementCollocationsHouse=new ArrayList<>();
    @ToString.Exclude
    @OneToOne
    Contract contractHouse;


}
