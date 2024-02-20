package tn.esprit.backendpi.Entities;
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
public class RatingCarpooling implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarpoolingRating;
    Long nbrStars;
    String comment;
    @ToString.Exclude
    @ManyToMany(mappedBy = "ratingCarpoolingsAnnCarpooling")
    List<AnnouncementCarpooling>announcementCarpoolingsRating=new ArrayList<>();
    @ToString.Exclude
    @ManyToOne
    User userRatingCarpooling;




}
