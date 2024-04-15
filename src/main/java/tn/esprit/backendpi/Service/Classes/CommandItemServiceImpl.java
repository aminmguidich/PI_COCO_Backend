package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.CommandItem;
import tn.esprit.backendpi.Service.Interfaces.ICommandItemService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommandItemServiceImpl implements ICommandItemService {
    @Override
    public void createCommandItem(CommandItem commandItem) {

    }

    @Override
    public List<CommandItem> findAll() {
        return null;
    }

    @Override
    public void UpdatCommandItem(CommandItem commandItem, long id) {

    }

    @Override
    public void deleteCommandItem(long id) {

    }

    @Override
    public void deleteAll() {

    }
}
