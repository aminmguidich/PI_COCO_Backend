package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRoute;
    Float distance;
    @JsonIgnore
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "routeAnnCarpooling")
    List<AnnouncementCarpooling>announcementCarpoolingsRoute=new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "routeBalanceSheet")
    List<BalanceSheet>balanceSheetsRoute=new ArrayList<>();

    @ManyToMany
    List<Adress>adressesRoute=new ArrayList<>();

}
