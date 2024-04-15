package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.TypeReact;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommentPost;
    String commentBody;
    LocalDate commentedAt;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    User userCommentPost;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany
    List<ReactPost> reactPostsComment=new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postCoReflexive")
    Set<CommentPost> postCommentsReflexive = new HashSet<>(); //Reflexive association : A comment can have multiple replies

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    CommentPost postCoReflexive;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Post postComment;
}


