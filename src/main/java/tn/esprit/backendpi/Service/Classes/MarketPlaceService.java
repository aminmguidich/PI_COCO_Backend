package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;
import tn.esprit.backendpi.Entities.MarketPlace;
import tn.esprit.backendpi.Repository.MarketPlaceRepository;

@Service
public class MarketPlaceService {

    @Autowired
    MarketPlaceRepository marketPlaceRepository;

    public MarketPlace addMarketPlace(MarketPlace marketPlace) {
        return marketPlaceRepository.save(marketPlace);
    }

    public Iterable<MarketPlace> getAllMarketPlace() {
        return marketPlaceRepository.findAll();
    }

    public void deleteMarketPlaceById(Long id) {
        marketPlaceRepository.deleteById(id);
    }

    //find by name
    public void getPlacebyNames(String name){
        marketPlaceRepository.findByName(name);
    }
}
