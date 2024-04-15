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
        return null;
    }

    @Override
    public List<AnnouncementCollocation> filterAnnouncements(String description, Integer score, Float budgetPart) {
        List<AnnouncementCollocation> allAnnouncements = annCollocationRepository.findAll();

        // Liste pour stocker les annonces filtrées
        List<AnnouncementCollocation> filteredAnnouncements = new ArrayList<>();

        // Parcourez toutes les annonces et appliquez les filtres
        for (AnnouncementCollocation announcement : allAnnouncements) {
            // Vérifiez si l'annonce correspond au critère de description
            if (description != null && !announcement.getDescription().contains(description)) {
                continue; // Passez à l'annonce suivante si la description ne correspond pas
            }

            // Vérifiez si l'annonce correspond au critère de score
            if (score != null && !announcement.getScore().equals(score)) {
                continue; // Passez à l'annonce suivante si le score ne correspond pas
            }

            // Vérifiez si l'annonce correspond au critère de budgetPart
            if (budgetPart != null && !Float.valueOf(announcement.getBudgetPart()).equals(budgetPart)) {
                continue; // Passez à l'annonce suivante si le budgetPart ne correspond pas
            }

            // Si l'annonce passe tous les filtres, ajoutez-la à la liste des annonces filtrées
            filteredAnnouncements.add(announcement);
        }

        return filteredAnnouncements;
    }


}

