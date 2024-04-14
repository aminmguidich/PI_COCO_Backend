package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RequirementCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;
import tn.esprit.backendpi.Service.Interfaces.IReqCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CarpoolingRequirement")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class ReqCarpoolingController {
    private final IReqCarpoolingService iReqCarpoolingService;

    @PostMapping("/addReqCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RequirementCarpooling addReqCarpooling(@RequestBody RequirementCarpooling requirementCarpooling) {
        return iReqCarpoolingService.addReqCarpooling(requirementCarpooling);
    }
    @PutMapping("/updateReqCarpooling")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public RequirementCarpooling updateReqCarpooling(@RequestBody RequirementCarpooling requirementCarpooling) {
        return iReqCarpoolingService.updateReqCarpooling(requirementCarpooling);
    }

    @DeleteMapping("/deleteReqCarpooling/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public void deleteReqCarpooling(@PathVariable Long id) {
        iReqCarpoolingService.deleteReqCarpooling(id);
    }

    @GetMapping("/getAllReqCarpooling")
    public List<RequirementCarpooling> getAllReqCarpooling() {
        return iReqCarpoolingService.getAllReqCarpooling();
    }

    @GetMapping("/getByIdReqCarpooling/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public RequirementCarpooling getByIdReqCarpooling(@PathVariable Long id) {
        return iReqCarpoolingService.getByIdReqCarpooling(id);
    }
}
