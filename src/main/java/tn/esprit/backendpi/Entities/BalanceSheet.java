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
public class BalanceSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBalanceSheet;
    String description;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Car carBalanceSheet;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Route routeBalanceSheet;




}
