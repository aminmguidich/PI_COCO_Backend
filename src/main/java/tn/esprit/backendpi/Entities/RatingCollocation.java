package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    Long idCollocationRating;
    Long nbrStars;
    String comment;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "ratingCollocationsAnnCollocation")
    List<AnnouncementCollocation>announcementCollocationsRating=new ArrayList<>();
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    User userRatingCollocation;


}
