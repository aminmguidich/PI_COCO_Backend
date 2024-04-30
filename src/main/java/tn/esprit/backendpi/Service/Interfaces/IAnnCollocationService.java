package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Adress;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;

import java.util.List;

public interface IAnnCollocationService {
    public AnnouncementCollocation addAnnouncementCollocation(AnnouncementCollocation announcement);
    public AnnouncementCollocation updateAnnouncementCollocation(Long id, AnnouncementCollocation newAnnouncement);
    List<AnnouncementCollocation> retrieveAllAnnouncements();

    AnnouncementCollocation getAnnouncementCollocationById(Long id);
    void removeAnnouncementCollocation(Long id);
    /* void assignAdressToAnnouncementCollocation(Long announcementCollocationId, Adress adress);*/
    public void assignHouseToAnnouncementCollocation(Long announcementCollocationId, Long houseId);
    List<AnnouncementCollocation> filterByBudgetPart(Float minBudget, Float maxBudget);
    public List<AnnouncementCollocation> filterAnnouncements(String description, Integer score, Float budgetPart);
    void updateAnnoucementColRating(Long idCollocationAnnouncement, int nb_etoil);
}
