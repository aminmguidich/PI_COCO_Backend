package tn.esprit.backendpi.Service.Interfaces;





import tn.esprit.backendpi.Entities.Categorie;

import java.util.List;

public interface ICategorieService {

    Categorie addCategorie( Categorie categorie);
    Categorie  updateCategorie (Categorie  categorie);
    void removeCategorie(long idCategorie);
    List<Categorie > retrieveCtegorie ();
    Categorie retrieveCategorie (long idCategorie);

}
