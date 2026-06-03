package ucr.ac.cr.Huellitas.controller;

import ucr.ac.cr.Huellitas.model.dto.UserDTO;
import ucr.ac.cr.Huellitas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody UserDTO user, BindingResult result){
        if (result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()){
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        if (service.add(user) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya existe");
        }
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}