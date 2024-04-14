package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.ReactCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IReactCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CarpoolingReact")
@CrossOrigin("*")

public class ReactCarpoolingController {
    private final IReactCarpoolingService iReactCarpoolingService;

    @PostMapping("/addReactCarpooling/{announcementId}")
    public ReactCarpooling addReactCarpooling(@RequestBody ReactCarpooling reactCarpooling,@PathVariable Long announcementId) {
        return iReactCarpoolingService.addReactCarpooling(reactCarpooling,announcementId);
    }
    @PutMapping("/updateReactCarpooling")
    public ReactCarpooling updateReactCarpooling(@RequestBody ReactCarpooling reactCarpooling) {
        return iReactCarpoolingService.updateReactCarpooling(reactCarpooling);
    }

    @DeleteMapping("/deleteReactCarpooling/{id}&{announcementId}")
    public void deleteReactCarpooling(@PathVariable Long id,@PathVariable Long announcementId) {
        iReactCarpoolingService.deleteReactCarpooling(id,announcementId);
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
