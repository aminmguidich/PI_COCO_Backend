package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Delivery;
import tn.esprit.backendpi.Repository.DeliveryRepository;
import tn.esprit.backendpi.Service.Interfaces.IDeliveryService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements IDeliveryService {
    private final DeliveryRepository DeliveryRepo;
    @Override
    public Delivery addDelivery(Delivery delivery) {
        return DeliveryRepo.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        return DeliveryRepo.save(delivery);
    }

    @Override
    public void removeDelivery(long idDelivery) {
        DeliveryRepo.deleteById(idDelivery);
    }

    @Override
    public List<Delivery> retrieveDeliveries() {
        return (List<Delivery>) DeliveryRepo.findAll();
    }

    @Override
    public Delivery retrieveDelivery(long idDelivery) {
        return DeliveryRepo.findById(idDelivery).orElse(null);
    }
}
