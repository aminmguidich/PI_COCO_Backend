package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Dto.OrderDto;
import tn.esprit.backendpi.Entities.Command;
import tn.esprit.backendpi.Entities.Product;

import java.util.List;

public interface ICommandService {

    Command addCommand (Command command);
    Command updateCommand (Command command);
    void removeCommand (long idCommand);
    List<Command> retrieveCommands ();
    Command retrieveCommand (long idCommand);

    Command ajouterPanier(List<Product> products,String username,String adress,Long tel);

    void payerCommande(Long id);

    List<OrderDto> getaLLoRDER();
}
