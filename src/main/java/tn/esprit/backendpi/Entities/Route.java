package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "routeAnnCarpooling")
    List<AnnouncementCarpooling>announcementCarpoolingsRoute=new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "routeBalanceSheet")
    List<BalanceSheet>balanceSheetsRoute=new ArrayList<>();

    //@JsonIgnore
    @ToString.Exclude
    @ManyToMany
    List<Adress>adressesRoute=new ArrayList<>();



}
