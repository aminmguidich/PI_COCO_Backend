package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
}
