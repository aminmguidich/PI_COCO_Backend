package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.RatingCollocation;
import tn.esprit.backendpi.Repository.RatingCollocationRepository;
import tn.esprit.backendpi.Service.Interfaces.IRatingCollocationService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingCollocationServiceImpl implements IRatingCollocationService {
    private final RatingCollocationRepository ratingCollocationRepository;

    @Override
    public RatingCollocation addRatingCollocation(RatingCollocation rating) {
        return ratingCollocationRepository.save(rating);
    }

    @Override
    public RatingCollocation updateRatingCollocation(Long id, RatingCollocation newRating){

        RatingCollocation existingRating = ratingCollocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Collocation rating not found with ID : " + id));


        existingRating.setNbrStars(newRating.getNbrStars());
        existingRating.setComment(newRating.getComment());


        // Save the modifications in the database and return the updated rating
        return ratingCollocationRepository.save(existingRating);
    }



    @Override
    public List<RatingCollocation> getAllRatings() {
        return (List<RatingCollocation>) ratingCollocationRepository.findAll();
    }

    @Override
    public RatingCollocation findRatingById(Long id) {
        return ratingCollocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Collocation rating not found with ID : " + id));
    }

    @Override
    public void deleteRating(Long id) {
        ratingCollocationRepository.deleteById(id);
    }




}
