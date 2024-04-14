package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.TypeRole;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRole;
    @Enumerated(EnumType.STRING)
    TypeRole typeRole;
    @ToString.Exclude
    @ManyToMany(mappedBy = "rolesUser")
    List<User>usersRoles=new ArrayList<>();


}
