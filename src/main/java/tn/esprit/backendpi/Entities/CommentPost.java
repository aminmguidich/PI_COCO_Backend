package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CommentPost implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommentForum;
    String description;

    @ToString.Exclude
    @ManyToOne
    User userCommentPost;

    @ToString.Exclude
    @OneToMany
    List<ReactPost> reactPostsComment=new ArrayList<>();

    @ToString.Exclude
    @ManyToOne
    Post postComment;
}
