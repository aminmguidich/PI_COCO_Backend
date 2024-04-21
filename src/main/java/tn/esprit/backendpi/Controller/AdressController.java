package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Adress;
import tn.esprit.backendpi.Service.Interfaces.IAdressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Adress")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class AdressController {

    @DeleteMapping("/deleteAdress/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteAdress(@PathVariable Long id) {
        iAdressService.deleteAdress(id);
    }

    private final IAdressService iAdressService;

    @PostMapping("/AddAdress")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public Adress AddAdress(@RequestBody Adress adress) {
        return iAdressService.AddAdress(adress);
    }
}
