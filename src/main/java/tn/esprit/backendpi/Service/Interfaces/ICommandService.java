package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Command;

import java.util.List;

public interface ICommandService {

    Command addCommand (Command command);
    Command updateCommand (Command command);
    void removeCommand (long idCommand);
    List<Command> retrieveCommands ();
    Command retrieveCommand (long idCommand);
}
