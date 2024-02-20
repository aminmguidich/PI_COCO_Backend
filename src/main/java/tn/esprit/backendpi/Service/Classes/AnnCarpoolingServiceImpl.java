package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Repository.AnnCarpoolingRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;

@Service
@RequiredArgsConstructor
public class AnnCarpoolingServiceImpl implements IAnnCarpoolingService {
    private final AnnCarpoolingRepository AnnCarpoolingRepo;
}
