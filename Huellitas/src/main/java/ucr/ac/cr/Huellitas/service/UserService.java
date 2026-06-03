package ucr.ac.cr.Huellitas.service;

import ucr.ac.cr.Huellitas.model.User;
import ucr.ac.cr.Huellitas.model.dto.UserDTO;
import ucr.ac.cr.Huellitas.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    @Autowired
    private UserJpaRepository repository;

    public User add(UserDTO user){
        if (repository.existsByEmail(user.getEmail())){
            return null;
        }
        User userTemp = new User();
        userTemp.setName(user.getName());
        userTemp.setEmail(user.getEmail());
        userTemp.setPassword(user.getPassword());
        userTemp.setRole(user.getRole());
        return repository.save(userTemp);
    }
}