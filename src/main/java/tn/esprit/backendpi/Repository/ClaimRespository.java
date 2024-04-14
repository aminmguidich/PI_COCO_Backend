package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.Claims;
@Repository
public interface ClaimRespository extends JpaRepository<Claims,Long> {
}
