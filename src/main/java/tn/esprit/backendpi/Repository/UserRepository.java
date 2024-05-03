package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    User findByVerificationCode(String verificationCode);
    @Query("SELECT u.imageUrl FROM User u WHERE u.username = ?1")
    Optional<String> findImageUrlByUsername(String username);


}