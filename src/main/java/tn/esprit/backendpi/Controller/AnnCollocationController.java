package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Adress;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;
import tn.esprit.backendpi.Service.Interfaces.IAnnCollocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Collocation_Announcement")
@CrossOrigin("*")
public class AnnCollocationController {
    private final IAnnCollocationService annCollocationService;

    @PostMapping("/addAnnouncementCollocation")
    public AnnouncementCollocation addAnnouncementCollocation(@RequestBody AnnouncementCollocation announcement) {
        return annCollocationService.addAnnouncementCollocation(announcement);
    }

    @PutMapping("/updateAnnouncementCollocation/{id}")
    public AnnouncementCollocation updateAnnouncementCollocation(@PathVariable Long id, @RequestBody AnnouncementCollocation newAnnouncement) {
        return annCollocationService.updateAnnouncementCollocation(id, newAnnouncement);
    }

    @GetMapping("/allAnnouncements")
    public List<AnnouncementCollocation> retrieveAllAnnouncements() {
        return annCollocationService.retrieveAllAnnouncements();
    }

    @GetMapping("/{id}")
    public AnnouncementCollocation getAnnouncementCollocationById(@PathVariable Long id) {
        return annCollocationService.getAnnouncementCollocationById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        annCollocationService.removeAnnouncementCollocation(id);
        return ResponseEntity.noContent().build();
    }

    /* @PostMapping("/{announcementId}/assign-address")

     public void assignAdressToAnnouncementCollocation(Long announcementCollocationId, Adress adress) {
         annCollocationService.assignAdressToAnnouncementCollocation(announcementCollocationId, adress);
     }*/
    @PostMapping("/{announcementId}/assign-house/{houseId}")

    public void assignHouseToAnnouncementCollocation(Long announcementCollocationId, Long houseId) {
        annCollocationService.assignHouseToAnnouncementCollocation(announcementCollocationId, houseId);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<AnnouncementCollocation>> filterAnnouncements(
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "score", required = false) Integer score,
            @RequestParam(name = "maxBudget", required = false) Float BudgetPart) {
        // Implémentez votre logique de filtrage en utilisant les paramètres fournis

        List<AnnouncementCollocation> filteredAnnouncements = annCollocationService.filterAnnouncements(description, score, BudgetPart);

        return ResponseEntity.ok(filteredAnnouncements);
    }


}

