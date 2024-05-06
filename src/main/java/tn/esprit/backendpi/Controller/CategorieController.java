package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import tn.esprit.backendpi.Entities.Categorie;
import tn.esprit.backendpi.Service.Classes.CategorieServiceImpl;
import tn.esprit.backendpi.Service.Interfaces.ICategorieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Categorie")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class CategorieController {
    @Autowired
    CategorieServiceImpl categorieService;

        @PostMapping("/add")
       // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
        public Categorie addCategorie(@RequestBody Categorie categorie) {
            return categorieService.addCategorie(categorie);
        }

        @PutMapping("/update")
       // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
        public Categorie updateCategorie(@RequestBody Categorie categorie) {
            return categorieService.updateCategorie(categorie);
        }

        @DeleteMapping("/remove/{id}")
      //  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
        public void removeCategorie(@PathVariable long id) {
            categorieService.removeCategorie(id);
        }

        @GetMapping("/retrieveAll")
       // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
        public List<Categorie> retrieveAllCtegorie() {
            return categorieService.retrieveCtegorie();
        }

        @GetMapping("/retrieve/{id}")
        //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
        public Categorie retrieveCategorie(@PathVariable long id) {
            return categorieService.retrieveCategorie(id);
        }


}
