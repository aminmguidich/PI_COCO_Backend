package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReactForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReactPost;
    @Enumerated(EnumType.STRING)
    TypeReact typeReact;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    User userReactForum;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Post post;



}
