package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.Enum.GenderType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
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
    @Enumerated(EnumType.STRING)
    GenderType gender;
    Long score;



    @ManyToMany
    List<Role>rolesUser=new ArrayList<>();
    @ToString.Exclude
    @ManyToMany
    List<RequirementCollocation>requirementCollocationsUser=new ArrayList<>();
    @ToString.Exclude


    @OneToOne
    Adress adressUser;
    @ToString.Exclude
    @OneToMany(mappedBy = "userReact")
    List<ReactCollocation>reactsUser=new ArrayList<>();





}
