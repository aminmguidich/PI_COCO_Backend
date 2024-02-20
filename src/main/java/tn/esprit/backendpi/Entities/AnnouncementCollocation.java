package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class AnnouncementCollocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCollocationAnnouncement;
    LocalDate dateCollocationAnnouncement;
    String description;
    Float budgetPart;
    Long score;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne
    Adress adressAnnoCollocation;

    @ToString.Exclude
    @OneToMany(mappedBy = "announcementCollocationReq")
    List<RequirementCollocation>requirementCollocationsAnno;

    @ToString.Exclude
    @ManyToOne
    User userAnnCollocation;

    @ToString.Exclude
    @ManyToMany
    List<RatingCollocation>ratingCollocationsAnnCollocation=new ArrayList<>();

    @ToString.Exclude
    @ManyToOne
    House houseAnnoCollocation;

    @ToString.Exclude
    @OneToMany
    List<ReactCollocation>reactCollocationsAnnCollocation=new ArrayList<>();



}
