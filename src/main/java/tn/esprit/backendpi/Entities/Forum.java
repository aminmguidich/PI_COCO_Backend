package tn.esprit.backendpi.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idForum;
    String description;

    @OneToMany(mappedBy = "forumComment")
    List<CommentForum>commentForums;
    @ManyToOne
    User userForum;
    @OneToMany
    List<ReactForum>reactForums;


}
