package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.TypeRole;
import tn.esprit.backendpi.Entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRole;
    @Enumerated(EnumType.STRING)
    TypeRole typeRole;
    @ToString.Exclude
    @ManyToMany(mappedBy = "rolesUser")
    List<User>usersRoles=new ArrayList<>();


}
