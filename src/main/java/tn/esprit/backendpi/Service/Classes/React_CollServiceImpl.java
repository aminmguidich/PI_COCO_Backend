package tn.esprit.backendpi.Service.Classes;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.ReactCollocation;
import tn.esprit.backendpi.Repository.ReactRepository;
import tn.esprit.backendpi.Service.Interfaces.IReact_CollService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class React_CollServiceImpl implements IReact_CollService {
    private final ReactRepository ReactRepo;


    @Override
    public ReactCollocation addReact(ReactCollocation react) {

        return ReactRepo.save(react);
    }

    @Override
    public ReactCollocation updateReactCollocation(Long id, ReactCollocation updatedReactCollocation) {
        // Vérifiez d'abord si la réaction existe dans la base de données
        ReactCollocation existingReactCollocation = ReactRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Réaction de collocation introuvable avec l'ID : " + id));

        // Mettez à jour les champs de la réaction existante avec les valeurs de la réaction mise à jour
        existingReactCollocation.setTypeReact(updatedReactCollocation.getTypeReact());
        existingReactCollocation.setUserReact(updatedReactCollocation.getUserReact());

        // Enregistrez les modifications dans la base de données et retournez la réaction mise à jour
        return ReactRepo.save(existingReactCollocation);
    }




    @Override
    public void removeReact(long idReact) {
        ReactRepo.deleteById(idReact);
    }

    @Override
    public List<ReactCollocation> retrieveReacts() {
        return (List<ReactCollocation>) ReactRepo.findAll();
    }

    @Override
    public ReactCollocation retrieveReact(long idReact) {
        return ReactRepo.findById(idReact)
                .orElseThrow(() -> new RuntimeException("Réaction non trouvée"));
    }

}

