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

public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReact;
    @Enumerated(EnumType.STRING)
    TypeReact typeReact;

    @ManyToOne
    User userReact;



}
