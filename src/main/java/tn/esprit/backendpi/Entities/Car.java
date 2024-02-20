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
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCar;
    String registrationNumber;
    String image;
    Boolean smoking;
    Boolean airConditioned;
    Long places;
    String model;


    @ToString.Exclude
    @OneToOne(mappedBy = "carUser")
    User userCar;

    @ToString.Exclude
    @OneToMany(mappedBy = "carBalanceSheet")
    List<BalanceSheet>balanceSheetsCar=new ArrayList<>();



}
