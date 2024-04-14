package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.TypeReact;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String text;
    private int points;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore // Vous pouvez ignorer cette propriété lors de la sérialisation JSON si nécessaire
    private Quiz quiz; // Référence vers l'entité Quiz
}


