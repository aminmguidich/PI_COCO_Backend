package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backendpi.Entities.MarketPlace;

public interface MarketPlaceRepository extends JpaRepository<MarketPlace, Long>{
    void findByName(String name);
}
