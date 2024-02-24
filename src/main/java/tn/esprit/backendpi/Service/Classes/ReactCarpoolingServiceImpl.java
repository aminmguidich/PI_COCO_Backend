package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.ReactCarpooling;
import tn.esprit.backendpi.Entities.RequirementCarpooling;
import tn.esprit.backendpi.Repository.RatingCarpoolingRepository;
import tn.esprit.backendpi.Repository.ReactCarpoolingRepository;
import tn.esprit.backendpi.Service.Interfaces.IReactCarpoolingService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReactCarpoolingServiceImpl implements IReactCarpoolingService {
    private final ReactCarpoolingRepository reactCarpoolingRepository;
    @Override
    public ReactCarpooling addReactCarpooling(ReactCarpooling reactCarpooling) {
        return reactCarpoolingRepository.save(reactCarpooling);
    }

    @Override
    public ReactCarpooling updateReactCarpooling(ReactCarpooling reactCarpooling) {
        return reactCarpoolingRepository.save(reactCarpooling);
    }

    @Override
    public void deleteReactCarpooling(Long id) {
        reactCarpoolingRepository.deleteById(id);


    }

    @Override
    public List<ReactCarpooling> getAllReactCarpooling() {
        return (List<ReactCarpooling>) reactCarpoolingRepository.findAll();
    }

    @Override
    public ReactCarpooling getByIdReactCarpooling(Long id) {
        return reactCarpoolingRepository.findById(id).orElse(null);
    }
}
