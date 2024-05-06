package tn.esprit.backendpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.Command;

public interface CommandRepository extends CrudRepository<Command,Long> {
  //  Command findByDeliverv(String deliver)
}
