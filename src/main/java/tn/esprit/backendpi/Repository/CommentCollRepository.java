package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backendpi.Entities.CommentCol;

public interface CommentCollRepository extends JpaRepository<CommentCol,Long> {
}
