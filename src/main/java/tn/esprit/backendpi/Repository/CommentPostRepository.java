package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.CommentPost;

import java.util.List;


@Repository
public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {
    List<CommentPost> findByPostCommentIdPost(Long postId);
    List<CommentPost> findByPostCoReflexiveIdCommentPost(Long commentId);

}
