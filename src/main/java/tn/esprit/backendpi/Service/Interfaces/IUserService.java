package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.User;

import java.util.List;

public interface IUserService { ;
    List<User> retrieveAllUsers();
    User update(User user);

}
