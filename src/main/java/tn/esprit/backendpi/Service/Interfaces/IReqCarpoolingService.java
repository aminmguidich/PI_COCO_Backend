package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Entities.RequirementCarpooling;

import java.util.List;

public interface IReqCarpoolingService {
    RequirementCarpooling addReqCarpooling(RequirementCarpooling requirementCarpooling);
    RequirementCarpooling updateReqCarpooling(RequirementCarpooling requirementCarpooling);
    void deleteReqCarpooling(Long id );
    List<RequirementCarpooling> getAllReqCarpooling();
    RequirementCarpooling getByIdReqCarpooling(Long id);


}
