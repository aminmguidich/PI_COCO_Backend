package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequirementCollocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCollocationRequirement;
    String description;
    LocalDate dateCarpoolingCollocation;
    Float budgetPart;
    LocalDate universityYear;
    Boolean status;
    @ToString.Exclude
    @ManyToMany(mappedBy = "requirementCollocationsUser")
    List<User>usersRequirementCollocations=new ArrayList<>();
    @ToString.Exclude
    @ManyToOne
    AnnouncementCollocation announcementCollocationReq;
    @ToString.Exclude
    @ManyToMany
    List<Contract>contractsReqColl=new ArrayList<>();


}
