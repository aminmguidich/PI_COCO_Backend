package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.House;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.HouseRepository;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Classes.FileNamingUtil;
import tn.esprit.backendpi.Service.Interfaces.IHouseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Service
public class HouseServiceImpl implements IHouseService {

    private final HouseRepository houseRepository;
    private final FileNamingUtil fileNamingUtil;
    private final String uploadImages;

    public HouseServiceImpl(HouseRepository houseRepository, FileNamingUtil fileNamingUtil, @Value("${uploadImages}") String uploadImages) {
        this.houseRepository = houseRepository;
        this.fileNamingUtil = fileNamingUtil;
        this.uploadImages = uploadImages;
    }

    private static final int MAX_IMAGE_SIZE = 10 * 1024 * 1024; // 10 Mo en octets


    @Override
    public List<House> getAllHouses() {
        return (List<House>) houseRepository.findAll();
    }

    @Override
    public House findHouseById(Long id) {
        return houseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("House not found with ID : " + id));
    }

    @Override
    public House updateHouse(Long id, House newHouse) {
        House existingHouse = houseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("House not found with ID : " + id));

        existingHouse.setImage(newHouse.getImage());
        existingHouse.setHouseType(newHouse.getHouseType());
        existingHouse.setPlaces(newHouse.getPlaces());
        // Update other fields if necessary

        return houseRepository.save(existingHouse);
    }

    @Override
    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public void assignContractToHouse(Long contractId, Long houseId) {

    }

    @Override
    public House ajouterHouse(House house) {

        return houseRepository.save(house);
    }
}