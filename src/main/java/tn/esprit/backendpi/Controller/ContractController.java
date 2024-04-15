package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.AnnouncementCollocation;
import tn.esprit.backendpi.Entities.Contract;
import tn.esprit.backendpi.Service.Interfaces.IContractService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Contract")
@CrossOrigin("*")
public class ContractController {
    private final IContractService contractService;

    @PostMapping("/addContract")
    public Contract addContract(@RequestBody Contract contract) {
        return contractService.addContract(contract);
    }

    @PutMapping("/updateContract/{id}")
    public Contract updateContract(@PathVariable Long id, @RequestBody Contract newContract) {
        return contractService.updateContract(id, newContract);
    }

    @GetMapping("/allContracts")
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract findContractById(@PathVariable Long id) {
        return contractService.findContractById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
    }
}
