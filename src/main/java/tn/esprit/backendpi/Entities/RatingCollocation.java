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
public class RatingCollocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCollocationRating;
    Long nbrStars;
    String comment;
    @ToString.Exclude
    @ManyToMany(mappedBy = "ratingCollocationsAnnCollocation")
    List<AnnouncementCollocation>announcementCollocationsRating=new ArrayList<>();
    @ToString.Exclude
    @ManyToOne
    User userRatingCollocation;
}
