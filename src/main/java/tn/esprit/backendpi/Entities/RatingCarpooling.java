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
public class RatingCarpooling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarpoolingRating;
    Long nbrStars;

    @ManyToMany(mappedBy = "ratingCarpoolingsAnnCarpooling")
    List<AnnouncementCarpooling>announcementCarpoolingsRating;
    @ManyToOne
    User userRatingCarpooling;




}
