package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.CommentPost;
import tn.esprit.backendpi.Entities.ReactPost;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {
    List<CommentPost> findByPostCommentIdPost(Long postId);
    List<CommentPost> findByPostCoReflexiveIdCommentPost(Long commentId);

    @Query("SELECT c.reactPostsComment FROM CommentPost c WHERE c.idCommentPost = ?1")
    List<ReactPost> findReactsForComment(Long idComment);


    @Query("SELECT u.username FROM CommentPost c JOIN c.userCommentPost u WHERE c.idCommentPost = :idCommentPost")
    Optional<String> findUserCommentPostByIdCommentPost(Long idCommentPost);



}
