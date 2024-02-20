package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.GenderType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastname;
    String password;
    String email;
    Long phone;
    String image;
    LocalDate birthDate;
    Boolean availibilty;
    @Enumerated(EnumType.STRING)
    GenderType gender;
    Long score;
    @ToString.Exclude
    @ManyToMany
    List<RequirementCarpooling>requirementCarpoolingsUser=new ArrayList<>();
    @ToString.Exclude
    @ManyToMany
    List<Claims>claimsUser=new ArrayList<>();
    @ToString.Exclude
    @ManyToMany
    List<Role>rolesUser=new ArrayList<>();
    @ToString.Exclude
    @ManyToMany
    List<RequirementCollocation>requirementCollocationsUser=new ArrayList<>();
    @ToString.Exclude
    @OneToOne
    Car carUser;
    @ToString.Exclude
    @OneToOne
    Calendar calendarUser;
    @ToString.Exclude
    @OneToOne
    Adress adressUser;
    @ToString.Exclude
    @OneToMany(mappedBy = "userReact")
    List<ReactCollocation>reactsUser=new ArrayList<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "userCommand")
    List<Command>commandsUser=new ArrayList<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "userReactPost")
    List<ReactPost>reactPostuser=new ArrayList<>();



}
