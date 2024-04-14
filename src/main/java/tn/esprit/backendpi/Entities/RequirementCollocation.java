package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequirementCollocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCollocationRequirement;
    String description;
    LocalDate dateCarpoolingCollocation;
    Float budgetPart;
    LocalDate universityYear;
    Boolean status;

    @ManyToMany(mappedBy = "requirementCollocationsUser")
    List<User>usersRequirementCollocations;
    @ManyToOne
    AnnouncementCollocation announcementCollocationReq;
    @ManyToMany
    List<Contract>contractsReqColl;


}
