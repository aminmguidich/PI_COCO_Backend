package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CarpoolingAnnouncement")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class AnnCarpoolingController {
    private final IAnnCarpoolingService iAnnCarpoolingService;


    @PostMapping("/addAnnCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public AnnouncementCarpooling addAnnCarpooling(@RequestBody AnnouncementCarpooling announcementCarpooling) {
        return iAnnCarpoolingService.addAnnCarpooling(announcementCarpooling);
    }
    @PutMapping("/updateAnnCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public AnnouncementCarpooling updateAnnCarpooling(@RequestBody AnnouncementCarpooling announcementCarpooling) {
        return iAnnCarpoolingService.updateAnnCarpooling(announcementCarpooling);
    }
    @DeleteMapping("/deleteAnnCarpooling/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public void deleteAnnCarpooling(@PathVariable Long id) {
        iAnnCarpoolingService.deleteAnnCarpooling(id);
    }

    @GetMapping("/getAllAnnouncementCarpoolingPlaces")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public List<AnnouncementCarpooling> getAllAnnouncementCarpoolingPlaces() {
        return iAnnCarpoolingService.getAllAnnouncementCarpoolingPlaces();
    }
    @GetMapping("/getAllAnnouncementCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public List<AnnouncementCarpooling> getAllAnnouncementCarpooling() {
        return iAnnCarpoolingService.getAllAnnouncementCarpooling();
    }

    @GetMapping("/getByIdAnnouncementCarpooling/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public AnnouncementCarpooling getByIdAnnouncementCarpooling(@PathVariable Long id) {
        return iAnnCarpoolingService.getByIdAnnouncementCarpooling(id);
    }
}
