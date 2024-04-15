package tn.esprit.backendpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.Delivery;

public interface DeliveryRepository extends CrudRepository<Delivery,Long> {
}
