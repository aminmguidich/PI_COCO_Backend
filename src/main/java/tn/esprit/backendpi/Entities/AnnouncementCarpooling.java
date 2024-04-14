package tn.esprit.backendpi.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class AnnouncementCarpooling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCarpoolingAnnouncement;
    LocalDate dateCarpoolingAnnouncement;
    String description;
    Long score;
    Float ridePrice;
    Long  places;


    @OneToMany(mappedBy = "announcementCarpoolingReq")
    @JsonIgnore
    List<RequirementCarpooling>requirementCarpoolingsAnn=new ArrayList<>();

    @ToString.Exclude
    @ManyToOne
    Route routeAnnCarpooling;
    @ManyToMany
    List<RatingCarpooling>ratingCarpoolingsAnnCarpooling=new ArrayList<>();

    @ManyToOne
    User userAnnCarpooling;

    @ToString.Exclude
    @OneToMany
    List<ReactCarpooling>reactCarpoolingsAnnCarpooling=new ArrayList<>();
    public void removeReact(Long reactCarpoolingId){
        int indexToRemove=-1;
        for (int i = 0; i < reactCarpoolingsAnnCarpooling.size(); i++) {
            if(reactCarpoolingsAnnCarpooling.get(i).getIdReactCarpooling()==reactCarpoolingId){
                indexToRemove=i;
            }
        }
        if(indexToRemove>=0){
            reactCarpoolingsAnnCarpooling.remove(indexToRemove);
        }else{
            System.out.println("Cannot find React with id: "+reactCarpoolingId);
        }

    }
    public void addReact(ReactCarpooling reactCarpooling){
        reactCarpoolingsAnnCarpooling.add(reactCarpooling);
    }
}
