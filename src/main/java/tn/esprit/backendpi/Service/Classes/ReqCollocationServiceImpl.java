package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.RequirementCollocation;
import tn.esprit.backendpi.Repository.ReqCollocationRepository;
import tn.esprit.backendpi.Service.Interfaces.IReqCollocationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReqCollocationServiceImpl implements IReqCollocationService {
    private final ReqCollocationRepository reqCollocationRepository;

    @Override
    public RequirementCollocation addRequirementCollocation(RequirementCollocation collocation) {
        return reqCollocationRepository.save(collocation);
    }

    @Override
    public RequirementCollocation updateRequirementCollocation(Long id, RequirementCollocation newCollocation) {
        RequirementCollocation oldCollocation = reqCollocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Collocation requirement not found with ID : " + id));

        // Update fields of the old requirement with values from the new requirement
        oldCollocation.setDescription(newCollocation.getDescription());
        oldCollocation.setDateCarpoolingCollocation(newCollocation.getDateCarpoolingCollocation());
        oldCollocation.setBudgetPart(newCollocation.getBudgetPart());
        oldCollocation.setUniversityYear(newCollocation.getUniversityYear());
        oldCollocation.setStatus(newCollocation.getStatus());
        // Update other fields as required...

        // Save the modifications in the database and return the updated requirement
        return reqCollocationRepository.save(oldCollocation);
    }

    @Override
    public List<RequirementCollocation> retrieveAllRequirementCollocations() {
        return (List<RequirementCollocation>) reqCollocationRepository.findAll();
    }

    @Override
    public RequirementCollocation retrieveRequirementCollocationById(Long id) {
        return reqCollocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Collocation requirement not found with ID : " + id));
    }

    @Override
    public void deleteRequirementCollocation(Long id) {
        reqCollocationRepository.deleteById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequirement(@PathVariable("id") Long id) {
        reqCollocationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
