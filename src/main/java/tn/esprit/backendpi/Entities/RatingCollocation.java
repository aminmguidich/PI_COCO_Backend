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
public class RatingCollocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarpoolingRating;
    Long nbrStars;

    @ManyToMany(mappedBy = "ratingCollocationsAnnCollocation")
    List<AnnouncementCollocation>announcementCollocationsRating;
    @ManyToOne
    User userRatingCollocation;
}
