package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Dto.OrderDto;
import tn.esprit.backendpi.Entities.Command;
import tn.esprit.backendpi.Entities.CommandItem;
import tn.esprit.backendpi.Entities.Product;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.CommandItemRepository;
import tn.esprit.backendpi.Repository.CommandRepository;
import tn.esprit.backendpi.Repository.ProductRepository;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.ICommandService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CommandServiceImpl implements ICommandService {
    private final CommandRepository CommandRepo;
    private final CommandItemRepository commandItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public Command addCommand(Command command) {
        return CommandRepo.save(command);
    }

    @Override
    public Command updateCommand(Command command) {
        return CommandRepo.save(command);
    }

    @Override
    public void removeCommand(long idCommand) {
        CommandRepo.deleteById(idCommand);

    }

    @Override
    public List<Command> retrieveCommands() {
        return (List<Command>) CommandRepo.findAll();
    }

    @Override
    public Command retrieveCommand(long idCommand) {
        return CommandRepo.findById(idCommand).orElse(null);
    }
    @Override
    public Command ajouterPanier(List<Product> products,String username,String adress,Long tel){
        Optional<User> byUsername = userRepository.findByUsername(username);
        List<CommandItem> commandItems=new ArrayList<>();
        Command command=new Command();
        float  prix = 0;
        for (Product  product:products){
            Product product1=productRepository.findById(product.getIdProduct()).get();
            prix+=product.getPrice();
            System.out.println(product.getIdProduct());
            command.setDateCommand(LocalDate.now());
            command.setPrice(prix);
            command.setUserCommand(byUsername.get());
            command.setDescription("nouvau product ");
            Command save = CommandRepo.save(command);
            CommandItem commandItem=new CommandItem();
            commandItem.setCommand(save);
           commandItem.setIdprod(product1.getIdProduct());
           commandItem.setAdress(adress);
           commandItem.setTel(tel);
            commandItem.setQuantite(products.size());
//commandItemRepository.save(commandItem);
            commandItems.add(commandItem);




        }


        List<CommandItem> commandItems1 = commandItemRepository.saveAll(commandItems);

        return  commandItems1.get(0).getCommand();

        //products.forEach(c->c.getPrice());

    }
    @Override
    public  void payerCommande(Long id){
        Command commandc=CommandRepo.findById(id).get();
        commandc.setStatus("PAYER");
        CommandRepo.save(commandc);
    }
    @Override
    public List<OrderDto> getaLLoRDER(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        List<CommandItem> commandItems=commandItemRepository.findAll();
        List<OrderDto> orderDtos=new ArrayList<>();
        commandItems.forEach(c->{
            OrderDto orderDto=OrderDto.builder().dateCommand(c.getCommand().getDateCommand())
                    .idCommand(c.getCommand().getIdCommand())
                    .title(productRepository.findById(c.getIdprod()).get()
                            .getTitle())
                    .quantite(c.getQuantite())
                    .status(c.getCommand().getStatus())
                    .description(c.getCommand().getDescription())
                    .price(c.getCommand().getPrice())
                    .username(c.getCommand().getUserCommand().getUsername())
                    .adress(c.getCommand().getUserCommand().getEmail())
                    .tel(c.getTel())
                    .adresss(c.getAdress())
                    .build();
            orderDtos.add(orderDto);
        });
        return orderDtos;

    }
}
