package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.User;

import java.util.List;

public interface IAnnCarpoolingService {
    AnnouncementCarpooling addAnnCarpooling(AnnouncementCarpooling announcementCarpooling);
    AnnouncementCarpooling updateAnnCarpooling(AnnouncementCarpooling announcementCarpooling);
    void deleteAnnCarpooling(Long id );
    List<AnnouncementCarpooling> getAllAnnouncementCarpoolingPlaces();
    List<AnnouncementCarpooling>getAllAnnouncementCarpooling();
    AnnouncementCarpooling getByIdAnnouncementCarpooling(Long id);
    List<User>getAllUsers();
    AnnouncementCarpooling addAnnCarpoolingAdmin(AnnouncementCarpooling announcementCarpooling);
}
