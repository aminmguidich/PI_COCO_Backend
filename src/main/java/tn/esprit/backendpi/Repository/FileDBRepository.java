package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
