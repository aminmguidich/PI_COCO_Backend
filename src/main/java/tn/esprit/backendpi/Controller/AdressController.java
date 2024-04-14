package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Adress;
import tn.esprit.backendpi.Service.Interfaces.IAdressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Adress")
@CrossOrigin("*")
public class AdressController {
    private final IAdressService iAdressService;

    @PostMapping("/AddAdress")
    public Adress AddAdress(@RequestBody Adress adress) {
        return iAdressService.AddAdress(adress);
    }
}
