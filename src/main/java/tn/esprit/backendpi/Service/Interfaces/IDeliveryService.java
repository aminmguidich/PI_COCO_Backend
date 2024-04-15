package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Delivery;

import java.util.List;

public interface IDeliveryService {

    Delivery addDelivery (Delivery delivery);
    Delivery updateDelivery (Delivery delivery);
    void removeDelivery (long idDelivery);
    List<Delivery> retrieveDeliveries ();

    Delivery retrieveDelivery (long idDelivery);
}

