package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.TypeReact;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ReactCollocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReact;
    @Enumerated(EnumType.STRING)
    TypeReact typeReact;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    User userReact;



}
