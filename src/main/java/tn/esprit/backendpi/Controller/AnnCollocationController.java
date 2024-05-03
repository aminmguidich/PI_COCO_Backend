package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Adress;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;
import tn.esprit.backendpi.Service.Interfaces.IAnnCollocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Collocation_Announcement")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class AnnCollocationController {
    private final IAnnCollocationService annCollocationService;

    @PostMapping("/addAnnouncementCollocation")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public AnnouncementCollocation addAnnouncementCollocation(@RequestBody AnnouncementCollocation announcement) {
        return annCollocationService.addAnnouncementCollocation(announcement);
    }

    @PutMapping("/updateAnnouncementCollocation/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public AnnouncementCollocation updateAnnouncementCollocation(@PathVariable Long id, @RequestBody AnnouncementCollocation newAnnouncement) {
        System.out.println(newAnnouncement.getLikes()+"-"+newAnnouncement.getDislikes());
        return annCollocationService.updateAnnouncementCollocation(id, newAnnouncement);
    }

    @GetMapping("/allAnnouncements")
    public List<AnnouncementCollocation> retrieveAllAnnouncements() {
        return annCollocationService.retrieveAllAnnouncements();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public AnnouncementCollocation getAnnouncementCollocationById(@PathVariable Long id) {
        return annCollocationService.getAnnouncementCollocationById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        annCollocationService.removeAnnouncementCollocation(id);
        return ResponseEntity.noContent().build();
    }

    /* @PostMapping("/{announcementId}/assign-address")

     public void assignAdressToAnnouncementCollocation(Long announcementCollocationId, Adress adress) {
         annCollocationService.assignAdressToAnnouncementCollocation(announcementCollocationId, adress);
     }*/
    @PostMapping("/{announcementId}/assign-house/{houseId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public void assignHouseToAnnouncementCollocation(Long announcementCollocationId, Long houseId) {
        annCollocationService.assignHouseToAnnouncementCollocation(announcementCollocationId, houseId);
    }

    @GetMapping("/filter")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<AnnouncementCollocation>> filterAnnouncements(
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "score", required = false) Integer score,
            @RequestParam(name = "maxBudget", required = false) Float BudgetPart) {
        // Implémentez votre logique de filtrage en utilisant les paramètres fournis

        List<AnnouncementCollocation> filteredAnnouncements = annCollocationService.filterAnnouncements(description, score, BudgetPart);

        return ResponseEntity.ok(filteredAnnouncements);
    }
    @PutMapping("/updateAnnoucementColRating/{idCollocationAnnouncement}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void updateAnnoucementColRating(@PathVariable("idCollocationAnnouncement") Long idCollocationAnnouncement,@RequestBody AnnouncementCollocation newann) {
        annCollocationService.updateAnnouncementCollocation(idCollocationAnnouncement, newann);
    }
}
