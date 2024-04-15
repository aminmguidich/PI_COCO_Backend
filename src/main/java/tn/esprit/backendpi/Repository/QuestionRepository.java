package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Méthodes spécifiques du repository
}
