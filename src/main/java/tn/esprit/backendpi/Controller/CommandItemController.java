package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.CommandItem;
import tn.esprit.backendpi.Service.Classes.CommandItemServiceImpl;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CommandItem")
public class CommandItemController {
    @Autowired
    private CommandItemServiceImpl commandItemService;

    @PostMapping
    public void createCommandItem(@RequestBody CommandItem commandItem) {
        commandItemService.createCommandItem(commandItem);
    }

    @GetMapping
    public List<CommandItem> findAll() {
        return commandItemService.findAll();
    }

    @PutMapping("/{id}")
    public void updateCommandItem(@RequestBody CommandItem commandItem, @PathVariable long id) {
        commandItemService.UpdatCommandItem(commandItem, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCommandItem(@PathVariable long id) {
        commandItemService.deleteCommandItem(id);
    }

    @DeleteMapping
    public void deleteAll() {
        commandItemService.deleteAll();
    }
}
