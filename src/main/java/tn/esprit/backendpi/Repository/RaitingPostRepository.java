package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.RaitingPost;
import tn.esprit.backendpi.Entities.User;

@Repository
public interface RaitingPostRepository extends JpaRepository<RaitingPost,Long> {
    RaitingPost findByUserRaitingPostAndPostRaitingIdPost(User user, Long postId);


    @Query("SELECT COUNT(DISTINCT rp.userRaitingPost) FROM RaitingPost rp WHERE :postId IN (SELECT p.idPost FROM rp.postRaiting p)")
    int countUsersReactedToPost(@Param("postId") Long postId);


    @Query("SELECT COUNT(rp) FROM RaitingPost rp WHERE :postId IN (SELECT p.idPost FROM rp.postRaiting p)")
    int countRatingsForPost(@Param("postId") Long postId);
    @Query("SELECT SUM(rp.nbrStars) FROM RaitingPost rp WHERE :postId IN (SELECT p.idPost FROM rp.postRaiting p)")
    Integer calculateSumOfRatingsForPost(@Param("postId") Long postId);


}
