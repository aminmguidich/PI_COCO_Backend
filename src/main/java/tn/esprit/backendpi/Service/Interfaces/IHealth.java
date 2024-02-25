package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.BalanceSheet;
import tn.esprit.backendpi.Entities.Car;
import tn.esprit.backendpi.Entities.Route;

import java.util.List;

public interface IHealth {

    /*********     Cars     **********/
    List<Car> retrieveAllCar();
    Car updateCar (Car car);
    Car addCar (Car car);
    Car retrieveCar (long idCar);
    void removeCar (long idCar);

    /*********     Route     **********/
    List<Route> retrieveAllRoute();
    Route updateRoute (Route r);
    Route addRoute (Route r);
    Route retrieveRoute (long idRoute);
    void removeRoute (long idRoute);

    /*********     BalanceSheet     **********/
    List<BalanceSheet> retrieveAllBalanceSheet();
    BalanceSheet updateBalanceSheet (BalanceSheet b);
    BalanceSheet addBalanceSheet (BalanceSheet b);
    BalanceSheet retrieveBalanceSheet (long idBalanceSheet);
    void removeBalanceSheet (long idBalanceSheet);


}
