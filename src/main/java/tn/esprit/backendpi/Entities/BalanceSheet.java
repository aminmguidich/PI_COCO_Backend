package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BalanceSheet implements Serializable {
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
