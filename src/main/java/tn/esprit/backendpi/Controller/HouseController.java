package tn.esprit.backendpi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.backendpi.Entities.*;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Classes.AnnCollocationServiceImpl;
import tn.esprit.backendpi.Service.Classes.FileStorageService;
import tn.esprit.backendpi.Service.Classes.React_CollServiceImpl;
import tn.esprit.backendpi.Service.Classes.UserServiceImpl;
import tn.esprit.backendpi.Service.Interfaces.IContractService;
import tn.esprit.backendpi.Service.Interfaces.IHouseService;
import tn.esprit.backendpi.Service.Interfaces.IpdfHouse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/House")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600, allowCredentials="true")
public class HouseController {

    @Autowired
    private IHouseService houseService;

    @Autowired
    private AnnCollocationServiceImpl annService;

    @Autowired
    private React_CollServiceImpl reactCollService;

    @Autowired
    private UserServiceImpl userService;

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
    public AnnouncementCollocation ajouterHouse(@RequestPart(value = "house") String publicite,
                              @RequestPart(value = "image", required = false) MultipartFile file,
                              @RequestParam("userId") Long userId,@RequestParam("username") String username) throws IOException {

        System.out.println(publicite);


        House house = new ObjectMapper().readValue(publicite, House.class);

        System.out.println(house.getBudgetPart());

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "/Applications/XAMPP/xamppfiles/htdocs/images"; // Specify your upload directory here
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            String imageUrl = "http://localhost/images/" + fileName;
            house.setImageUrl(imageUrl);
        } catch (IOException ex) {
            throw new IOException("Could not save the file " + fileName + ". Please try again!", ex);
        }


        house.setUserId(userId);
        house.setUsername(username);

        AnnouncementCollocation annColl = new AnnouncementCollocation();

        annColl.setTitle(house.getTitle());
        annColl.setUserId(userId);
        annColl.setUsername(username);
        annColl.setDescription(house.getDescription());
        annColl.setBudgetPart(house.getBudgetPart());

        annColl.setDateCollocationAnnouncement(LocalDate.now());
        annColl.setImageUrl(house.getImageUrl());


        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            // Handle the case where user with given userId is not found
            // You may throw an exception or return an appropriate response
            // Here, I'm assuming you throw an IllegalArgumentException
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }


        houseService.ajouterHouse(house);
        return  addAnnoncementAuto(annColl);

    }


    public AnnouncementCollocation addAnnoncementAuto(AnnouncementCollocation ann){

        return annService.addAnnouncementCollocation(ann);

        //addReactAnnAuto(ann.getIdCollocationAnnouncement());

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

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "/Applications/XAMPP/xamppfiles/htdocs/images"; // Specify your upload directory here
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            String imageUrl = "http://localhost/images/" + fileName;
            house.setImageUrl(imageUrl);
            System.out.println(imageUrl);
        } catch (IOException ex) {
            throw new IOException("Could not save the file " + fileName + ". Please try again!", ex);
        }

        return houseService.updateHouse(id, house);
    }




    @PutMapping("/house/updateDetails/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public House updateHouseDetails(@PathVariable Long id, @RequestBody House houseD) throws IOException  {
        System.out.println(houseD);

        House house = new House();

        house.setContracted(houseD.getContracted());

        return houseService.updateHouseDetails(id, house);
    }


    @GetMapping("/house/{id}")

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public House findHouseById(@PathVariable Long id) {
        return houseService.findHouseById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
        return ResponseEntity.noContent().build();
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

