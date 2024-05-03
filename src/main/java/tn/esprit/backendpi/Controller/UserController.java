package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.backendpi.Entities.Car;
import tn.esprit.backendpi.Entities.GenderType;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.CarRepository;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.IUserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/user")

@AllArgsConstructor
public class UserController {

    IUserService iUserService;
    UserRepository userRepository;
    CarRepository carRepository;


    @GetMapping("/retrieve")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
    public ResponseEntity<User> retrieveUser() {
        //Logged in user
        User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser) {
        // Get the logged-in user
        String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedInUser = userRepository.findByUsername(loggedInUsername).orElse(null);
        // Update the fields of the logged-in user
        loggedInUser.setUsername(updatedUser.getUsername());
        loggedInUser.setFullname(updatedUser.getFullname());
        loggedInUser.setPhone(updatedUser.getPhone());
        loggedInUser.setBirthDate(updatedUser.getBirthDate());
        loggedInUser.setGender(updatedUser.getGender());
        loggedInUser.setNiv(updatedUser.getNiv());
        loggedInUser.setEspritId(updatedUser.getEspritId());
        if (updatedUser.getCarUser() != null) {
            Car updatedUserCar = updatedUser.getCarUser();
            if (loggedInUser.getCarUser() != null ){
                loggedInUser.getCarUser().setRegistrationNumber(updatedUserCar.getRegistrationNumber());
                loggedInUser.getCarUser().setSmoking(updatedUserCar.getSmoking());
                loggedInUser.getCarUser().setAirConditioned(updatedUserCar.getAirConditioned());
                loggedInUser.getCarUser().setPlaces(updatedUserCar.getPlaces());
                loggedInUser.getCarUser().setModel(updatedUserCar.getModel());
            }else {
                Car car = new Car();
                car.setRegistrationNumber(updatedUserCar.getRegistrationNumber());
                car.setImage(updatedUserCar.getImage());
                car.setSmoking(updatedUserCar.getSmoking());
                car.setAirConditioned(updatedUserCar.getAirConditioned());
                car.setPlaces(updatedUserCar.getPlaces());
                car.setModel(updatedUserCar.getModel());
                carRepository.save(car);
                loggedInUser.setCarUser(car);
            }

        }
        // Set gender based on espritId
        if (loggedInUser.getEspritId() != null && loggedInUser.getEspritId().contains("M")) {
            loggedInUser.setGender(GenderType.MALE);
        } else {
            loggedInUser.setGender(GenderType.FEMALE);
        }
        // Set other fields as needed

        // Save the updated user
        User savedUser = iUserService.update(loggedInUser);

        return ResponseEntity.ok(savedUser);
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Check if the file is empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Please upload a file");
            }

            // Get the file bytes
            byte[] bytes = file.getBytes();

            // Resolve the upload path
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path uploadPath = Paths.get("C:/xampp/htdocs/images/");

            // Ensure the directory exists, create it if not
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file to the specified path
            Path filePath = uploadPath.resolve(fileName);
            Files.write(filePath, bytes);

            // Update the image path in the logged-in user entity
            String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
            User loggedInUser = userRepository.findByUsername(loggedInUsername).orElse(null);
            String relativeImagePath = "http://localhost/images/" + fileName;
            if (loggedInUser != null) {
                // Store the relative path in the user entity

                loggedInUser.setImageUrl(relativeImagePath);
                iUserService.update(loggedInUser);
            }

            return ResponseEntity.ok(relativeImagePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
    @PostMapping("/uploadCarImage")
    public ResponseEntity<String> uploadCarImage(@RequestParam("file") MultipartFile file) {
        try {
            // Check if the file is empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Please upload a file");
            }

            // Get the file bytes
            byte[] bytes = file.getBytes();

            // Resolve the upload path
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path uploadPath = Paths.get("C:/xampp/htdocs/images/");

            // Ensure the directory exists, create it if not
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file to the specified path
            Path filePath = uploadPath.resolve(fileName);
            Files.write(filePath, bytes);

            // Update the image path in the logged-in user entity
            String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
            User loggedInUser = userRepository.findByUsername(loggedInUsername).orElse(null);
            String relativeImagePath = "http://localhost/images/" + fileName;
            if (loggedInUser != null) {
                // Store the relative path in the user entity
                if (loggedInUser.getCarUser() != null ) {
                    loggedInUser.getCarUser().setImage(relativeImagePath);
                    iUserService.update(loggedInUser);
                }
            }

            return ResponseEntity.ok(relativeImagePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    @GetMapping("/retrieveAll")
    public List<User> retrieveAllUsers() {
        return iUserService.retrieveAllUsers();
    }

    @PutMapping("/updateSimple")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<User> update(@RequestBody User updatedUser) {

        User savedUser = iUserService.update(updatedUser);

        return ResponseEntity.ok(savedUser);
    }

}