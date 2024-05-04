package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.backendpi.Entities.ReactCollocation;
import tn.esprit.backendpi.Entities.ReactCollocation;

import java.util.Optional;

public interface ReactRepository extends CrudRepository<ReactCollocation,Long> {
    ReactCollocation findByAnnouncementCollocationIdCollocationAnnouncement(@Param("id") Long id);

    @Query("SELECT r FROM ReactCollocation r WHERE r.idUser = :idUser and r.idAnn = :idAnn ")
    Optional<ReactCollocation> findByUserId(Long idUser,Long idAnn);
}
