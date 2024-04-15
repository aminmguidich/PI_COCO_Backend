package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RatingCollocation;
import tn.esprit.backendpi.Service.Interfaces.IRatingCollocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Rating-Collocation")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class RatingCollocationController {
    private final IRatingCollocationService ratingCollocationService;

    @PostMapping("/addRatingCollocation")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RatingCollocation addRatingCollocation(@RequestBody RatingCollocation rating) {
        return ratingCollocationService.addRatingCollocation(rating);
    }

    @PutMapping("/updateRatingCollocation/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RatingCollocation updateRatingCollocation(@PathVariable Long id, @RequestBody RatingCollocation rating) {
        return ratingCollocationService.updateRatingCollocation(id, rating);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<RatingCollocation> getAllRatings() {
        return ratingCollocationService.getAllRatings();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RatingCollocation findRatingById(@PathVariable Long id) {
        return ratingCollocationService.findRatingById(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRating(@PathVariable("id") Long id) {
        ratingCollocationService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
