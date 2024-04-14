package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IRatingCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CarpoolingRating")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class RatingCarpoolingController {
    private final IRatingCarpoolingService iRatingCarpoolingService;

    @PostMapping("/addRatingCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public RatingCarpooling addRatingCarpooling(@RequestBody RatingCarpooling ratingCarpooling) {
        return iRatingCarpoolingService.addRatingCarpooling(ratingCarpooling);
    }
    @PutMapping("/updateRatingCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public RatingCarpooling updateRatingCarpooling(@RequestBody RatingCarpooling ratingCarpooling) {
        return iRatingCarpoolingService.updateRatingCarpooling(ratingCarpooling);
    }

    @DeleteMapping("/deleteRatingCarpooling/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public void deleteReqCarpooling(@PathVariable Long id) {
        iRatingCarpoolingService.deleteReqCarpooling(id);
    }

    @GetMapping("/getAllRatingCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public List<RatingCarpooling> getAllRatingCarpooling() {
        return iRatingCarpoolingService.getAllRatingCarpooling();
    }

    @GetMapping("/getByIdRatingCarpooling/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public RatingCarpooling getByIdRatingCarpooling(@PathVariable Long id) {
        return iRatingCarpoolingService.getByIdRatingCarpooling(id);
    }
}
