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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idComment;
    String description;

    @ManyToOne
    User userComment;
    @OneToMany
    List<React>reactsComments;
    @ManyToOne
    AnnouncementCollocation announcementCollocationComment;


}
