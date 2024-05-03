package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.House;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.IUserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/user")

@AllArgsConstructor
public class UserController {

    IUserService iUserService;

    @Autowired
    UserRepository userRepo;


    @GetMapping("/retrieve/{idUser}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
    public ResponseEntity<User> retrieveUser(@PathVariable("idUser") long idUser) {
        User user = iUserService.retrieveUser(idUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{idUser}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // Allow access for users with USER or ADMIN roles
    public ResponseEntity<User> updateUser(@PathVariable("idUser") long idUser, @RequestBody User updatedUser) {
        updatedUser.setId(idUser);
        User savedUser = iUserService.update(updatedUser);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/updateUserDetails/{id}")
// Allow access for users with USER or ADMIN roles
    public User updateByAyari(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        System.out.println(id);
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID : " + id));

        existingUser.setScore(updatedUser.getScore());
        // Update other fields if necessary

        return userRepo.save(existingUser);

    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}