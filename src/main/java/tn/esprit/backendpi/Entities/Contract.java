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
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContract;
    String description;
    Long nombre_de_places;
    HouseType houseType;
    String location;
    String owner;
    String uname;
    Long userId;
    Long houseId;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "contractsReqColl")
    List<RequirementCollocation>requirementCollocationsContact=new ArrayList<>();

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "contractHouse")
    House houseContract;



}
