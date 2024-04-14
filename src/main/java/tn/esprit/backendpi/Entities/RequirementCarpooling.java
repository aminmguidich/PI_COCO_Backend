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
public class RequirementCarpooling implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarRequirement;
    String description;
    LocalDate dateCarpoolingRequirement;
    @ManyToOne
    User usersRequirementCarpooling;
    @ManyToOne
    AnnouncementCarpooling announcementCarpoolingReq;



}
