package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Entities.RequirementCarpooling;

import java.util.List;

public interface IRatingCarpoolingService {
    RatingCarpooling addRatingCarpooling(RatingCarpooling ratingCarpooling);
    RatingCarpooling updateRatingCarpooling(RatingCarpooling ratingCarpooling);
    void deleteReqCarpooling(Long id );
    List<RatingCarpooling> getAllRatingCarpooling();
    RatingCarpooling getByIdRatingCarpooling(Long id);
}
