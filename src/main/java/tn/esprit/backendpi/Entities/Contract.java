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
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContract;
    String description;

    @ManyToMany(mappedBy = "contractsReqColl")
    List<RequirementCollocation>requirementCollocationsContact;
    @OneToOne(mappedBy = "contractHouse")
    House houseContract;



}
