package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.User;

public interface IUserService { ;
    User retrieveUser(long idUser);
    User update(User user);
}
