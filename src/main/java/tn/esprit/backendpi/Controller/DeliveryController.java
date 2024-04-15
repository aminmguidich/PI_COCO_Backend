package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.backendpi.Entities.Delivery;
import tn.esprit.backendpi.Service.Interfaces.IDeliveryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Delivery")

public class DeliveryController {
    @Autowired
    IDeliveryService deliveryService;
    @PostMapping("/addDelivery")
    public Delivery addDelivery(@RequestBody Delivery delivery) {
        return deliveryService.addDelivery(delivery);
    }


    @PutMapping("/updateDelivery")
    public Delivery updateDelivery(@RequestBody Delivery delivery) {
        return deliveryService.updateDelivery(delivery);
    }


    @DeleteMapping("/removeDelivery/{idDelivery}")
    public void removeDelivery(@PathVariable("idDelivery") long idDelivery) {
        deliveryService.removeDelivery(idDelivery);
    }

    @GetMapping("/retrieveDelivery")
    public List<Delivery> retrieveDeliveries() {
        return deliveryService.retrieveDeliveries();
    }


    @GetMapping("/retrieveDelivery/{idDelivery}")
    public Delivery retrieveDelivery(@PathVariable("idDelivery") long idDelivery) {
         return deliveryService.retrieveDelivery(idDelivery);
    }
}
