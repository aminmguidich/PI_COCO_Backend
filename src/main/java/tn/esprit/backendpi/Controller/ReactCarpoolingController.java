package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.ReactCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IReactCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CarpoolingRating")
public class ReactCarpoolingController {
    private final IReactCarpoolingService iReactCarpoolingService;

    @PostMapping("/addReactCarpooling")
    public ReactCarpooling addReactCarpooling(@RequestBody ReactCarpooling reactCarpooling) {
        return iReactCarpoolingService.addReactCarpooling(reactCarpooling);
    }
    @PutMapping("/updateReactCarpooling")
    public ReactCarpooling updateReactCarpooling(@RequestBody ReactCarpooling reactCarpooling) {
        return iReactCarpoolingService.updateReactCarpooling(reactCarpooling);
    }

    @DeleteMapping("/deleteReactCarpooling/{id}")
    public void deleteReactCarpooling(@PathVariable Long id) {
        iReactCarpoolingService.deleteReactCarpooling(id);
    }

    @GetMapping("/getAllReactCarpooling")

    public List<ReactCarpooling> getAllReactCarpooling() {
        return iReactCarpoolingService.getAllReactCarpooling();
    }

    @GetMapping("/getByIdReactCarpooling/{id}")

    public ReactCarpooling getByIdReactCarpooling(@PathVariable Long id) {
        return iReactCarpoolingService.getByIdReactCarpooling(id);
    }
}
