package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Claims;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Service.Interfaces.IClaimService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequestMapping("/api/claim")
@AllArgsConstructor
public class ClaimController {
    IClaimService iClaimService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Claims add(@RequestBody Claims claim) {
        return iClaimService.add(claim);
    }

    @GetMapping("/retreive/{idClaim}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Claims> retreive(@PathVariable("idClaim") long idClaim) {
        Claims claim = iClaimService.retreive(idClaim);
        if (claim != null) {
            return ResponseEntity.ok(claim);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}