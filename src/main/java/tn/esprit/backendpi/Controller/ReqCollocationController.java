package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RequirementCollocation;
import tn.esprit.backendpi.Service.Interfaces.IReqCollocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Collocation_Requirement")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class ReqCollocationController {
    private final IReqCollocationService reqCollocationService;

    @PostMapping("/addRequirementCollocation")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RequirementCollocation addRequirementCollocation(@RequestBody RequirementCollocation collocation) {
        return reqCollocationService.addRequirementCollocation(collocation);
    }

    @PutMapping("/updateRequirementCollocation/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RequirementCollocation updateRequirementCollocation(@PathVariable Long id, @RequestBody RequirementCollocation newCollocation) {
        return reqCollocationService.updateRequirementCollocation(id, newCollocation);
    }

    @GetMapping("/allRequirements")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<RequirementCollocation> getAllRequirementCollocations() {
        return reqCollocationService.retrieveAllRequirementCollocations();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RequirementCollocation retrieveRequirementCollocationById(@PathVariable Long id) {
        return reqCollocationService.retrieveRequirementCollocationById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRequirementCollocation(@PathVariable("id") Long id) {
        reqCollocationService.deleteRequirementCollocation(id);
        return ResponseEntity.noContent().build();
    }
}
