package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Contract;

import java.util.List;

public interface IContractService {
    public Contract addContract(Contract contract);
    public List<Contract> getAllContracts();

    public Contract findContractById(Long id);
    public Contract updateContract(Long id, Contract newContract);

    public void deleteContract(Long id);
}
