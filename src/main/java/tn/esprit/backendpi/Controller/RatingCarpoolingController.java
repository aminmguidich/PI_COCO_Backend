package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IRatingCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CarpoolingRating")
@CrossOrigin("*")

public class RatingCarpoolingController {
    private final IRatingCarpoolingService iRatingCarpoolingService;

    @PostMapping("/addRatingCarpooling")
    public RatingCarpooling addRatingCarpooling(@RequestBody RatingCarpooling ratingCarpooling) {
        return iRatingCarpoolingService.addRatingCarpooling(ratingCarpooling);
    }
    @PutMapping("/updateRatingCarpooling")
    public RatingCarpooling updateRatingCarpooling(@RequestBody RatingCarpooling ratingCarpooling) {
        return iRatingCarpoolingService.updateRatingCarpooling(ratingCarpooling);
    }

    @DeleteMapping("/deleteRatingCarpooling/{id}")
    public void deleteReqCarpooling(@PathVariable Long id) {
        iRatingCarpoolingService.deleteReqCarpooling(id);
    }

    @GetMapping("/getAllRatingCarpooling")
    public List<RatingCarpooling> getAllRatingCarpooling() {
        return iRatingCarpoolingService.getAllRatingCarpooling();
    }

    @GetMapping("/getByIdRatingCarpooling/{id}")
    public RatingCarpooling getByIdRatingCarpooling(@PathVariable Long id) {
        return iRatingCarpoolingService.getByIdRatingCarpooling(id);
    }
}
