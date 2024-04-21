package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Adress;
import tn.esprit.backendpi.Repository.AdressRepository;
import tn.esprit.backendpi.Service.Interfaces.IAdressService;

@Service
@RequiredArgsConstructor
public class AdressServiceImpl implements IAdressService {
    private final AdressRepository adressRepository;
    @Override
    public Adress AddAdress(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public void deleteAdress(Long id) {
        adressRepository.deleteById(id);
    }
}
