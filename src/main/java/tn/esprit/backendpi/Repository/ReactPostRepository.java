package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.ReactPost;

@Repository
public interface ReactPostRepository extends JpaRepository<ReactPost,Long> {

}
