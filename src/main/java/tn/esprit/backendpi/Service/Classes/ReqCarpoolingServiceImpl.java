package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Entities.RequirementCarpooling;
import tn.esprit.backendpi.Repository.ReqCarpoolingRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;
import tn.esprit.backendpi.Service.Interfaces.IReqCarpoolingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReqCarpoolingServiceImpl implements IReqCarpoolingService {
    private final ReqCarpoolingRepository reqCarpoolingRepository;

    @Override
    public RequirementCarpooling addReqCarpooling(RequirementCarpooling requirementCarpooling) {
        return reqCarpoolingRepository.save(requirementCarpooling);
    }

    @Override
    public RequirementCarpooling updateReqCarpooling(RequirementCarpooling requirementCarpooling) {
        return reqCarpoolingRepository.save(requirementCarpooling);
    }

    @Override
    public void deleteReqCarpooling(Long id) {
        reqCarpoolingRepository.deleteById(id);
    }

    @Override
    public List<RequirementCarpooling> getAllReqCarpooling() {
        return (List<RequirementCarpooling>) reqCarpoolingRepository.findAll();
    }

    @Override
    public RequirementCarpooling getByIdReqCarpooling(Long id) {
        return reqCarpoolingRepository.findById(id).orElse(null);
    }
}
