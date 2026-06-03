package ucr.ac.cr.Huellitas.service;

import ucr.ac.cr.Huellitas.model.User;
import ucr.ac.cr.Huellitas.model.dto.UserDTO;
import ucr.ac.cr.Huellitas.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public List<User> getAll(){
        return repository.findAll();
    }

    public User getById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public User update(Integer id, UserDTO userDTO){
        User user = repository.findById(id).orElse(null);
        if (user == null){
            return null;
        }
        if (!user.getEmail().equals(userDTO.getEmail()) && repository.existsByEmail(userDTO.getEmail())){
            return null;
        }
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return repository.save(user);
    }

    public User delete(Integer id){
        User user = repository.findById(id).orElse(null);
        if (user == null){
            return null;
        }
        repository.delete(user);
        return user;
    }
}