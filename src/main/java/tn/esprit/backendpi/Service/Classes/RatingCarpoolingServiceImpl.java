package tn.esprit.backendpi.Service.Classes;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Repository.RatingCarpoolingRepository;
import tn.esprit.backendpi.Service.Interfaces.IRatingCarpoolingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingCarpoolingServiceImpl implements IRatingCarpoolingService {
    private final RatingCarpoolingRepository ratingCarpoolingRepository;

    @Override
    public RatingCarpooling addRatingCarpooling(RatingCarpooling ratingCarpooling) {
        return ratingCarpoolingRepository.save(ratingCarpooling);
    }

    @Override
    public RatingCarpooling updateRatingCarpooling(RatingCarpooling ratingCarpooling) {
        return ratingCarpoolingRepository.save(ratingCarpooling);
    }

    @Override
    public void deleteReqCarpooling(Long id) {
        ratingCarpoolingRepository.deleteById(id);

    }

    @Override
    public List<RatingCarpooling> getAllRatingCarpooling() {
        return (List<RatingCarpooling>) ratingCarpoolingRepository.findAll();
    }

    @Override
    public RatingCarpooling getByIdRatingCarpooling(Long id) {
        return ratingCarpoolingRepository.findById(id).orElse(null);
    }
}
