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
public class AnnouncementCollocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCollocationAnnouncement;
    LocalDate dateCollocationAnnouncement;
    String description;
    Float budgetPart;
    Long score;

    @OneToOne
    Adress adressAnnoCollocation;
    @OneToMany(mappedBy = "announcementCollocationReq")
    List<RequirementCollocation>requirementCollocationsAnno;
    @ManyToOne
    User userAnnCollocation;
    @ManyToMany
    List<RatingCollocation>ratingCollocationsAnnCollocation;
    @ManyToOne
    House houseAnnoCollocation;



}
