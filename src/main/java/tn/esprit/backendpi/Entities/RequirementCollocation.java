package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    LocalDate startDate;
    Boolean status;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "requirementCollocationsUser")
    List<User>usersRequirementCollocations=new ArrayList<>();
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    AnnouncementCollocation announcementCollocationReq;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany
    List<Contract>contractsReqColl=new ArrayList<>();


}
