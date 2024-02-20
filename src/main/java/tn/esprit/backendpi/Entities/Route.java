package tn.esprit.backendpi.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

public class Route implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRoute;
    Float distance;
    @ToString.Exclude
    @OneToMany(mappedBy = "routeAnnCarpooling")
    List<AnnouncementCarpooling>announcementCarpoolingsRoute=new ArrayList<>();
    @ToString.Exclude
    @OneToMany(mappedBy = "routeBalanceSheet")
    List<BalanceSheet>balanceSheetsRoute=new ArrayList<>();
    @ToString.Exclude
    @ManyToMany
    List<Adress>adressesRoute=new ArrayList<>();



}
