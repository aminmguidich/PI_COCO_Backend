package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Claims;

import java.util.List;

public interface IClaimService {
    Claims add (Claims claim);
    Claims retreive (long idClaim);
}
