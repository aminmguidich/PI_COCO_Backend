package tn.esprit.backendpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.Adress;

public interface AdressRepository extends CrudRepository<Adress,Long> {
}
