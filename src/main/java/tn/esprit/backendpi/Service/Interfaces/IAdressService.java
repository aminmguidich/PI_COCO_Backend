package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Adress;

public interface IAdressService {
    Adress AddAdress(Adress adress);
    void deleteAdress(Long id );


}
