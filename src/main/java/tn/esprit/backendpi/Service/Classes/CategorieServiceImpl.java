package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Categorie;
import tn.esprit.backendpi.Repository.CategorieRepository;
import tn.esprit.backendpi.Service.Interfaces.ICategorieService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements ICategorieService {

    private final CategorieRepository categorieRepo;

    @Override
    public Categorie addCategorie(Categorie categorie) {
       return categorieRepo.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepo.save(categorie);
    }

    @Override
    public void removeCategorie(long idCategorie) {
        categorieRepo.deleteById(idCategorie);

    }

    @Override
    public List<Categorie> retrieveCtegorie() {
        return (List<Categorie>) categorieRepo.findAll() ;
    }

    @Override
    public Categorie retrieveCategorie(long idCategorie) {
        return  categorieRepo.findById(idCategorie).orElse(null);
    }



}
