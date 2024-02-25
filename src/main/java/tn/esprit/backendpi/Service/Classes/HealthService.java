package tn.esprit.backendpi.Service.Classes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.BalanceSheet;
import tn.esprit.backendpi.Entities.Car;
import tn.esprit.backendpi.Entities.Route;
import tn.esprit.backendpi.Repository.BalanceSheetRepository;
import tn.esprit.backendpi.Repository.CarRepository;
import tn.esprit.backendpi.Repository.RouteRepository;
import tn.esprit.backendpi.Service.Interfaces.IHealth;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class HealthService implements IHealth {

    /*********     Injection     **********/

    BalanceSheetRepository balanceSheetRepository;
    CarRepository carRepository;
    RouteRepository routeRepository;


    /*********     Cars     **********/
    @Override
    public List<Car> retrieveAllCar() {return carRepository.findAll();}
    @Override
    public Car updateCar(Car car) {return carRepository.save(car);}
    @Override
    public Car addCar(Car car) {return carRepository.save(car);}
    @Override
    public Car retrieveCar(long idCar) {return carRepository.findById(idCar).orElse(null);}
    @Override
    public void removeCar(long idCar) {carRepository.deleteById(idCar);}

    /*********     BalanceSheet     **********/
    @Override
    public List<BalanceSheet> retrieveAllBalanceSheet() {return balanceSheetRepository.findAll();}
    @Override
    public BalanceSheet updateBalanceSheet(BalanceSheet b) {return balanceSheetRepository.save(b);}
    @Override
    public BalanceSheet addBalanceSheet(BalanceSheet b) {return balanceSheetRepository.save(b);}
    @Override
    public BalanceSheet retrieveBalanceSheet(long idBalanceSheet) {return balanceSheetRepository.findById(idBalanceSheet).orElse(null);}
    @Override
    public void removeBalanceSheet(long idBalanceSheet) {balanceSheetRepository.deleteById(idBalanceSheet);}

    /*********     Route     **********/
    @Override
    public List<Route> retrieveAllRoute() {return routeRepository.findAll();}
    @Override
    public Route updateRoute(Route r) {return routeRepository.save(r);}
    @Override
    public Route addRoute(Route r) {return routeRepository.save(r);}
    @Override
    public Route retrieveRoute(long idRoute) {return routeRepository.findById(idRoute).orElse(null);}
    @Override
    public void removeRoute(long idRoute) {routeRepository.deleteById(idRoute);}
}
