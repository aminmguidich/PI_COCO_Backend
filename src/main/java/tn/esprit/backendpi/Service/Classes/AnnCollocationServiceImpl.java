package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.Adress;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;
import tn.esprit.backendpi.Entities.House;
import tn.esprit.backendpi.Repository.AnnCollocationRepository;
import tn.esprit.backendpi.Repository.HouseRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCollocationService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnCollocationServiceImpl implements IAnnCollocationService {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private AnnCollocationRepository annCollocationRepository;

    @Override
    public AnnouncementCollocation addAnnouncementCollocation(AnnouncementCollocation announcement) {
        return annCollocationRepository.save(announcement);
    }

    @Override
    public AnnouncementCollocation updateAnnouncementCollocation(Long id, AnnouncementCollocation newAnnouncement) {
        AnnouncementCollocation oldAnnouncement = annCollocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Collocation announcement not found with ID : " + id));

        // Update fields of the old announcement with values from the new announcement
        oldAnnouncement.setDateCollocationAnnouncement(newAnnouncement.getDateCollocationAnnouncement());
        oldAnnouncement.setDescription(newAnnouncement.getDescription());
        oldAnnouncement.setBudgetPart(newAnnouncement.getBudgetPart());
        oldAnnouncement.setScore(newAnnouncement.getScore());

        // Save the changes to the database and return the updated announcement
        return annCollocationRepository.save(oldAnnouncement);
    }

    @Override
    public List<AnnouncementCollocation> retrieveAllAnnouncements() {
        return (List<AnnouncementCollocation>) annCollocationRepository.findAll();
    }

    @Override
    public AnnouncementCollocation getAnnouncementCollocationById(Long id) {
        return annCollocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Collocation announcement not found with ID : " + id));
    }

    @Override
    public void removeAnnouncementCollocation(Long id) {
        annCollocationRepository.deleteById(id);
    }

    @Override
    public void assignHouseToAnnouncementCollocation(Long announcementCollocationId, Long houseId) {
        AnnouncementCollocation announcementCollocation = annCollocationRepository.findById(announcementCollocationId)
                .orElseThrow(() -> new RuntimeException("AnnouncementCollocation not found with id " + announcementCollocationId));

        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new RuntimeException("House not found with id " + houseId));

        announcementCollocation.setHouseAnnoCollocation(house);

        annCollocationRepository.save(announcementCollocation);
    }

    @Override
    public List<AnnouncementCollocation> filterByBudgetPart(Float minBudget, Float maxBudget) {
        return annCollocationRepository.findByBudgetPartBetween(minBudget, maxBudget);
    }


}

