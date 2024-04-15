package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Command;
import tn.esprit.backendpi.Repository.CommandRepository;
import tn.esprit.backendpi.Service.Interfaces.ICommandService;

import java.util.List;
@Service
@RequiredArgsConstructor

public class CommandServiceImpl implements ICommandService {
    private final CommandRepository CommandRepo;

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
}
