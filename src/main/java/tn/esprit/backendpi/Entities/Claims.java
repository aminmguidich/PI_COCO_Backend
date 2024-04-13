package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Claims {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClaim;
    LocalDate dateClaim;
    String description;

    @ManyToMany(mappedBy = "claimsUser")
    List<User>usersClaims;


}
