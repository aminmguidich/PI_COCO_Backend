package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.ReactCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IReactCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CarpoolingReact")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class ReactCarpoolingController {
    private final IReactCarpoolingService iReactCarpoolingService;

    @PostMapping("/addReactCarpooling/{announcementId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public ReactCarpooling addReactCarpooling(@RequestBody ReactCarpooling reactCarpooling,@PathVariable Long announcementId) {

        return iReactCarpoolingService.addReactCarpooling(reactCarpooling,announcementId);
    }
    @PutMapping("/updateReactCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public ReactCarpooling updateReactCarpooling(@RequestBody ReactCarpooling reactCarpooling) {
        return iReactCarpoolingService.updateReactCarpooling(reactCarpooling);
    }

    @DeleteMapping("/deleteReactCarpooling/{id}&{announcementId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public void deleteReactCarpooling(@PathVariable Long id,@PathVariable Long announcementId) {
        System.out.println(id);
        iReactCarpoolingService.deleteReactCarpooling(id,announcementId);
    }

    @GetMapping("/getAllReactCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")


    public List<ReactCarpooling> getAllReactCarpooling() {
        return iReactCarpoolingService.getAllReactCarpooling();
    }

    @GetMapping("/getByIdReactCarpooling/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")


    public ReactCarpooling getByIdReactCarpooling(@PathVariable Long id) {
        return iReactCarpoolingService.getByIdReactCarpooling(id);
    }
}
