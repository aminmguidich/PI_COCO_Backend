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
public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContract;
    String description;

    @ToString.Exclude
    @ManyToMany(mappedBy = "contractsReqColl")
    List<RequirementCollocation>requirementCollocationsContact=new ArrayList<>();

    @ToString.Exclude
    @OneToOne(mappedBy = "contractHouse")
    House houseContract;



}
