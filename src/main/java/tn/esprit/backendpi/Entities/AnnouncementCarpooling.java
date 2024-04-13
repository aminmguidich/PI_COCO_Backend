package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnouncementCarpooling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarpoolingAnnouncement;
    LocalDate dateCarpoolingAnnouncement;
    String description;
    Long score;

    @OneToMany(mappedBy = "announcementCarpoolingReq")
    List<RequirementCarpooling>requirementCarpoolingsAnn;
    @ManyToOne
    Route routeAnnCarpooling;
    @ManyToMany
    List<RatingCarpooling>ratingCarpoolingsAnnCarpooling;
    @ManyToOne
    User userAnnCarpooling;




}
