package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CarpoolingAnnouncement")
public class AnnCarpoolingController {
    private final IAnnCarpoolingService iAnnCarpoolingService;
    @PostMapping("/addAnnCarpooling")
    public AnnouncementCarpooling addAnnCarpooling(@RequestBody AnnouncementCarpooling announcementCarpooling) {
        return iAnnCarpoolingService.addAnnCarpooling(announcementCarpooling);
    }
    @PutMapping("/updateAnnCarpooling")
    public AnnouncementCarpooling updateAnnCarpooling(@RequestBody AnnouncementCarpooling announcementCarpooling) {
        return iAnnCarpoolingService.updateAnnCarpooling(announcementCarpooling);
    }
    @DeleteMapping("/deleteAnnCarpooling/{id}")
    public void deleteAnnCarpooling(@PathVariable Long id) {
        iAnnCarpoolingService.deleteAnnCarpooling(id);
    }

    @GetMapping("/getAllAnnouncementCarpooling")
    public List<AnnouncementCarpooling> getAllAnnouncementCarpooling() {
        return iAnnCarpoolingService.getAllAnnouncementCarpooling();
    }

    @GetMapping("/getByIdAnnouncementCarpooling/{id}")
    public AnnouncementCarpooling getByIdAnnouncementCarpooling(@PathVariable Long id) {
        return iAnnCarpoolingService.getByIdAnnouncementCarpooling(id);
    }
}
