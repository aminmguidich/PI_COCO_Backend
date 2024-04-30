package tn.esprit.backendpi.Service.Interfaces;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.backendpi.Entities.Enum.HouseType;
import tn.esprit.backendpi.Entities.House;

import java.util.List;

public interface IHouseService {

    public List<House> getAllHouses();
    public House findHouseById(Long id);
    public House updateHouse(Long id, House newHouse);
    void deleteHouse(Long id);
    void assignContractToHouse(Long contractId, Long houseId);
    public House ajouterHouse(House house);
}
