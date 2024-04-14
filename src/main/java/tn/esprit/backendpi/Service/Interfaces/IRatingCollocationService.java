package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.RatingCollocation;

import java.util.List;

public interface IRatingCollocationService {
    RatingCollocation addRatingCollocation(RatingCollocation rating);

    RatingCollocation updateRatingCollocation(Long id, RatingCollocation rating);

    List<RatingCollocation> getAllRatings();

    RatingCollocation findRatingById(Long id);

    void deleteRating(Long id);
}
