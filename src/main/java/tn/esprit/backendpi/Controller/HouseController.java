package tn.esprit.backendpi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.backendpi.Entities.Contract;
import tn.esprit.backendpi.Entities.House;
import tn.esprit.backendpi.Service.Interfaces.IContractService;
import tn.esprit.backendpi.Service.Interfaces.IHouseService;
import tn.esprit.backendpi.Service.Interfaces.IpdfHouse;
import tn.esprit.backendpi.Entities.Enum.HouseType;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/House")
@CrossOrigin("*")
public class HouseController {

    @Autowired
    private IHouseService houseService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IpdfHouse ipdfHouse; // Autowire IpdfHouse interface


    private HouseType convertToHouseType(String houseTypeString) {
        try {
            return HouseType.valueOf(houseTypeString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid house type");
        }
    }

    @PostMapping("/addHouse")

    public House ajouterHouse(@RequestBody House house) {
        return houseService.ajouterHouse(house);
    }





    @GetMapping("/house/all")
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PutMapping("/house/update/{id}")
    public House updateHouse(@PathVariable Long id, @RequestBody House newHouse) {
        return houseService.updateHouse(id, newHouse);
    }


    @GetMapping("/house/{id}")
    public House findHouseById(@PathVariable Long id) {
        return houseService.findHouseById(id);
    }

    @DeleteMapping("/house/delete/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/house/{houseId}/assign-contract/{contractId}")
    public ResponseEntity<String> assignContractToHouse(@PathVariable Long houseId, @PathVariable Long contractId) {
        houseService.assignContractToHouse(contractId, houseId);
        return new ResponseEntity<>("Contract assigned to house successfully", HttpStatus.OK);
    }

    @GetMapping("/pdf")
    public byte[] generatePdf(@RequestParam Long contractId, @RequestParam Long houseId) throws IOException {
        // Retrieve contract and house based on their IDs
        Contract contract = contractService.findContractById(contractId);
        House house = houseService.findHouseById(houseId);

        // Generate the PDF using the IpdfHouse service
        return ipdfHouse.generatePdf(contractId, houseId);





    }

}


