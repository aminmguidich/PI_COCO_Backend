package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.MarketPlace;
import tn.esprit.backendpi.Service.Classes.MarketPlaceService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/marketPlace")
@CrossOrigin(origins = "http://localhost:4200")
public class MarketPlaceController {

    @Autowired
    MarketPlaceService marketPlaceService;

    @PostMapping("/addMarketPlace")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public MarketPlace addMarketPlace(@RequestBody MarketPlace marketPlace) {
        return 	marketPlaceService.addMarketPlace(marketPlace);
    }

    @GetMapping("/getAllMarketPlace")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Iterable<MarketPlace> getAllMarketPlace() {
        return marketPlaceService.getAllMarketPlace();
    }

    @DeleteMapping("/deleteMarketPlace/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteMarketPlaceById(@PathVariable Long id) {
        marketPlaceService.deleteMarketPlaceById(id);
    }

    @GetMapping("/getPlacebyNames/{name}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public void getPlacebyNames(@PathVariable String name){
        marketPlaceService.getPlacebyNames(name);
    }
}
