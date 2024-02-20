package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.RequirementCarpooling;

import java.util.List;

public interface IAnnCarpoolingService {
    AnnouncementCarpooling addAnnCarpooling(AnnouncementCarpooling announcementCarpooling);
    AnnouncementCarpooling updateAnnCarpooling(AnnouncementCarpooling announcementCarpooling);
    void deleteAnnCarpooling(Long id );
    List<AnnouncementCarpooling>getAllAnnouncementCarpooling();
    AnnouncementCarpooling getByIdAnnouncementCarpooling(Long id);
}
