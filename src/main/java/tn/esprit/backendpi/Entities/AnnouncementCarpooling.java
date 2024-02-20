package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnouncementCarpooling implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarpoolingAnnouncement;
    LocalDate dateCarpoolingAnnouncement;
    String description;
    Long score;

    @ToString.Exclude
    @OneToMany(mappedBy = "announcementCarpoolingReq")
    List<RequirementCarpooling>requirementCarpoolingsAnn=new ArrayList<>();

    @ToString.Exclude
    @ManyToOne
    Route routeAnnCarpooling;

    @ToString.Exclude
    @ManyToMany
    List<RatingCarpooling>ratingCarpoolingsAnnCarpooling=new ArrayList<>();

    @ToString.Exclude
    @ManyToOne
    User userAnnCarpooling;

    @ToString.Exclude
    @OneToMany
    List<ReactCarpooling>reactCarpoolingsAnnCarpooling=new ArrayList<>();




}
