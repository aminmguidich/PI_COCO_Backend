package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Repository.ReqCarpoolingRepository;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;

@Service
@RequiredArgsConstructor
public class ReqCarpoolingServiceImpl implements IAnnCarpoolingService {
    private final ReqCarpoolingRepository ReqCarpoolingREpo;
}
