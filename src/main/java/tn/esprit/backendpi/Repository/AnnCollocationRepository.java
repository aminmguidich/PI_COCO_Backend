package tn.esprit.backendpi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;

import java.util.List;

public interface AnnCollocationRepository extends JpaRepository<AnnouncementCollocation,Long> {
    List<AnnouncementCollocation> findByBudgetPartBetween(Float minBudget, Float maxBudget);

}