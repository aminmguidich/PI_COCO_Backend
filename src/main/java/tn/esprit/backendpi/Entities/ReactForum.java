package tn.esprit.backendpi.Entities;

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
    Long idReactForum;
    TypeReactForum typeReactForum;

    @ManyToOne
    User userReactForum;

}
