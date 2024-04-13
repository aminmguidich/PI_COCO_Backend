package tn.esprit.backendpi.Service.Classes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Claims;
import tn.esprit.backendpi.Repository.ClaimRespository;
import tn.esprit.backendpi.Service.Interfaces.IClaimService;

@AllArgsConstructor
@Service
public class ClaimServiceImp implements IClaimService {
    ClaimRespository claimRespository;
    @Override
    public Claims add(Claims claim) {
        return claimRespository.save(claim);
    }

    @Override
    public Claims retreive(long idClaim) {

        return claimRespository.findById(idClaim).orElse(null);
    }
}
