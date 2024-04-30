package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;
import tn.esprit.backendpi.Entities.ReactCollocation;
import tn.esprit.backendpi.Repository.AnnCollocationRepository;
import tn.esprit.backendpi.Repository.ReactRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCollocationService;
import tn.esprit.backendpi.Service.Interfaces.IReact_CollService;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class React_CollServiceImpl implements IReact_CollService {
    private final ReactRepository reactRepo;

    private final IAnnCollocationService annCollocationService;
    private final AnnCollocationRepository annCollocationRepository;
    // Méthode pour ajouter une réaction de colocation


    @Override
    public ReactCollocation addReactCollocation(ReactCollocation reactCollocation) {
        return null;
    }

    @Override
    public ReactCollocation updateReactCollocation(Long id, ReactCollocation updatedReactCollocation) {
        ReactCollocation reactCollocation = reactRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Collocation announcement not found with ID : " + id));

        reactCollocation.setLikes(updatedReactCollocation.getLikes());
        reactCollocation.setDislikes(updatedReactCollocation.getDislikes());

        // Save the changes to the database and return the updated announcement
        return reactRepo.save(reactCollocation);
    }

    // Méthode pour mettre à jour une réaction de colocation

    public ReactCollocation updateReactColl( ReactCollocation updatedReactCollocation) {

        return reactRepo.save(updatedReactCollocation);
    }

    // Méthode pour supprimer une réaction de colocation
    @Override
    public void removeReact(long idReact) {
        reactRepo.deleteById(idReact);
    }

    // Méthode pour récupérer toutes les réactions de colocation
    @Override
    public List<ReactCollocation> retrieveReacts() {
        return (List<ReactCollocation>) reactRepo.findAll();
    }

    // Méthode pour récupérer une réaction de colocation par son ID
    @Override
    public ReactCollocation retrieveReact(long idReact) {
        return reactRepo.findById(idReact)
                .orElseThrow(() -> new NotFoundException("Réaction de colocation non trouvée avec l'ID : " + idReact));
    }

    @Override
    public int nbrDislikesParPost(Long idCollocationAnnouncement) {
        return 0;
    }

    @Override
    public int nbrLikesParPost(Long idCollocationAnnouncement) {
        return 0;
    }

    @Override
    public ReactCollocation addReactToAnnoucement(ReactCollocation r) {
        return null;
    }


    public ReactCollocation addReact(ReactCollocation r) {


        // Assurez-vous que la méthode save retourne un objet de type ReactCollocation
        return reactRepo.save(r);

    }

    @Override
    public ReactCollocation dislikeAnncol(Long idCollocationAnnouncement) {
        return null;
    }

    @Override
    public ReactCollocation likeAnnCol(Long idCollocationAnnouncement) {
        return null;
    }

    @Override
    public Optional<ReactCollocation> findReactCollocationByUserId(Long idUser,Long idAnn) {
        return reactRepo.findByUserId(idUser,idAnn);
    }


}
