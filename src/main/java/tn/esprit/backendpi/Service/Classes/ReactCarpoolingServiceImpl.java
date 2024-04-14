package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.ReactCarpooling;
import tn.esprit.backendpi.Repository.ReactCarpoolingRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;
import tn.esprit.backendpi.Service.Interfaces.IReactCarpoolingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReactCarpoolingServiceImpl implements IReactCarpoolingService {
    private final ReactCarpoolingRepository reactCarpoolingRepository;
    private final IAnnCarpoolingService iAnnCarpoolingService;
    @Override
    public ReactCarpooling addReactCarpooling(ReactCarpooling reactCarpooling, Long announcementId) {
        AnnouncementCarpooling announcement= iAnnCarpoolingService.getByIdAnnouncementCarpooling(announcementId);

        ReactCarpooling reaction= reactCarpoolingRepository.save(reactCarpooling);
        announcement.addReact(reaction);
        iAnnCarpoolingService.updateAnnCarpooling(announcement);
        return reaction;
    }

    @Override
    public ReactCarpooling updateReactCarpooling(ReactCarpooling reactCarpooling) {
        return reactCarpoolingRepository.save(reactCarpooling);
    }

    @Override
    public void deleteReactCarpooling(Long id,Long announcementId) {
        System.out.println(announcementId);
        AnnouncementCarpooling announcement= iAnnCarpoolingService.getByIdAnnouncementCarpooling(announcementId);
        announcement.removeReact(id);
        reactCarpoolingRepository.deleteById(id);
    }

    @Override
    public List<ReactCarpooling> getAllReactCarpooling() {
        return (List<ReactCarpooling>) reactCarpoolingRepository.findAll();
    }

    @Override
    public ReactCarpooling getByIdReactCarpooling(Long id) {
        return reactCarpoolingRepository.findById(id).orElse(null);
    }
}
