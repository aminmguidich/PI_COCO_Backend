package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Post;
import tn.esprit.backendpi.Entities.TypeReact;
import tn.esprit.backendpi.Entities.User;

import java.io.Serializable;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReactPost implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReactPost;
    @Enumerated(EnumType.STRING)
    TypeReactPost typeReact;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    User userReactPost;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Post post;



}
