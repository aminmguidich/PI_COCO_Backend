package tn.esprit.backendpi.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Command;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.ICommandService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Command")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class CommandController {
    @Autowired
    ICommandService commandService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/addCommand")
    public Command addCommand(@RequestBody Command command) {
        // Check if the userCommand field is populated
        System.err.print(command);
        if (command.getUserCommand() == null || command.getUserCommand().getId() == null) {
            // Handle the case where userCommand is null or user ID is not provided
            throw new IllegalArgumentException("UserCommand is null or user ID is not provided");
        }

        // Retrieve the User from the database
        User user = userRepository.findById(command.getUserCommand().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Set the user for the command
        command.setUserCommand(user);

        // Call the service method to add the command
        return commandService.addCommand(command);
    }

    @PostMapping("/addCommand2")
    public Command addCommand2(@RequestParam("description")String description , @RequestParam("price") Float price ,
                               @RequestParam("dateCommand") LocalDate dateCommand , @RequestParam("userCommand") Long userCommand) {
        Command command = new Command();

        command.setDescription(description);
        command.setPrice(price);
        command.setDateCommand(dateCommand);
        User user = userRepository.findById(userCommand)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        command.setUserCommand(user);
        return commandService.addCommand(command);
    }
//update command with RequestParam
@PutMapping("/updateCommand2")
public Command updateCommand2(@RequestParam("idCommand") Long idCommand,
                              @RequestParam("description") String description,
                              @RequestParam("price") Float price,
                              @RequestParam("dateCommand") LocalDate dateCommand,
                              @RequestParam("userCommand") Long userCommand) {
    // Retrieve the existing command by its ID
    Command cm = commandService.retrieveCommand(idCommand);
System.err.println(cm);
    // Update the properties of the existing command
    cm.setDescription(description);
    cm.setPrice(price);
    cm.setDateCommand(dateCommand);

    // Retrieve the user associated with the provided ID
    User user = userRepository.findById(userCommand)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

    // Set the user for the command
    cm.setUserCommand(user);
    System.err.println(cm);

    // Update the command in the database
    return commandService.updateCommand(cm);
}
    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/updateCommand")
    public Command updateCommand(@RequestBody Command command) {
        return commandService.updateCommand(command);
    }


    @DeleteMapping("/removeCommand/{idCommand}")
    public void removeCommand(@PathVariable("idCommand") long idCommand) {
        commandService.removeCommand(idCommand);
    }

    @GetMapping("/retrieveCommand")
    public List<Command> retrieveCommands() {
        return commandService.retrieveCommands();
    }


    @GetMapping("/retrieveCommand/{idCommand}")
    public Command retrieveCommand(@PathVariable("idCommand") long idCommand) {
        return commandService.retrieveCommand(idCommand);
    }

}
