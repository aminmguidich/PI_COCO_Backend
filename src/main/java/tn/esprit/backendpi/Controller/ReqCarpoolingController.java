package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.RequirementCarpooling;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;
import tn.esprit.backendpi.Service.Interfaces.IReqCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CarpoolingRequirement")
public class ReqCarpoolingController {
    private final IReqCarpoolingService iReqCarpoolingService;

    @PostMapping("/addReqCarpooling")
    public RequirementCarpooling addReqCarpooling(@RequestBody RequirementCarpooling requirementCarpooling) {
        return iReqCarpoolingService.addReqCarpooling(requirementCarpooling);
    }
    @PutMapping("/updateReqCarpooling")
    public RequirementCarpooling updateReqCarpooling(@RequestBody RequirementCarpooling requirementCarpooling) {
        return iReqCarpoolingService.updateReqCarpooling(requirementCarpooling);
    }

    @DeleteMapping("/deleteReqCarpooling/{id}")
    public void deleteReqCarpooling(@PathVariable Long id) {
        iReqCarpoolingService.deleteReqCarpooling(id);
    }

    @GetMapping("/getAllReqCarpooling")
    public List<RequirementCarpooling> getAllReqCarpooling() {
        return iReqCarpoolingService.getAllReqCarpooling();
    }

    @GetMapping("/getByIdReqCarpooling/{id}")
    public RequirementCarpooling getByIdReqCarpooling(@PathVariable Long id) {
        return iReqCarpoolingService.getByIdReqCarpooling(id);
    }
}
