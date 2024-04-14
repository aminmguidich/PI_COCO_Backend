package tn.esprit.backendpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.House;

public interface HouseRepository extends CrudRepository<House,Long> {
}
