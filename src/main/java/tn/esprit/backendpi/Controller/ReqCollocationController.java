package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RequirementCollocation;
import tn.esprit.backendpi.Service.Interfaces.IReqCollocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Collocation_Requirement")
@CrossOrigin("*")
public class ReqCollocationController {
    private final IReqCollocationService reqCollocationService;

    @PostMapping("/addRequirementCollocation")
    public RequirementCollocation addRequirementCollocation(@RequestBody RequirementCollocation collocation) {
        return reqCollocationService.addRequirementCollocation(collocation);
    }

    @PutMapping("/updateRequirementCollocation/{id}")
    public RequirementCollocation updateRequirementCollocation(@PathVariable Long id, @RequestBody RequirementCollocation newCollocation) {
        return reqCollocationService.updateRequirementCollocation(id, newCollocation);
    }

    @GetMapping("/allRequirements")
    public List<RequirementCollocation> getAllRequirementCollocations() {
        return reqCollocationService.retrieveAllRequirementCollocations();
    }

    @GetMapping("/{id}")
    public RequirementCollocation retrieveRequirementCollocationById(@PathVariable Long id) {
        return reqCollocationService.retrieveRequirementCollocationById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequirementCollocation(@PathVariable("id") Long id) {
        reqCollocationService.deleteRequirementCollocation(id);
        return ResponseEntity.noContent().build();
    }
}
