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
public class RequirementCarpooling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarRequirement;
    String description;
    LocalDate dateCarpoolingRequirement;
    Float budgetPart;

    @ManyToMany(mappedBy = "requirementCarpoolingsUser")
    List<User>usersRequirementCarpooling;
    @ManyToOne
    AnnouncementCarpooling announcementCarpoolingReq;



}
