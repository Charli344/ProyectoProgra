package ucr.ac.cr.Huellitas.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.Huellitas.model.Pet;
import ucr.ac.cr.Huellitas.model.dto.PetDTO;
import ucr.ac.cr.Huellitas.service.PetService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Pet>> getAll() {
        return ResponseEntity.ok(service.getAllPets());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Pet pet = service.getPetById(id);

        if (pet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La mascota no existe");
        }

        return ResponseEntity.ok(pet);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody PetDTO petDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Pet pet = service.createPet(petDTO);

        if (pet == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No fue posible registrar la mascota");
        }

        return ResponseEntity.ok("Mascota registrada exitosamente");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody PetDTO petDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Pet pet = service.updatePet(id, petDTO);

        if (pet == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La mascota no existe");
        }

        return ResponseEntity.ok("Mascota actualizada exitosamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        Pet pet = service.deletePet(id);

        if (pet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La mascota no existe");
        }

        return ResponseEntity.ok("La mascota ha sido eliminada");
    }
}