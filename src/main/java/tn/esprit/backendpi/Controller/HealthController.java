package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.BalanceSheet;
import tn.esprit.backendpi.Entities.Car;
import tn.esprit.backendpi.Entities.Route;
import tn.esprit.backendpi.Service.Classes.HealthService;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class HealthController {

    HealthService service;

    /*********     Cars     **********/
    @GetMapping("/retrieveAllCar")
    public List<Car> retrieveAllCar() {return service.retrieveAllCar();}
    @PutMapping("/updateCar")
    public Car updateCar(@RequestBody Car car) {return service.updateCar(car);}
    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car) {return service.addCar(car);}
    @GetMapping("/retrieveCar/{id}")
    public Car retrieveCar(@PathVariable("id") long idCar) {return service.retrieveCar(idCar);}

    @DeleteMapping("/removeCar/{id}")
    public void removeCar(@PathVariable("id") long idCar) {service.removeCar(idCar);}

    /*********     BalanceSheet     **********/
    @GetMapping("/retrieveAllBalanceSheet")
    public List<BalanceSheet> retrieveAllBalanceSheet() {return service.retrieveAllBalanceSheet();}
    @PutMapping("/updateBalanceSheet")
    public BalanceSheet updateBalanceSheet(@RequestBody BalanceSheet b) {return service.updateBalanceSheet(b);}
    @PostMapping("/addBalanceSheet")
    public BalanceSheet addBalanceSheet(@RequestBody BalanceSheet b) {return service.addBalanceSheet(b);}

    @GetMapping("/retrieveBalanceSheet/{id}")
    public BalanceSheet retrieveBalanceSheet( @PathVariable("id") long idBalanceSheet) {return service.retrieveBalanceSheet(idBalanceSheet);}
    @DeleteMapping("/removeBalanceSheet/{id}")
    public void removeBalanceSheet(@PathVariable("id") long idBalanceSheet) {service.removeBalanceSheet(idBalanceSheet);}

    /*********     Route     **********/
    @GetMapping("/retrieveAllRoute")
    public List<Route> retrieveAllRoute() {return service.retrieveAllRoute();}
    @PutMapping("/updateRoute")
    public Route updateRoute(@RequestBody Route r) {return service.updateRoute(r);}
    @PostMapping("/addRoute")
    public Route addRoute(@RequestBody Route r) {return service.addRoute(r);}
    @GetMapping("/retrieveRoute/{id}")
    public Route retrieveRoute(@PathVariable("id") long idRoute) {return service.retrieveRoute(idRoute);}
    @DeleteMapping("/removeRoute/{id}")
    public void removeRoute(@PathVariable("id")long idRoute) {service.removeRoute(idRoute);}
}
