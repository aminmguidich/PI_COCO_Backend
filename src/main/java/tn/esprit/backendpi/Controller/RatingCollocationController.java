package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RatingCollocation;
import tn.esprit.backendpi.Service.Interfaces.IRatingCollocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Rating-Collocation")
@CrossOrigin("*")
public class RatingCollocationController {
    private final IRatingCollocationService ratingCollocationService;

    @PostMapping("/addRatingCollocation")
    public RatingCollocation addRatingCollocation(@RequestBody RatingCollocation rating) {
        return ratingCollocationService.addRatingCollocation(rating);
    }

    @PutMapping("/updateRatingCollocation/{id}")
    public RatingCollocation updateRatingCollocation(@PathVariable Long id, @RequestBody RatingCollocation rating) {
        return ratingCollocationService.updateRatingCollocation(id, rating);
    }

    @GetMapping("/all")
    public List<RatingCollocation> getAllRatings() {
        return ratingCollocationService.getAllRatings();
    }

    @GetMapping("/{id}")
    public RatingCollocation findRatingById(@PathVariable Long id) {
        return ratingCollocationService.findRatingById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable("id") Long id) {
        ratingCollocationService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
