package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;
import tn.esprit.backendpi.Entities.Enum.TypeReact;
import tn.esprit.backendpi.Entities.ReactCollocation;
import tn.esprit.backendpi.Repository.AnnCollocationRepository;
import tn.esprit.backendpi.Repository.ReactRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCollocationService;
import tn.esprit.backendpi.Service.Interfaces.IReact_CollService;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class React_CollServiceImpl implements IReact_CollService {
    private final ReactRepository reactRepo;

    private final IAnnCollocationService annCollocationService;
    private final AnnCollocationRepository annCollocationRepository;
    // Méthode pour ajouter une réaction de colocation
    @Override
    public ReactCollocation addReactCollocation(ReactCollocation reactCollocation, Long idCollocationAnnouncement) {
        AnnouncementCollocation announcement = annCollocationService.getAnnouncementCollocationById(idCollocationAnnouncement);
        if (announcement == null) {
            // Gérer le cas où l'annonce n'est pas trouvée
            return null;
        }

        ReactCollocation reaction = reactRepo.save(reactCollocation);
        //announcement.addReact(reaction);
        annCollocationService.updateAnnouncementCollocation(idCollocationAnnouncement, announcement);

        return reaction;
    }

    // Méthode pour mettre à jour une réaction de colocation
    @Override
    public ReactCollocation updateReactCollocation(Long id, ReactCollocation updatedReactCollocation) {
        // Vérifiez d'abord si la réaction existe dans la base de données
        ReactCollocation existingReactCollocation = reactRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Réaction de colocation introuvable avec l'ID : " + id));

        // Mettez à jour les champs de la réaction existante avec les valeurs de la réaction mise à jour
        //existingReactCollocation.setTypeReact(updatedReactCollocation.getTypeReact());
        existingReactCollocation.setUserReact(updatedReactCollocation.getUserReact());

        // Enregistrez les modifications dans la base de données et retournez la réaction mise à jour
        return reactRepo.save(existingReactCollocation);
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
        return reactRepo.countDislikesByAnnoucementId(idCollocationAnnouncement);
    }

    @Override
    public int nbrLikesParPost(Long idCollocationAnnouncement) {
        return reactRepo.countLikesByAnnoucementId(idCollocationAnnouncement);
    }

    @Override
    public ReactCollocation addReactToAnnoucement(ReactCollocation r, Long idCollocationAnnouncement) {
        AnnouncementCollocation announcementCollocation = annCollocationRepository.findById(idCollocationAnnouncement)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        r.setAnnouncementCollocation(announcementCollocation);

        // Assurez-vous que la méthode save retourne un objet de type ReactCollocation
        return reactRepo.save(r);

    }

    @Override
    public ReactCollocation dislikeAnncol(Long idCollocationAnnouncement) {
        AnnouncementCollocation announcementCollocation= annCollocationRepository.findById(idCollocationAnnouncement).orElseThrow(() -> new RuntimeException("AnnoucementColl not found"));
        ReactCollocation reactCollocation=reactRepo.findByAnnouncementCollocationIdCollocationAnnouncement(idCollocationAnnouncement);
        reactCollocation.setAnnouncementCollocation(announcementCollocation);
        reactCollocation.setDislikes(reactCollocation.getDislikes()+1);

        return reactRepo.save(reactCollocation);

    }

    @Override
    public ReactCollocation likeAnnCol(Long idCollocationAnnouncement) {
        AnnouncementCollocation announcementCollocation= annCollocationRepository.findById(idCollocationAnnouncement).orElseThrow(() -> new RuntimeException("AnnoucementColl not found"));
        ReactCollocation reactCollocation=reactRepo.findByAnnouncementCollocationIdCollocationAnnouncement(idCollocationAnnouncement);
        reactCollocation.setAnnouncementCollocation(announcementCollocation);
        reactCollocation.setLikes(reactCollocation.getLikes()+1);

        return reactRepo.save(reactCollocation);

    }


}
