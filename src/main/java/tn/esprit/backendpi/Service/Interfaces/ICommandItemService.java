package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.CommandItem;

import java.util.List;

public interface ICommandItemService {
    void createCommandItem(CommandItem commandItem);
    List<CommandItem> findAll();
    void UpdatCommandItem(CommandItem commandItem, long id);
    void deleteCommandItem(long id);
    void deleteAll();
}
