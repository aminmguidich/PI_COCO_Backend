package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.Post;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT u.username FROM Post p JOIN p.userPost u WHERE p.idPost = :postId")
    Optional<String> findUserPostUsernameByPostId(Long postId);
}
