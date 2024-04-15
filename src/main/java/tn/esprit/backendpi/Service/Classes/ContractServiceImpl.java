package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.Contract;
import tn.esprit.backendpi.Repository.ContractRepository;
import tn.esprit.backendpi.Service.Interfaces.IContractService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract addContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> getAllContracts() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public Contract findContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contract not found with ID : " + id));
    }

    @Override
    public Contract updateContract(Long id, Contract newContract) {
        Contract existingContract = contractRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contract not found with ID : " + id));

        existingContract.setDescription(newContract.getDescription());
        // Update other fields if necessary

        return contractRepository.save(existingContract);
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }
}
