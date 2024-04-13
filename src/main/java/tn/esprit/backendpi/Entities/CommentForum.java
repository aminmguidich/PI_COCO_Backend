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
public class CommentForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommentForum;
    String description;

    @ManyToOne
    User userCommentForum;
    @OneToMany
    List<ReactForum> reactForumsComment;
    @ManyToOne
    Forum forumComment;
}
