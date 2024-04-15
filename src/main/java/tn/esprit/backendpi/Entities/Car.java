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
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCar;
    String registrationNumber;
    String image;
    Boolean smoking;
    Boolean airConditioned;
    Long places;
    String model;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(mappedBy = "carUser")
    User userCar;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "carBalanceSheet")
    List<BalanceSheet>balanceSheetsCar;



}
