package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.Delivery;
import tn.esprit.backendpi.Entities.User;

public interface UserRepository  extends JpaRepository<User,Long> {
}
