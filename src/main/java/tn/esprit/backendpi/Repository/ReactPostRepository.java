package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.CommentPost;
import tn.esprit.backendpi.Entities.ReactPost;

import java.util.List;

@Repository
public interface ReactPostRepository extends JpaRepository<ReactPost,Long> {
    List<ReactPost> findByPostIdPost(Long postId);

}
