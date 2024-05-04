package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    int budgetPart=33;
    int score;
    int nb_etoil=0;
    int Likes=0;
    int Dislikes=0;
    String username;
    Long userId;
    String title;
    String imageUrl;
    @OneToOne( optional = true, cascade = CascadeType.ALL)
    private FileDB image;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne
    Adress adressAnnoCollocation;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "announcementCollocationReq")
    List<RequirementCollocation>requirementCollocationsAnno;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    User userAnnCollocation;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany
    List<RatingCollocation>ratingCollocationsAnnCollocation=new ArrayList<>();

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    House houseAnnoCollocation;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany
    List<ReactCollocation>reactCollocationsAnnCollocation=new ArrayList<>();



}
