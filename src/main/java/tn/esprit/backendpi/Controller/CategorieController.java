package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.backendpi.Entities.Categorie;
import tn.esprit.backendpi.Service.Classes.CategorieServiceImpl;
import tn.esprit.backendpi.Service.Interfaces.ICategorieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Categorie")
@CrossOrigin(origins = "*")
public class CategorieController {
    @Autowired
    CategorieServiceImpl categorieService;

        @PostMapping("/add")
        public Categorie addCategorie(@RequestBody Categorie categorie) {
            return categorieService.addCategorie(categorie);
        }

        @PutMapping("/update")
        public Categorie updateCategorie(@RequestBody Categorie categorie) {
            return categorieService.updateCategorie(categorie);
        }

        @DeleteMapping("/remove/{id}")
        public void removeCategorie(@PathVariable long id) {
            categorieService.removeCategorie(id);
        }

        @GetMapping("/retrieveAll")
        public List<Categorie> retrieveAllCtegorie() {
            return categorieService.retrieveCtegorie();
        }

        @GetMapping("/retrieve/{id}")
        public Categorie retrieveCategorie(@PathVariable long id) {
            return categorieService.retrieveCategorie(id);
        }


}
