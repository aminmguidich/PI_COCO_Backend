package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;
import tn.esprit.backendpi.Repository.AnnCollocationRepository;
import tn.esprit.backendpi.Repository.AnnCollocationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PieChartService {

    private final AnnCollocationRepository announcementCollocationRepository;

    @Autowired
    public PieChartService(AnnCollocationRepository announcementCollocationRepository) {
        this.announcementCollocationRepository = announcementCollocationRepository;
    }

    public Map<String, Integer> getBudgetPieChartData() {
        List<AnnouncementCollocation> announcements = announcementCollocationRepository.findAll();

        Map<String, Integer> dataForPieChart = new HashMap<>();
        int budgetUnder300 = 0;
        int budgetOver300 = 0;
        for (AnnouncementCollocation announcement : announcements) {
            if (announcement.getBudgetPart() < 300) {
                budgetUnder300++;
            } else {
                budgetOver300++;
            }
        }
        dataForPieChart.put("Budget < 300", budgetUnder300);
        dataForPieChart.put("Budget >= 300", budgetOver300);

        return dataForPieChart;
    }
}
