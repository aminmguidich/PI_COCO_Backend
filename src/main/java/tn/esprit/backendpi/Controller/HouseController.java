package tn.esprit.backendpi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.backendpi.Entities.*;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Classes.AnnCollocationServiceImpl;
import tn.esprit.backendpi.Service.Classes.FileStorageService;
import tn.esprit.backendpi.Service.Interfaces.IContractService;
import tn.esprit.backendpi.Service.Interfaces.IHouseService;
import tn.esprit.backendpi.Service.Interfaces.IpdfHouse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/House")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class HouseController {

    @Autowired
    private IHouseService houseService;

    @Autowired
    private AnnCollocationServiceImpl annService;

    @Autowired
    private IpdfHouse ipdfHouse; // Autowire IpdfHouse interface
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    UserRepository userRepository;




    private HouseType convertToHouseType(String houseTypeString) {
        try {
            return HouseType.valueOf(houseTypeString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid house type");
        }
    }

    @PostMapping("/addHouse")

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @ResponseBody
    public Boolean ajouterHouse(@RequestPart(value = "house") String publicite,
                              @RequestPart(value = "image", required = false) MultipartFile file,
                              @RequestParam("userId") Long userId,@RequestParam("username") String username) throws IOException {
        House house = new ObjectMapper().readValue(publicite, House.class);
        FileDB image = fileStorageService.store(file);
        house.setImage(image);
        house.setUserId(userId);
        house.setUsername(username);

        AnnouncementCollocation annColl = new AnnouncementCollocation();

        annColl.setImage(image);
        annColl.setTitle(house.getTitle());
        annColl.setUserId(userId);
        annColl.setUsername(username);
        annColl.setDescription(house.getDescription());
        annColl.setBudgetPart(5);
        annColl.setScore(5);
        annColl.setDateCollocationAnnouncement(LocalDate.now());



        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            // Handle the case where user with given userId is not found
            // You may throw an exception or return an appropriate response
            // Here, I'm assuming you throw an IllegalArgumentException
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

        // Associate the fetched user with the house
        house.setUser(user.get());

        houseService.ajouterHouse(house);
        addAnnoncementAuto(annColl);


        // Fetch the user from the database using the provided userId

        return true;
    }


    public AnnouncementCollocation addAnnoncementAuto(AnnouncementCollocation ann){

        return annService.addAnnouncementCollocation(ann);

    }



    @GetMapping("/house/all")

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PutMapping("/house/update/{id}")

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public House updateHouse(@PathVariable Long id, @RequestPart(value = "house") String houseD,
                             @RequestPart(value = "image", required = false) MultipartFile file) throws IOException  {
        System.out.println(houseD);
        House house = new ObjectMapper().readValue(houseD, House.class);
        FileDB image = fileStorageService.store(file);
        house.setImage(image);

        return houseService.updateHouse(id, house);
    }


    @GetMapping("/house/{id}")

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public House findHouseById(@PathVariable Long id) {
        return houseService.findHouseById(id);
    }

    @GetMapping("/house/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Boolean deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
        return true;
    }

    @PutMapping("/house/{houseId}/assign-contract/{contractId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> assignContractToHouse(@PathVariable Long houseId, @PathVariable Long contractId) {
        houseService.assignContractToHouse(contractId, houseId);
        return new ResponseEntity<>("Contract assigned to house successfully", HttpStatus.OK);
    }




    @PostMapping("/pdf")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public byte[] generatePdf(@RequestBody Contract contractD) throws IOException {
        // Retrieve contract and house based on their IDs
        Contract contract = new Contract();
        contract.setDescription(contractD.getDescription());
        contract.setHouseContract(contractD.getHouseContract());
        contract.setHouseType(contractD.getHouseType());
        contract.setOwner(contractD.getOwner());
        contract.setLocation(contractD.getLocation());
        contract.setNombre_de_places(contractD.getNombre_de_places());
        contract.setUname(contractD.getUname());
        contract.setHouseId(contractD.getHouseId());
        contract.setUserId(contractD.getUserId());
        House house = houseService.findHouseById(contractD.getHouseId());

        // Generate the PDF using the IpdfHouse service
        return ipdfHouse.generatePdf(contract);
    }

}

