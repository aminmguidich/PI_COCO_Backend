package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Repository.AnnCarpoolingRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnCarpoolingServiceImpl implements IAnnCarpoolingService {
    private final AnnCarpoolingRepository annCarpoolingRepository;

    @Override
    public AnnouncementCarpooling addAnnCarpooling(AnnouncementCarpooling announcementCarpooling) {
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
    public List<AnnouncementCarpooling> getAllAnnouncementCarpooling() {
        return (List<AnnouncementCarpooling>) annCarpoolingRepository.findAll();
    }

    @Override
    public AnnouncementCarpooling getByIdAnnouncementCarpooling(Long id) {
        return annCarpoolingRepository.findById(id).orElse(null);
    }
}
