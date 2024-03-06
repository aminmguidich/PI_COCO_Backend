package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
