package tn.esprit.backendpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.Contract;

public interface ContractRepository extends CrudRepository<Contract,Long> {
}
