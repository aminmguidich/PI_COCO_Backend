package tn.esprit.backendpi.Service.Classes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.IUserService;
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    UserRepository userRepository;

    @Override
    public User retrieveUser(long idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }


}

