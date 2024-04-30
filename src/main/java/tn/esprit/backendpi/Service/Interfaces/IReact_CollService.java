package tn.esprit.backendpi.Service.Interfaces;



import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.ReactCollocation;

import java.util.List;
import java.util.Optional;

@Service
public interface IReact_CollService {
    ReactCollocation addReactCollocation(ReactCollocation reactCollocation);
    ReactCollocation updateReactCollocation(Long id, ReactCollocation updatedReactCollocation);
    void removeReact(long idReact);
    List<ReactCollocation> retrieveReacts();
    ReactCollocation retrieveReact(long idReact);
    int nbrDislikesParPost(Long idCollocationAnnouncement);
    int nbrLikesParPost(Long idCollocationAnnouncement);
    ReactCollocation addReactToAnnoucement(ReactCollocation r);
    ReactCollocation dislikeAnncol(Long idCollocationAnnouncement);
    ReactCollocation likeAnnCol(Long idCollocationAnnouncement);


    Optional<ReactCollocation> findReactCollocationByUserId(Long idUser,Long idAnn);

    ReactCollocation updateReactColl(ReactCollocation reactCollocation);

    ReactCollocation addReact(ReactCollocation reactCollocation);
}

