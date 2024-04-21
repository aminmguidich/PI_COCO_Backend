package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.AnnCarpoolingRepository;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnCarpoolingServiceImpl implements IAnnCarpoolingService {
    private final AnnCarpoolingRepository annCarpoolingRepository;
    private final UserRepository userRepository;

    @Override
    public AnnouncementCarpooling addAnnCarpooling(AnnouncementCarpooling announcementCarpooling) {
        User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        announcementCarpooling.setUserAnnCarpooling(loggedInUser);
        return annCarpoolingRepository.save(announcementCarpooling);
    }

    @Override
    public AnnouncementCarpooling updateAnnCarpooling(AnnouncementCarpooling announcementCarpooling) {

        return annCarpoolingRepository.save(announcementCarpooling);
    }

    @Override
    public void deleteAnnCarpooling(Long id) {
        annCarpoolingRepository.deleteById(id);


    }

    @Override
    public List<AnnouncementCarpooling> getAllAnnouncementCarpoolingPlaces() {
        List<AnnouncementCarpooling> allAnnouncements = (List<AnnouncementCarpooling>) annCarpoolingRepository.findAll();

        // Filter announcements with places greater than 0
        return allAnnouncements.stream()
                .filter(announcement -> announcement.getPlaces() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnnouncementCarpooling> getAllAnnouncementCarpooling() {
        return (List<AnnouncementCarpooling>) annCarpoolingRepository.findAll();
    }

    @Override
    public AnnouncementCarpooling getByIdAnnouncementCarpooling(Long id) {
        return annCarpoolingRepository.findById(id).orElse(null);
    }
}
