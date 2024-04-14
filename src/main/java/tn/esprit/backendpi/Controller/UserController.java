package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Service.Interfaces.IUserService;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/user")

@AllArgsConstructor
public class UserController {

    IUserService iUserService;


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
}