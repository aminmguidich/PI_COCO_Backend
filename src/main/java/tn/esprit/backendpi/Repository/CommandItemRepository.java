package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.CommandItem;

public interface CommandItemRepository extends JpaRepository<CommandItem,Long> {
}
